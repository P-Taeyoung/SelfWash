package com.zerobase.SelfWash.member.domain.entity;

import com.zerobase.SelfWash.member.domain.form.SignUpForm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner extends BaseEntity implements Member{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true)
  private String email;

  private String password;
  private String phone;
  private String name;
  private String account;

  private String emailAuthKey;
  private boolean emailAuthYn;

  public static Owner signUpFrom(SignUpForm signUpForm) {
    return Owner.builder()
        .email(signUpForm.getEmail())
        //TODO 나중에 BCrypt.hashpw(signUpForm.getPassword(), BCrypt.gensalt()) 로 변경
        .password(signUpForm.getPassword())
        .phone(signUpForm.getPhone())
        .name(signUpForm.getName())
        .account(signUpForm.getAccount())
        .emailAuthKey(signUpForm.getEmailAuthKey())
        .emailAuthYn(false)
        .build();
  }
}
