package com.registration.course.serverapp.api.authentication;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.registration.course.serverapp.api.dto.request.UserRequest;
import com.registration.course.serverapp.api.member.Member;
import com.registration.course.serverapp.api.role.Role;
import com.registration.course.serverapp.api.role.RoleService;
import com.registration.course.serverapp.api.user.User;
import com.registration.course.serverapp.api.user.UserRespository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {

  @Autowired
  UserRespository userRespository;

  @Autowired
  ModelMapper modelMapper;

  @Autowired
  RoleService roleService;

  public User register(UserRequest userRequest) {
    Member member = modelMapper.map(userRequest, Member.class);
    User user = modelMapper.map(userRequest, User.class);

    member.setUser(user);
    user.setMember(member);

    if (userRespository.existsByUsername(userRequest.getUsername())) {
      throw new DataIntegrityViolationException("username");
    }

    // set default role
    List<Role> roles = new ArrayList<>();
    roles.add(roleService.getById(1));
    user.setRoles(roles);

    // set password with encoded
    // .....

    return userRespository.save(user);
  }
}
