package com.turgaydede.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

//@RedisHash("users") // with useable Crud Repository
@Data
@EqualsAndHashCode
public class User implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private int age;
}
