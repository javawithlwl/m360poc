package com.pln.m360poc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GlFailureMessage {
  private String requestKey;
  private String status;
  private String errorCode;
  private String errorDesc;
}
