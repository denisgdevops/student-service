package com.dev.kali.apiservice.payload;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RequestPayload {

    private int id;
    private String name;
    private String sex;
    private int age;


}
