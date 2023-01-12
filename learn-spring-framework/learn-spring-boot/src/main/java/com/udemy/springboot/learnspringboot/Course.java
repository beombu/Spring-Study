package com.udemy.springboot.learnspringboot;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Course {
    private long id;
    private String name;
    private String author;

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
    }
}
