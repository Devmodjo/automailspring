package com.victormodjo.automaticMail.repository;

import com.victormodjo.automaticMail.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface UserRepository extends JpaRepository<Users, Long> {
}
