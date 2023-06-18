package com.registration.course.serverapp.api.role;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleService {

  @Autowired
  RoleRepository roleRepository;

  public List<Role> getAll() {
    return roleRepository.findAll();
  }

  public Role create(Role role) {
    return roleRepository.save(role);
  }

  public Role getById(Integer id) {
    return roleRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
  }

  public Role update(Integer id, Role role) {
    this.getById(id);
    role.setId(id);
    return roleRepository.save(role);
  }

  public Role delete(Integer id) {
    Role role = this.getById(id);
    roleRepository.delete(role);
    return role;
  }
}
