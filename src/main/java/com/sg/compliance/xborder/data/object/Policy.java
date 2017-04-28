package com.sg.compliance.xborder.data.object;

import lombok.Data;
import org.hibernate.Hibernate;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.sql.Blob;

/**
 * Created by narisp on 4/27/17.
 */
@Data
@Entity
public class Policy implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long policyId;
    private String policyName;
    private String category;
    @Column(name = "policyDocument",
            columnDefinition = "CLOB NOT NULL")
    @Lob
    private MultipartFile policyDocument;
    private String documentName;
    private String documentType;
    private String version;
    private boolean active;

    public Policy clone() {
        return this.clone();
    }
}
