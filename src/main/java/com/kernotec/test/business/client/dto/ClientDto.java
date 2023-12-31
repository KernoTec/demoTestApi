package com.kernotec.test.business.client.dto;

import com.kernotec.test.business.classDocument.entity.ClassDocument;
import com.kernotec.test.business.gender.entity.Gender;

import java.time.LocalDate;

public class ClientDto {

    private String name;

    private String surname1;

    private String surname2;

    private ClassDocument classDocumentId;

    private Integer numberDocument;

    private LocalDate birthday;

    private Gender genderId;

    private Integer status;

	public ClientDto(String name, String surname1, String surname2, ClassDocument classDocumentId,
			Integer numberDocument, LocalDate birthday, Gender genderId, Integer status) {
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.classDocumentId = classDocumentId;
		this.numberDocument = numberDocument;
		this.birthday = birthday;
		this.genderId = genderId;
		this.status = status;
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
