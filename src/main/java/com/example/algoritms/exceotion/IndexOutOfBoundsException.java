package com.example.algoritms.exceotion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IndexOutOfBoundsException extends RuntimeException {
    public IndexOutOfBoundsException(String message) {
        super("Индекс выходит за пределы списка");
    }
}
