package com.beomchul.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;

    @Size(min = 2, message = "이름은 2글자 이상부터 ㄱㄱ")
    @JsonProperty("user_name")
    private String name;

    @Past(message = "생일은 과거 날짜여야 함")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
}
