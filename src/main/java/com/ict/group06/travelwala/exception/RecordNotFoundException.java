package com.ict.group06.travelwala.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RecordNotFoundException extends RuntimeException {
    private String message;
}
