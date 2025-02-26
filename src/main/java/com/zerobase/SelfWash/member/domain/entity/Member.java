package com.zerobase.SelfWash.member.domain.entity;

import com.zerobase.SelfWash.member.domain.form.SignUpForm;

public interface Member {
  boolean isEmailAuthYn();
  String getEmailAuthKey();
  void setEmailAuthYn(boolean emailAuthYn);
}
