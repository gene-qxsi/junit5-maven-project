package com.matrosov.entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
    Integer id;
    String username;
    String password;
}
