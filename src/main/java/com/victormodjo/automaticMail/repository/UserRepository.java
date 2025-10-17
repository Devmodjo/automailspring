package com.victormodjo.automaticMail.repository;

import com.victormodjo.automaticMail.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
}
