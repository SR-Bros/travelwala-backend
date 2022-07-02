package com.ict.group06.travelwala.common.exception;

public abstract class WalaException extends RuntimeException {
    protected String message;
    protected int code;

    public WalaErrorResponse getErrorResponse() {
        return new WalaErrorResponse(this.getClass().getName(), this.message, this.code);
    }
}
