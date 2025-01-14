package com.kusitms.hotsixServer.domain.user.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

public class UserConstants {
    @Getter
    @RequiredArgsConstructor
    public enum EBoardResponseMessage{
        LOGIN_SUCCESS("로그인에 성공했습니다"),
        LOGOUT_SUCCESS("로그아웃에 성공했습니다."),
        SET_FILTER_SUCCESS("사용자 필터 등록에 성공했습니다."),
        REGENERATE_TOKEN_SUCCESS("토큰 재발급에 성공했습니다.");
        private final String message;
    }
    @Getter
    @RequiredArgsConstructor
    public enum EToken{
        eRefreshToken("RT:");
        private final String message;
    }
}
