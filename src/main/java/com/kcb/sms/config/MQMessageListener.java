package io.firefy.rewardnegotiationservice.config;

import com.kcb.sms.config.MQConfig;
import com.kcb.sms.dto.SmsQueueDto;
import com.kcb.sms.dto.SmsRequest;
import com.kcb.sms.model.SmsEntity;
import com.kcb.sms.service.QueueOperationService;
import com.kcb.sms.service.SmsHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class MQMessageListener {

  @Autowired
  QueueOperationService queueOperationService;

  @RabbitListener(queues = MQConfig.QUEUE)
  public void listener(SmsRequest sms) {
    queueOperationService.SaveSentSms(sms);
  }
}
