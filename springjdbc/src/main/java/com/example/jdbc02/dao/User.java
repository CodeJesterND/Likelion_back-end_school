package com.example.jdbc02.dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    private Long id;
    private String name;
    private String email;
}
