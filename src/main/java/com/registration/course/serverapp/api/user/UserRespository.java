package com.registration.course.serverapp.api.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, Integer> {

  // Query Method
  public boolean existsByUsername(String username);
}
