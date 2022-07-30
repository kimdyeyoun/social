package com.example.social.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
@AllArgsConstructor
public class BaseController {

    @GetMapping("/")
    public ModelAndView index(ModelAndView mv)
    {
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/user")
    public ModelAndView user(ModelAndView mv)
    {
        mv.setViewName("user");
        return mv;
    }

    private static String authorizationRequestBaseUri = "oauth2/authorization";
    Map<String, String> oauth2AuthenticationUrls = new HashMap<>();
    private ClientRegistrationRepository clientRegistrationRepository;

    // 로그인 시도 이후 받아온 정보
    private OAuth2AuthorizedClientService nnnnnn;

    @GetMapping("/login")
    public String login(Model model) throws Exception{
        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);
        if (type != ResolvableType.NONE &&
                ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        }
        assert clientRegistrations != null;
        clientRegistrations.forEach(registration ->
                oauth2AuthenticationUrls.put(registration.getClientName(),
                        authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
        model.addAttribute("urls", oauth2AuthenticationUrls);

        return "login";
    }

    @GetMapping("/login/{oauth2}")
    public String loginGoogle(@PathVariable String oauth2, HttpServletRequest httpServletRequest)
    {
        return "redirect:/oauth2/authorization/" + oauth2;
    }

    @RequestMapping("/accessDenied")
    public ModelAndView accessDenied(ModelAndView mv) {
        mv.setViewName("accessDenied");
        return mv;
    }
}
