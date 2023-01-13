package com.BeomChul.springBoot.learnjpaandhibernate.course;

import com.BeomChul.springBoot.learnjpaandhibernate.course.Course;
import com.BeomChul.springBoot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.BeomChul.springBoot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS JPA!", "BeomChul"));
        repository.insert(new Course(2, "Learn Azure JPA!", "BeomChul"));
        repository.insert(new Course(3, "Learn DevOps JPA!", "BeomChul"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));
    }
}
