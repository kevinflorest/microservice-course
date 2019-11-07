package com.sistema.app.models;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Family {


	private String id;
	private String idStudent;
	private String firstName;
	private String secondName;
	private String paternalSurname;
	private String maternalSurname;
	private String genderFamily;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	private String typeDocument;
	private String numberDocument; 
	private String relationship;

	
	
}
