package com.simbirsoft.habbitica.api.services;

import com.simbirsoft.habbitica.impl.models.data.User;
import com.simbirsoft.habbitica.impl.models.dto.UserDto;
import com.simbirsoft.habbitica.impl.models.form.UserForm;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    UserDto save(UserForm userForm);

    void addReward(Long reward, User user);

    void takeTask(Long taskId, User user);

    void removeTask(Long taskId, User user);

    void changeData(User user, MultipartFile file, String newName);
}
