package com.xroneteach.spring_ecom.repository;

import com.xroneteach.spring_ecom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByMobile(String mobile);
    Collection<Object> findByEmailAndPassword(String email, String password);
}
