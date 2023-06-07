package org.learn.routerservice.exception;

public class PathDoesNotExistException extends Exception{
    public PathDoesNotExistException(String message) {
        super(message);
    }
}
