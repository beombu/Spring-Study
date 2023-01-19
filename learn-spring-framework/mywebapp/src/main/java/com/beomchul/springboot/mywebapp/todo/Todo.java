package com.beomchul.springboot.mywebapp.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Todo {
    private int id;
    private String username;

    @Size(min = 5, message = "최소 5자이상 입력력")
    private String description;
    private LocalDate targetDate;
    private boolean done;


}
