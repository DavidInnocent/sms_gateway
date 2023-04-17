package com.kcb.sms.service;

import com.kcb.sms.config.MQConfig;
import com.kcb.sms.dto.SmsRequest;
import com.kcb.sms.dto.SmsResponse;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
class SmsHandlerServiceImplTest {
  @Mock
  private RabbitTemplate rabbitTemplate;

  @InjectMocks
  private SmsHandlerServiceImpl smsHandlerService;

  private SmsRequest smsRequest;

  @Before
  public void setUp() {
    smsRequest = SmsRequest.builder()
            .receiver("0703127101")
            .message("Hello")
            .build();
  }

  @Test
  public void testSendSMS() {
    ResponseEntity<SmsResponse> response = smsHandlerService.sendSMS(smsRequest);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Message Sent to 0703127101", response.getBody().getMessage());

    verify(rabbitTemplate).convertAndSend(MQConfig.TOPIC_EXCHANGE, MQConfig.ROUTING_KEY, smsRequest);
  }
}