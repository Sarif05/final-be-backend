package com.registration.course.serverapp.api.role;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.registration.course.serverapp.api.privilege.Privilege;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @NotBlank(message = "nama tidak boleh kosong")
  @Column(name = "name", nullable = false)
  private String name;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "tb_role_privilege", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "privilege_id"))
  private List<Privilege> privileges;
}
