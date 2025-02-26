package com.zerobase.SelfWash.member.controller;

import static com.zerobase.SelfWash.member.domain.type.MemberType.CUSTOMER;
import static com.zerobase.SelfWash.member.domain.type.MemberType.OWNER;

import com.zerobase.SelfWash.member.application.SignUpApplication;
import com.zerobase.SelfWash.member.domain.form.AdminSignUpForm;
import com.zerobase.SelfWash.member.domain.form.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignUpController {

  private final SignUpApplication signUpApplication;

  @PostMapping("/customer")
  public ResponseEntity<String> customerSignUp(@RequestBody SignUpForm signUpForm) {
    signUpApplication.signUp(CUSTOMER,signUpForm);
    return ResponseEntity.ok("회원가입이 완료되었습니다.");
  }

  @GetMapping("/verify/customer")
  public ResponseEntity<String> customerVerify(@RequestParam String email, @RequestParam String key) {
    signUpApplication.verifyEmail(CUSTOMER,email, key);
    return ResponseEntity.ok("이메일 인증이 완료되었습니다.");
  }

  @PostMapping("/owner")
  public ResponseEntity<String> ownerSignUp(@RequestBody SignUpForm signUpForm) {
    signUpApplication.signUp(OWNER,signUpForm);
    return ResponseEntity.ok("회원가입이 완료되었습니다.");
  }

  @GetMapping("/verify/owner")
  public ResponseEntity<String> ownerVerify(@RequestParam String email, @RequestParam String key) {
    signUpApplication.verifyEmail(OWNER,email, key);
    return ResponseEntity.ok("이메일 인증이 완료되었습니다.");
  }

  @PostMapping("/admin")
  public ResponseEntity<String> adminSignUp(@RequestBody AdminSignUpForm signUpForm) {
    signUpApplication.adminSignUp(signUpForm);
    return ResponseEntity.ok("회원가입이 완료되었습니다.");
  }




}
