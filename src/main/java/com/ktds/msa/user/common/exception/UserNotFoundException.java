package com.ktds.msa.user.common.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("사용자를 찾을수 없습니다.");
    }

    public UserNotFoundException(String userId) {
        super( userId + " 사용자를 찾을수 없습니다.");
    }

}
