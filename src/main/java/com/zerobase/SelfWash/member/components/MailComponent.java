package com.zerobase.SelfWash.member.components;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailComponent {
  private final JavaMailSender mailSender;

  public void sendMail(String email, String subject, String text) {

    MimeMessagePreparator message = mimeMessage -> {
      MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
      messageHelper.setTo(email);
      messageHelper.setSubject(subject);
      messageHelper.setText(text, true);
    };

    try {
      mailSender.send(message);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }



}
