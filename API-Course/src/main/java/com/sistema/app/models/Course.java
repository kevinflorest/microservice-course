package com.sistema.app.models;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="course")
public class Course {

	@Id
	private String id;
	
	@NotEmpty
	private String codCourse;
	@NotEmpty
	private String nameCourse;
	@NotEmpty
	private String statusCourse;
	@NotNull
	private Integer maxCapacityCourse;
	@NotNull
	private Integer minCapacityCourse;
	@NotEmpty
	private String teacher;
	@NotEmpty
	private String codInstitute;
	@NotEmpty
	private List<Student> students;
	@NotEmpty
	private List<Family> listeners;
	
}
