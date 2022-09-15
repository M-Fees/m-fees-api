package com.hackathon.contest.sms.controller;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {
  @GetMapping ("/sms")
  public String sendSMS(){
    Twilio.init("AC9f8e7326d9c6d53caedbd808273eacbf",
            "afce33562362ee97a015ae8490d961f0");
    Message.creator(new PhoneNumber("+261324063616"), new PhoneNumber("+14248424194"), "Bonjour ," +
            "nous tenons à vous informer que le deadline de payment de votre frais de scolarité est dépassé. " +
            "Veuillez vous rendre au bureau de l'administration pour plus de details. Merci!").create();
    return "Message sent successfully";
  }
}
