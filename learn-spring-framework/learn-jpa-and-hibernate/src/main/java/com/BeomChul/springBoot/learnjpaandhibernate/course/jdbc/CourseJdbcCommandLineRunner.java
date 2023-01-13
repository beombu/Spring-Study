package com.BeomChul.springBoot.learnjpaandhibernate.course.jdbc;

import com.BeomChul.springBoot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS Now!", "BeomChul"));
        repository.insert(new Course(2, "Learn Azure Now!", "BeomChul"));
        repository.insert(new Course(3, "Learn DevOps Now!", "BeomChul"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));
    }
}
