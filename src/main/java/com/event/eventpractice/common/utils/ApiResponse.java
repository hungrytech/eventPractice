package com.event.eventpractice.common.utils;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ApiResponse <T> {
    private boolean success;
    private T data;

    @Builder
    public ApiResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
    }
}
