package com.example.hotel.controller.users;

import com.example.hotel.controller.users.dto.in.UserCreateDto;
import com.example.hotel.controller.users.dto.out.UserDto;
import com.example.hotel.model.users.UserCreateArg;
import com.example.hotel.service.authentication.AuthenticationServiceImpl;
import com.example.hotel.service.email.EmailService;
import com.example.hotel.service.users.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Users", description = "Операции с пользователями")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationServiceImpl authService;
    private final UserMapper userMapper;
    private final EmailService emailService;

    @PostMapping("registration")
    @PreAuthorize("permitAll()")
    @ApiOperation(value = "Регистрация. Доступ: Для всех", nickname = "New user")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addNewUser(@RequestBody UserCreateDto userCreateDto) {
        UserCreateArg userCreateArg = userMapper.fromDto(userCreateDto);
        userService.create(userCreateArg);
    }

    @GetMapping("current")
    @PreAuthorize("hasRole('WORKER') || hasRole('USER')")
    @ApiOperation(value = "Данные о текущем пользователе. Доступ: USER || WORKER", nickname = "Get current user")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDto getCurrentUser() {
        return userMapper.toDto(authService.getCurrentUser());
    }

    @GetMapping("{id}/sendPassword")
    @PreAuthorize("hasRole('WORKER')")
    @ApiOperation(value = "Отправить логин пользователю на Email. Доступ: WORKER", nickname = "Send password for user")
    @ResponseStatus(value = HttpStatus.OK)
    public void sendPassword(@PathVariable("id") Integer userId) {
        emailService.sendUserData(userService.findAt(userId));
    }

    @GetMapping("confirm")
    @ApiOperation(value = "Для подтверждения Email (Ссылка высылается при регистрации). Доступ: Для всех", nickname = "Confirm email")
    @PreAuthorize("permitAll()")
    @ResponseStatus(value = HttpStatus.OK)
    public void confirmEmail(@RequestParam("hash") String hash,
                             @RequestParam("id") Integer id) {
        userService.confirm(hash, id);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Данные о пользователе по ID. Доступ: WORKER", nickname = "Get user")
    @PreAuthorize("hasRole('WORKER')")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDto getAtUser(@PathVariable("id") Integer id) {
        return userMapper.toDto(userService.findAt(id));
    }

    @GetMapping("search/name")
    @ApiOperation(value = "Поиск пользователя по имени и фамилии. Доступ: WORKER", nickname = "Get user by name")
    @PreAuthorize("hasRole('WORKER')")
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserDto> getUserByName(@RequestParam("firstName") String firstName,
                                       @RequestParam("secondName") String secondName) {
        return userMapper.toList(userService.findByName(firstName, secondName));
    }

    @GetMapping("search/login")
    @ApiOperation(value = "Поиск пользователя по логину. Доступ: WORKER", nickname = "Get user by login")
    @PreAuthorize("hasRole('WORKER')")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDto getUserByName(@RequestParam("login") String login) {
        return userMapper.toDto(userService.findByLogin(login));
    }
}