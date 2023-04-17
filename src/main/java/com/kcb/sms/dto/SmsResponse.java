package com.kcb.sms.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmsResponse {
    String message;
}
