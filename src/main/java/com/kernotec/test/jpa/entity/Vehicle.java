package com.kernotec.test.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue
	@Column(name = "vehicle_id", nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
	private UUID vehicleId;
	
	@Column(name = "brand", length = 50)
	private String brand;
	
	@Column(name = "model", length = 50)
	private String model;
	
	@Column(name = "year", length = 4)
	private String year;
	
	@Column(name = "plate", length = 10)
	private String plate;
	
	@Column(name = "status")
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name="clientId")
	private Client client;

}
