package com.deliveryboy.controller;

import com.deliveryboy.service.KafkaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.lang.Math.random;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
@Slf4j
public class LocationController {

    private final KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?>  updateLocation() {
        for(int i=1;i<=200000;i++){
            this.kafkaService.updateLocation("( "+Math.round(random()*100)+" , "+Math.round(random()*100)+" )");
            log.info("message produced");
            System.out.println("-------------------");
        }
        return new ResponseEntity<>(Map.of("Message","Location updated"),HttpStatus.OK);
    }


}
