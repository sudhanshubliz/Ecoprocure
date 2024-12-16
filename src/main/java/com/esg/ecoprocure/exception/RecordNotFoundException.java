package com.esg.ecoprocure.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(value = HttpStatus.NOT_FOUND,
        reason = "Requested resource is not available")
public class RecordNotFoundException extends RuntimeException implements Serializable {

}
