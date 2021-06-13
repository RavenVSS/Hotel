package com.example.hotel.controller.users;

import com.example.hotel.controller.users.dto.in.UserCreateDto;
import com.example.hotel.model.users.UserCreateArg;
import com.example.hotel.service.users.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Users", description = "Операции с пользователями")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("registration")
    @PreAuthorize("permitAll()")
    @ApiOperation(value = "Регистрация", nickname = "New user")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addNewUser(@RequestBody UserCreateDto userCreateDto) {
        UserCreateArg userCreateArg = userMapper.fromDto(userCreateDto);
        userService.create(userCreateArg);
    }
}
