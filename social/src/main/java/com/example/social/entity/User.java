package com.example.social.entity;

import com.example.social.dto.Role;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {

    /**
     * Serializable
         자바 시스템 내부에서 사용되는 Object 또는 Data를 외부의 자바 시스템에서도 사용할 수 있도록 바이트 형태로 데이터를 변환하는 기술로써,
         JVM의 메모리에 상주되어 있는 객체 데이터를 바이트 형태로 변환하는 기술이다.
         다차원의 자료를 파일로 저장하거나 네트워크로 보내기에 알맞게 일차원으로 펼치고 다시 원래대로 되돌리는 것을 직렬화(serialization)이라고 부른다.
         역직렬화는 직렬화의 반대를 의미한다.(바이트 => data, object)

     * 다음에 할 것 카카오 페이스북 연동
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
