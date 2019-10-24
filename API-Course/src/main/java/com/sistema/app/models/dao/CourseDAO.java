package com.sistema.app.models.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sistema.app.models.documents.Course;


public interface CourseDAO extends ReactiveMongoRepository<Course, String> {

}
