package com.mathesukkj.springcourse.services.exceptions;

import java.util.NoSuchElementException;

public class ResourceNotFoundException extends NoSuchElementException {
    public ResourceNotFoundException(Integer id) {
        super("Resource not found. ID: " + id);
    }
}