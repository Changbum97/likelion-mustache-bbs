package com.mustache.springbootmustachebbs.user_exercise.repository;

import com.mustache.springbootmustachebbs.user_exercise.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
