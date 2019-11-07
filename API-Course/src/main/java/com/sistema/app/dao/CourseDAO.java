package com.sistema.app.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sistema.app.models.Course;

import reactor.core.publisher.Flux;


public interface CourseDAO extends ReactiveMongoRepository<Course, String> {
	Flux<Course> findByTeacher(String teacher);
}
