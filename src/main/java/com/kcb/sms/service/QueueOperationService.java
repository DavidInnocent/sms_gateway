package com.kcb.sms.service;

import com.kcb.sms.dto.SmsQueueDto;
import com.kcb.sms.dto.SmsRequest;

public interface QueueOperationService {
  boolean SaveSentSms(SmsRequest sms);
}
