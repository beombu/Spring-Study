package com.beomchul.springboot.mywebapp.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;

    @Size(min = 5, message = "최소 5자이상 입력력")
    private String description;
    private LocalDate targetDate;
    private boolean done;


}
