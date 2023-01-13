package com.BeomChul.springBoot.learnjpaandhibernate.course.jpa;

import com.BeomChul.springBoot.learnjpaandhibernate.course.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        //Course와 DB를 동일하게 머지
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
