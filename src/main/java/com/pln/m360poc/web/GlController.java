package com.pln.m360poc.web;

import com.pln.m360poc.entity.GlFailureMessage;
import com.pln.m360poc.entity.GlSuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class GlController {

      @PostMapping("/glposting-intiation")
      public ResponseEntity<?> glRequest(HttpServletRequest request){
             String header = request.getHeader("success");
             if(header!=null){
                   GlSuccessResponse response = GlSuccessResponse.builder().requestKey("6507e49a-09d5-4332-9464-a833acb25224")
                       .status("ACCEPTED").build();
                   return ResponseEntity.ok(response);
             }else{
                  GlFailureMessage message = GlFailureMessage.builder()
                      .requestKey("6507e49a-09d5-4332-9464-a833acb25224")
                      .status("REJECTED")
                      .errorCode("E10001")
                      .errorDesc("Invalid message format").build();
                  return ResponseEntity.ok(message);
            }
      }
      @GetMapping("/greet")
      public ResponseEntity<String> greet(){
        return ResponseEntity.ok("Greetings");
      }
}
