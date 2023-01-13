package com.BeomChul.springBoot.learnjpaandhibernate.course;

import com.BeomChul.springBoot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS JPA!", "BeomChul"));
        repository.save(new Course(2, "Learn Azure JPA!", "BeomChul"));
        repository.save(new Course(3, "Learn DevOps JPA!", "BeomChul"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.count());
        System.out.println(repository.findAll());

        System.out.println(repository.findByAuthor("BeomChul"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Learn AWS JPA!"));
        System.out.println(repository.findByName("Learn DevOps JPA!"));
    }
}
