package com.db.empl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException {
        private String errorCode;
        public CustomException(String message, String errorCode) {
            super(message);
            this.errorCode = errorCode;
        }

        public CustomException(String message){
            super(message);
            this.errorCode = "400";
        }
}
