package com.zestic.gateway.app.exception;

import com.zestic.springboot.common.exception.ApplicationError;
import lombok.Getter;

@Getter
public enum GatewayError implements ApplicationError {

    SYSTEM_ERROR(1, "System exception"),
    SYSTEM_BUSY(0x000001, "The system is busy, please try again later"),

    GATEWAY_NOT_FOUND_SERVICE(0x010404, "Service not found"),
    GATEWAY_ERROR(0x10500, "Gateway exception"),
    GATEWAY_CONNECT_TIME_OUT(0x010002, "Gateway timed out"),

    ARGUMENT_NOT_VALID(0x020000, "Request parameter verification failed"),
    INVALID_TOKEN(0x020001, "Invalid token"),
    UPLOAD_FILE_SIZE_LIMIT(0x020010, "Upload file size exceeds limit"),

    DUPLICATE_PRIMARY_KEY(0x030000, "Unique key conflict");

    private Integer code;
    private String message;

    GatewayError(Integer code, String mesg) {
        this.code = code;
        this.message = mesg;
    }
}
