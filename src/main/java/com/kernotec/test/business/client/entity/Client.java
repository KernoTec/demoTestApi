package com.kernotec.test.business.client.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.kernotec.test.business.classDocument.entity.ClassDocument;
import com.kernotec.test.business.gender.entity.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID = 6309804948498684193L;

	@Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname1")
    private String surname1;

    @Column(name = "surname2")
    private String surname2;

    @OneToOne
    @JoinColumn(name = "class_document_id")
    private ClassDocument classDocumentId;

    @Column(name = "number_document")
    private Integer numberDocument;

    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToOne
    @JoinColumn(name = "gender_id")
    private Gender genderId;

    @Column(name = "status")
    private Integer status;

    public Client(String name, String surname1, String surname2, ClassDocument classDocumentId, Integer numberDocument,
			LocalDate birthday, Gender genderId, Integer status) {
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.classDocumentId = classDocumentId;
		this.numberDocument = numberDocument;
		this.birthday = birthday;
		this.genderId = genderId;
		this.status = status;
	}

	public Client() {

    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname1() {
		return surname1;
	}

	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	public ClassDocument getClassDocumentId() {
		return classDocumentId;
	}

	public void setClassDocumentId(ClassDocument classDocumentId) {
		this.classDocumentId = classDocumentId;
	}

	public Integer getNumberDocument() {
		return numberDocument;
	}

	public void setNumberDocument(Integer numberDocument) {
		this.numberDocument = numberDocument;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Gender getGenderId() {
		return genderId;
	}

	public void setGenderId(Gender genderId) {
		this.genderId = genderId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}    
}
