package com.kcb.sms.service;

import com.kcb.sms.dto.SmsQueueDto;
import com.kcb.sms.dto.SmsRequest;
import com.kcb.sms.dto.SmsResponse;
import org.springframework.http.ResponseEntity;

public interface SmsHandlerService {
  ResponseEntity<SmsResponse> sendSMS(SmsRequest reward);
}
