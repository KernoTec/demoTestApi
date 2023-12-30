package com.kernotec.test.business.classDocument.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "class_document", uniqueConstraints = { @UniqueConstraint(columnNames = { "code" }) })
public class ClassDocument implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
    private UUID id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public ClassDocument(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
