package com.example.social.service;

import com.example.social.domain.UserRepository;
import com.example.social.dto.Role;
import com.example.social.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomOauth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    final UserRepository userRepository;

    final HttpSession httpSession;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService deleteGate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = deleteGate.loadUser(userRequest);

        //TODO 구글,네이버 구분 (구글: google, 네이버: naver)
        String socialId = userRequest.getClientRegistration().getRegistrationId();

        //TODO return OAuth2 정보가 들어감
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        String email;
        Map<String, Object> response = oAuth2User.getAttributes();

        if(socialId.equals("naver"))
        {
            //TODO 정보 가져옴
            Map<String, Object> hash = (Map<String, Object>) response.get("response");

            email = (String) hash.get("email");

        }
        else if (socialId.equals("google"))
        {
            email = (String) response.get("email");
        }
        else
        {
            throw new OAuth2AuthenticationException("허용되지 않는 인증입니다");
        }

        User user;
        Optional<User> optionalUser = userRepository.findByEmail(email);

        //TODO 이미 가입한 사람
        if (optionalUser.isPresent())
        {
            user = optionalUser.get();
            System.out.println("로그인 성공 : " + user);
        }
        else
        {
            //TODO 신규 가입
            user = new User();
            user.setEmail(email);
            user.setRole(Role.ROLE_USER);
            userRepository.save(user);
        }

        httpSession.setAttribute("user", user);


        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRole().toString()))
                , oAuth2User.getAttributes()
                , userNameAttributeName);
    }
}
