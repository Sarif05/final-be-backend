package com.registration.course.serverapp.api.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {

  @Autowired
  MemberRespository memberRespository;

  public List<Member> getAllMembers() {
    return memberRespository.findAll();
  }

  public Member getMemberById(Integer id) {
    return memberRespository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("member ", 0));
  }

  public Member updateMember(Integer id, Member member) {
    Member chekingMember = this.getMemberById(id);
    if (!chekingMember.getEmail().equalsIgnoreCase(member.getEmail())) {
      if (memberRespository.existsByEmail(member.getEmail())) {
        throw new DataIntegrityViolationException("Email");
      }
    }
    member.setId(id);
    return memberRespository.save(member);
  }
}
