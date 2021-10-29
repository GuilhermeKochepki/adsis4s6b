package com.unicesumar.adsis4s2021.dozero.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequisiçãoPutInválido extends RuntimeException {

}
