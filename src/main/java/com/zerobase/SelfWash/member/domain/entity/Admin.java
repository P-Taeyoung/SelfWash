package com.zerobase.SelfWash.member.domain.entity;

import com.zerobase.SelfWash.member.domain.form.AdminSignUpForm;
import com.zerobase.SelfWash.member.domain.form.SignUpForm;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String memberId;
  private String password;
  private String phone;
  private String name;

  private boolean adminAuthYn;

  public static Admin signUpFrom(AdminSignUpForm signUpForm) {
    return Admin.builder()
        .memberId(signUpForm.getMemberId())
        //TODO 나중에 BCrypt.hashpw(signUpForm.getPassword(), BCrypt.gensalt()) 로 변경
        .password(signUpForm.getPassword())
        .phone(signUpForm.getPhone())
        .name(signUpForm.getName())
        .adminAuthYn(false)
        .build();
  }
}
