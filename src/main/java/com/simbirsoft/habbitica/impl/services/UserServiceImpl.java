package com.simbirsoft.habbitica.impl.services;

import com.simbirsoft.habbitica.api.repositories.UserRepository;
import com.simbirsoft.habbitica.api.services.UserService;
import com.simbirsoft.habbitica.impl.models.data.User;
import com.simbirsoft.habbitica.impl.models.dto.UserDto;
import com.simbirsoft.habbitica.impl.models.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.simbirsoft.habbitica.impl.models.dto.UserDto.from;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto save(UserForm userForm) {

        User user = User.builder()
                .email(userForm.getEmail())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .username(userForm.getUsername())
                .build();

        userRepository.save(user);

        return from(user);
    }
}
