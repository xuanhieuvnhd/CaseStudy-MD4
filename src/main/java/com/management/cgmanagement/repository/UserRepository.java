package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.dto.ITuition;
import com.management.cgmanagement.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserById(Long id);
    Optional<User> findByFullName(String name);

    Page<User> findAllByFullName(String Name, Pageable pageable);

    Optional<User> findByEmail(String mail);

    @Query(nativeQuery = true ,value = "select * from users join user_roles on users.id = user_roles.user_id join role on user_roles.role_id = role.id;")
    Iterable<User> getUserNative();
}
