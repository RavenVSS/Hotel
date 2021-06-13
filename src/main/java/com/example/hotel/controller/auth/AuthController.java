package com.example.hotel.controller.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Api(tags = "Auth", description = "Операции с авторизацией")
@RequestMapping("auth")
class AuthController {

    @GetMapping("user")
    @ApiOperation(value = "Получить данные о текущем пользователе", nickname = "Auth")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }
}
