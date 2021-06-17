package com.example.hotel.service.users;

import com.example.hotel.exceptions.EntityNotFoundException;
import com.example.hotel.exceptions.LoginIsNotFreeException;
import com.example.hotel.model.users.User;
import com.example.hotel.model.users.UserCreateArg;
import com.example.hotel.model.users.UserTypes;
import com.example.hotel.repository.users.UserRepository;
import com.example.hotel.service.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;

    @Override
    @Transactional
    public void create(UserCreateArg arg) {

        if (userRepository.findOptionalByLogin(arg.getLogin()).isPresent()) {
            throw new LoginIsNotFreeException("Login is not free");
        }

        User user = userRepository.save(User.builder()
                .login(arg.getLogin())
                .password(arg.getPassword())
                .email(arg.getEmail())
                .phone(arg.getPhone())
                .salt("0")
                .cookie(UUID.randomUUID().toString())
                .regDate(new Date())
                .type(UserTypes.ROLE_USER)
                .firstName(arg.getFirstName())
                .secondName(arg.getSecondName())
                .middleName(arg.getMiddleName())
                .build());

        emailService.sendConfirm(user);
    }

    @Override
    @Transactional
    public void update(UserCreateArg arg, Integer userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.setLogin(arg.getLogin());
        user.setPassword(arg.getPassword());
        user.setEmail(arg.getEmail());
        user.setPhone(arg.getPhone());
        user.setFirstName(arg.getFirstName());
        user.setSecondName(arg.getSecondName());
        user.setMiddleName(arg.getMiddleName());

        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Integer userId) {

        userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        userRepository.deleteById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findAt(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public User findByLogin(String login) {
        return userRepository.findOptionalByLogin(login)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public void confirm(String hash, Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        String userHash = user.getCookie();
        if (userHash.equals(hash)) {
            //TODO confirmed
        } else throw new EntityNotFoundException("Hash error");
    }
}
