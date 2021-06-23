package com.simbirsoft.habbitica.api.services;

import com.simbirsoft.habbitica.impl.models.dto.UserDto;
import com.simbirsoft.habbitica.impl.models.form.UserForm;

public interface UserService {

    UserDto save(UserForm userForm);
}
