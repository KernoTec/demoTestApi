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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client implements Serializable {

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

    public Client(String name, String surname1, String surname2, ClassDocument classDocumentId, Integer numberDocument, LocalDate birthday, Gender genderId) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.classDocumentId = classDocumentId;
        this.numberDocument = numberDocument;
        this.birthday = birthday;
        this.genderId = genderId;
    }
}
