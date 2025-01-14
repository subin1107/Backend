package com.kusitms.hotsixServer.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kusitms.hotsixServer.domain.user.dto.GoogleUser;
import com.kusitms.hotsixServer.domain.user.dto.UserDto;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "user_email", unique = true, nullable = false)
    private String userEmail;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "user_img", columnDefinition = "TEXT", nullable = false)
    private String userImg;

    @JsonIgnore
    @Column(name="password")
    private String password;

    public static User createUser (GoogleUser googleUser, PasswordEncoder passwordEncoder) {

        return User.builder()
                .userName(googleUser.getName())
                .userEmail(googleUser.getEmail())
                .userImg(googleUser.getPicture())
                .password(passwordEncoder.encode("google"))
                .build();
    }

}
