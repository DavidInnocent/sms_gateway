package com.kcb.sms.dto;

import com.kcb.sms.model.SmsEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsRequest {
  String receiver, message;

  public static SmsEntity toEntity(SmsRequest smsRequest) {
    SmsEntity sms=new SmsEntity();
    sms.setMessage(smsRequest.getMessage());
    sms.setReceiver(smsRequest.getReceiver());
    return sms;
  }
}
