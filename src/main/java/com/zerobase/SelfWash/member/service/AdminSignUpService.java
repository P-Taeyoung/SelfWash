package com.zerobase.SelfWash.member.service;

import com.zerobase.SelfWash.member.domain.form.AdminSignUpForm;
import com.zerobase.SelfWash.member.domain.form.SignUpForm;

public interface AdminSignUpService {

  void signUp(AdminSignUpForm form);

}
