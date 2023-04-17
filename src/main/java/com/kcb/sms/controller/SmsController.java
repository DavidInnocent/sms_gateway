package com.kcb.sms.controller;

import com.kcb.sms.dto.SmsRequest;
import com.kcb.sms.dto.SmsResponse;
import com.kcb.sms.service.SmsHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SmsController {

  @Autowired
  private SmsHandlerService smsHandlerService;

  @PostMapping
  public ResponseEntity<SmsResponse> sendSms(@RequestBody SmsRequest request) {
    return smsHandlerService.sendSMS(request);
  }
}
