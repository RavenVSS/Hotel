package com.example.hotel.controller.profiles;

import com.example.hotel.controller.profiles.dto.in.ProfileCreateDto;
import com.example.hotel.controller.profiles.dto.out.ProfileDto;
import com.example.hotel.service.profiles.ProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profiles")
@Api(tags = "Profiles", description = "Операции с профилями")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    @PostMapping("create")
    @ApiOperation(value = "Создать новый профиль", nickname = "New profile")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addNewProfile(@RequestBody ProfileCreateDto profileCreateDto){
        profileService.create(profileMapper.fromDto(profileCreateDto));
    }

    @PostMapping("{id}/update")
    @ApiOperation(value = "Обновить профиль по ID", nickname = "Update profile")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateProfile(@RequestBody ProfileCreateDto profileCreateDto,
                              @PathVariable("id") Integer id){
        profileService.update(profileMapper.fromDto(profileCreateDto), id);
    }

    @PostMapping("{id}/delete")
    @ApiOperation(value = "Удалить профиль по ID", nickname = "Delete profile")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProfile(@PathVariable("id") Integer id){
        profileService.delete(id);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Получить профиль по ID", nickname = "Get at profile")
    @ResponseStatus(value = HttpStatus.OK)
    public ProfileDto getAtProfile(@PathVariable("id") Integer id){
        return profileMapper.toDto(profileService.findAt(id));
    }

    @GetMapping("search/{userId}")
    @ApiOperation(value = "Найти профиль по ID пользователя", nickname = "Get profile by UserId")
    @ResponseStatus(value = HttpStatus.OK)
    public ProfileDto getProfileByUserId(@PathVariable("userId") Integer userId){
        return profileMapper.toDto(profileService.findByUserId(userId));
    }
}
