package com.registration.course.serverapp.api.privilege;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PrivilegeService {

  @Autowired
  private PrivilegeRepository privilegeRepository;

  public List<Privilege> getAll() {
    return privilegeRepository.findAll();
  }

  public Privilege create(Privilege privilege) {
    return privilegeRepository.save(privilege);
  }

  public Privilege getById(Integer id) {
    return privilegeRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException());
  }

  public Privilege delete(Integer id) {
    Privilege privilege = this.getById(id);
    privilegeRepository.delete(privilege);
    return privilege;
  }

  public Privilege update(Integer id, Privilege privilege) {
    this.getById(id);
    privilege.setId(id);
    return privilegeRepository.save(privilege);
  }

}
