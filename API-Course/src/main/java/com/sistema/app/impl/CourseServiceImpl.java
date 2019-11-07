package com.sistema.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.app.dao.CourseDAO;
import com.sistema.app.models.Course;
import com.sistema.app.service.CourseService;

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
		Mono<Course> c1 = Mono.just(course);
		Mono<Long> cc2 = cdao.findByTeacher(course.getTeacher()).count();
		return c1
				.flatMap(c2->{
			Integer cantidadEstudiantes = c2.getStudents().size();
			Integer cantidadOyentes = c2.getListeners().size();
			Integer cantidadTotal = cantidadEstudiantes + cantidadOyentes;
			
			/*Flux<Long> cantidadCursos = dao.findAll().flatMap(gg->{
				gg.getOyentes().forEach(j->{
					j.getDocumentNumber();
				});
				return null;
			});*/
			
			if(cantidadEstudiantes<c2.getMinCapacityCourse() && cantidadOyentes>0){
				System.out.println("Aun no puedes inscribir oyentes, curso esta inactivo");
				return Mono.empty();
			}else if(cantidadEstudiantes==c2.getMinCapacityCourse() && cantidadOyentes==0) {
				return cc2.flatMap(t->{
					if(t==2) {
						return Mono.empty();
					}else {
						c2.setStatusCourse("Activo");
						return cdao.save(c2);
					}
				});
				
			}else if(cantidadTotal==c2.getMaxCapacityCourse() && cantidadEstudiantes>=c2.getMinCapacityCourse()){
				return cc2.flatMap(t->{
					if(t==2) {
						return Mono.empty();
					}else {
						c2.setStatusCourse("Completado");
						return cdao.save(c2);
					}
				});
			}else if(cantidadEstudiantes==c2.getMinCapacityCourse() && cantidadTotal<c2.getMaxCapacityCourse()) {
				return cc2.flatMap(t->{
					if(t==2) {
						return Mono.empty();
					}else {
						c2.setStatusCourse("Completado");
						return cdao.save(c2);
					}
				});
			}else{
				return Mono.empty();
			}
		});
	}

	@Override
	public Mono<Void> deleteCourse(Course course) {
		return cdao.delete(course);
	}
	
	@Override
	public Flux<Course> reporteEstudiante(String documentNumber) {
		Flux<Course> Courses = cdao.findAll();
		return Courses
			.filter(cc->{
				if(cc.getStatusCourse()=="Abierto") {
					return true;
				}else {
					return false;
				}
			})
			.flatMap(c->{
				return Flux.fromIterable(c.getListeners()).flatMap(p->{
					if(p.getNumberDocument() == documentNumber) {
						return Flux.just(c);
					}else {
						return Flux.empty();	
					}
					
				});
			
		});
	}
	
}
