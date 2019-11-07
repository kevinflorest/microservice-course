package com.sistema.app.service;

import com.sistema.app.models.Course;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {

	Flux<Course> findAllCourse();
	
	Mono<Course> findByIdCourse(String id);
	
	Mono<Course> saveCourse(Course course);
		
	Mono<Void> deleteCourse(Course course);
	
	public Flux<Course> reporteEstudiante(String documentNumber);
	
}
