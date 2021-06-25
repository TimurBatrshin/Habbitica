package com.simbirsoft.habbitica.api.services;

import com.simbirsoft.habbitica.impl.models.data.User;
import com.simbirsoft.habbitica.impl.models.dto.UserDto;
import com.simbirsoft.habbitica.impl.models.form.UserForm;

import java.util.List;

public interface UserService {

    UserDto save(UserForm userForm);

    void addReward(Long reward, User user);

    void takeTask(Long taskId, User user);

    void removeTask(Long taskId, User user);

    List<UserDto> findAllByUser(Long id);

    List<UserDto> findSubscription(Long user_id);

    User findById(Long id);

    void addUser(Long user_id, Long id);
}
