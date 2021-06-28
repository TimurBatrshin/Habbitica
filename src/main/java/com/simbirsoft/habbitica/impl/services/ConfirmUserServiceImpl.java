package com.simbirsoft.habbitica.impl.services;

import com.simbirsoft.habbitica.api.repositories.ConfirmUserRepository;
import com.simbirsoft.habbitica.api.repositories.UserRepository;
import com.simbirsoft.habbitica.api.services.ConfirmUserService;
import com.simbirsoft.habbitica.impl.models.data.ConfirmUser;
import com.simbirsoft.habbitica.impl.models.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfirmUserServiceImpl implements ConfirmUserService {

    private ConfirmUserRepository confirmUserRepository;
    private UserRepository userRepository;

    @Autowired
    public ConfirmUserServiceImpl(ConfirmUserRepository confirmUserRepository,
                                  UserRepository userRepository) {
        this.confirmUserRepository = confirmUserRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> confirmUserByToken(String token) {

        ConfirmUser confirmUser = getByToken(token)
                .orElseThrow(() -> new UsernameNotFoundException("Not found"));

        User user = userRepository.findById(confirmUser.getUser().getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (user.getState().equals(User.State.NOT_CONFIRMED)) {
            user.setState(User.State.ACTIVE);
            userRepository.save(user);
            return Optional.of(user);
        } else {
            throw new UsernameNotFoundException("User is already confirmed or banned");
        }
    }

    @Override
    public Optional<ConfirmUser> getByToken(String token) {

        return confirmUserRepository.findTokenByToken(token);
    }
}
