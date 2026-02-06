package com.TechPulse.Demo.repository;

import com.TechPulse.Demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
