package com.beomchul.rest.webservices.restfulwebservices.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private LocalDate localDate;
}
