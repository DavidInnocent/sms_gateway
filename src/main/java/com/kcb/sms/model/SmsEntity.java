package com.kcb.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@ToString
public class SmsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  String receiver, message;
  LocalDate createdAt;

  @PrePersist
  private void onCreate() {
    createdAt = LocalDate.now();
  }
}
