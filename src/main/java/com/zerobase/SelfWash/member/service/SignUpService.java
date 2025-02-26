package com.zerobase.SelfWash.member.service;

import com.zerobase.SelfWash.member.domain.entity.Member;
import com.zerobase.SelfWash.member.domain.form.SignUpForm;
import com.zerobase.SelfWash.member.domain.type.MemberType;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public interface SignUpService {

  boolean support(MemberType type);

  void signUp(SignUpForm form);

  void verifyEmail(String email, String key);


  default void validateEmail(SignUpForm form
      , Predicate<String> existsByEmail) {
    if (existsByEmail.test(form.getEmail())) {
      throw new RuntimeException("이미 존재하는 이메일 입니다.");
    }
  }

  default void verifyEmail(String email
      , String key
      , Function<String, Optional<? extends Member>> findByEmail) {
    
    Member member = findByEmail.apply(email)
        .orElseThrow(()-> new RuntimeException("존재하지 않는 이메일입니다."));
    if (member.isEmailAuthYn()) {
      throw new RuntimeException("이미 인증받은 이메일입니다.");
    }
    if (!member.getEmailAuthKey().equals(key)) {
      throw new RuntimeException("인증키가 일치하지 않습니다.");
    }
    member.setEmailAuthYn(true);
  }




}
