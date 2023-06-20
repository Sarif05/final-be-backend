package com.registration.course.serverapp.api.transaction;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.registration.course.serverapp.api.course.Course;
import com.registration.course.serverapp.api.member.Member;
import com.registration.course.serverapp.api.transaction.history.History;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_transaction")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "course_id", nullable = false)
  private Course course;

  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "member_id", nullable = false)
  private Member member;

  @Enumerated(EnumType.STRING)
  private TransactionStatus status;

  private Boolean is_registered = false;

  private Timestamp created_at;

  @OneToMany(mappedBy = "transaction")
  private List<History> histories;

}
