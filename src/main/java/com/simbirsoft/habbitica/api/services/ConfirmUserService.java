package com.simbirsoft.habbitica.api.services;

import com.simbirsoft.habbitica.impl.models.data.ConfirmUser;
import com.simbirsoft.habbitica.impl.models.data.User;

import java.util.Optional;

public interface ConfirmUserService {

    Optional<User> confirmUserByToken(String token);

    Optional<ConfirmUser> getByToken(String token);
}