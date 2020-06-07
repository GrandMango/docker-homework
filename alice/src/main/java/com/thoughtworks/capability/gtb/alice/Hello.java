package com.thoughtworks.capability.gtb.alice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class Hello {

    @GetMapping
    public String getHello() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<HelloEntity> entity = restTemplate.getForEntity("http://bob:8088/hello"
                , HelloEntity.class);

        HttpStatus statusCode = entity.getStatusCode();
        System.out.println("statusCode.is2xxSuccessful()"+statusCode.is2xxSuccessful());

        HelloEntity body = entity.getBody();
        System.out.println("entity.getBody()"+body);


        ResponseEntity.BodyBuilder status = ResponseEntity.status(statusCode);
        status.contentLength(100);
        status.body("我在这里添加一句话");
        ResponseEntity<Class<HelloEntity>> body1 = status.body(HelloEntity.class);
        Class<HelloEntity> body2 = body1.getBody();
        System.out.println("body1.toString()"+body1.toString());

        return body.getData();
    }
}