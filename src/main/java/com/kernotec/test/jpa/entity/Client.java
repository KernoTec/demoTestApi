package com.kernotec.test.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue
	@Column(name = "client_id", nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
	private UUID clientId;
	
	@NotBlank
	@Column(name = "name", length = 120)
	private String name;
	
	@NotBlank
	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(name = "second_last_name", length = 50)
	private String secondLastName;

	@Column(name = "document_type", length = 5)
	private String docType;

	@Column(name = "document_number", length = 20)
	private String docNumber;

	@Column(name = "birth_date", length = 20)
	private Date BirthDate;

	@Column(name = "gender", length = 1)
	private String gender;

	@Column(name = "status")
	private boolean status;
	
	@OneToMany(mappedBy="client")
	private List<Vehicle> vechicles;

}
