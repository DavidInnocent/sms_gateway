package com.kcb.sms.service;

import com.kcb.sms.config.MQConfig;
import com.kcb.sms.dto.SmsQueueDto;
import com.kcb.sms.dto.SmsRequest;
import com.kcb.sms.dto.SmsResponse;
import com.kcb.sms.model.SmsEntity;
import com.kcb.sms.repository.SMSRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class SmsHandlerServiceImpl implements SmsHandlerService {
  @Autowired
  RabbitTemplate rabbitTemplate;

  /**
   * The following will queue the sms received into rabbbit mq
   *
   * @param smsRequest the sms to be sent
   * @return the response for the success receipt of the sms
   */
  @Override
  public ResponseEntity<SmsResponse> sendSMS(SmsRequest smsRequest) {
    rabbitTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE,
            MQConfig.ROUTING_KEY, smsRequest);
    return ResponseEntity.ok(SmsResponse.builder()
            .message("Message Sent to " + smsRequest.getReceiver())
            .build());
  }
}
