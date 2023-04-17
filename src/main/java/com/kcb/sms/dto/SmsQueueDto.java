package com.kcb.sms.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SmsQueueDto {
  String receiver,message;


}
