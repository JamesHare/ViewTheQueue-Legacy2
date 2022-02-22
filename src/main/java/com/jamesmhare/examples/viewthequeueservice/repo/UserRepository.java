package com.jamesmhare.examples.viewthequeueservice.repo;

import com.jamesmhare.examples.viewthequeueservice.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findAllByOrderByUserIdAsc();

    User findByEmail(final String email);

}