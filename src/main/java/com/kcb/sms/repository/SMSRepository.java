package com.kcb.sms.repository;

import com.kcb.sms.model.SmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMSRepository extends JpaRepository<SmsEntity, Long> {
}
