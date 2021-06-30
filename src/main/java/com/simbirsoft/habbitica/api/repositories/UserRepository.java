package com.simbirsoft.habbitica.api.repositories;

import com.simbirsoft.habbitica.impl.models.data.User;
import com.simbirsoft.habbitica.impl.models.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(
            nativeQuery = true,
            value = "select * from account where id <>:user_id"
    )
    List<User> findAllByUser(Long user_id);

    @Query(
            nativeQuery = true,
            value = "select * from subscription join account a on a.id = subscription.subscriber_id where user_id = :user_id"
    )
    List<User> findSubscription(Long user_id);

    Optional<User> findByEmail(String email);
}