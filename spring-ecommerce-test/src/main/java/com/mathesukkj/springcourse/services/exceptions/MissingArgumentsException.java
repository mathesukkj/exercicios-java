package com.mathesukkj.springcourse.services.exceptions;

public class MissingArgumentsException extends RuntimeException {
    public MissingArgumentsException() {
        super("Fields missing!");
    }
}
