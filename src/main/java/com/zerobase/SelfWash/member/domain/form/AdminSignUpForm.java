package com.zerobase.SelfWash.member.domain.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminSignUpForm {
  private String memberId;
  private String password;
  private String phone;
  private String name;
}
