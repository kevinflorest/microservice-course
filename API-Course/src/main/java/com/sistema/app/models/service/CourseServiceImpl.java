package com.sistema.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistema.app.models.dao.CourseDAO;
import com.sistema.app.models.documents.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDAO cdao;

	@Override
	public Flux<Course> findAllCourse() {
		return cdao.findAll();
	}

	@Override
	public Mono<Course> findByIdCourse(String id) {
		return cdao.findById(id);
	}

	@Override
	public Mono<Course> saveCourse(Course course) {
		return cdao.save(course);
	}

	@Override
	public Mono<Void> deleteCourse(Course course) {
		return cdao.delete(course);
	}
	
}
