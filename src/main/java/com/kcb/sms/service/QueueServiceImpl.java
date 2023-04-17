package com.kcb.sms.service;

import com.kcb.sms.dto.SmsQueueDto;
import com.kcb.sms.dto.SmsRequest;
import com.kcb.sms.model.SmsEntity;
import com.kcb.sms.repository.SMSRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

@Slf4j
public class QueueServiceImpl implements QueueOperationService {
  @Autowired
  SMSRepository repository;

  /**
   * The followign witll receive the sms in the queue
   * then it will save it .
   * @param sms the sms received.
   * @return if the sms is sent then it will
   */
  @Override
  @Transactional
  public boolean SaveSentSms(SmsRequest sms) {
    SmsEntity smsEntity=new SmsEntity();
    smsEntity.setReceiver(sms.getReceiver());
    smsEntity.setMessage(sms.getMessage());
    repository.save(smsEntity);
    log.info(sms.toString());
    return false;
  }
}
