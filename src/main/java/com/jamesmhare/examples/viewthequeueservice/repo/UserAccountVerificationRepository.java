package com.jamesmhare.examples.viewthequeueservice.repo;

import com.jamesmhare.examples.viewthequeueservice.model.user.User;
import com.jamesmhare.examples.viewthequeueservice.model.user.UserAccountVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserAccountVerificationRepository extends JpaRepository<UserAccountVerification, UUID> {

    UserAccountVerification findByUser(final User user);

    Optional<UserAccountVerification> findUserAccountVerificationByUserEmail(final String email);

    List<UserAccountVerification> findAllByExpiryDateBefore(final Date date);

}
