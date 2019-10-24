package com.sistema.app.models.service;

import com.sistema.app.models.documents.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {

	Flux<Course> findAllCourse();
	
	Mono<Course> findByIdCourse(String id);
	
	Mono<Course> saveCourse(Course course);
		
	Mono<Void> deleteCourse(Course course);
	
	
}
