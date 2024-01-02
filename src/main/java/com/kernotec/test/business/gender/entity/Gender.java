package com.kernotec.test.business.gender.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "gender", uniqueConstraints = { @UniqueConstraint(columnNames = { "code" }) })
public class Gender implements Serializable {

    private static final long serialVersionUID = -1233631192956366396L;

	@Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
    private UUID id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public Gender(String code, String name) {
        this.code = code;
        this.name = name;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}    
}
