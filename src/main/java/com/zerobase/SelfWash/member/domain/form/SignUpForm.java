package com.zerobase.SelfWash.member.domain.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpForm {
  private String email;
  private String password;
  private String phone;
  private String name;
  private String account;
  private String emailAuthKey;
}
