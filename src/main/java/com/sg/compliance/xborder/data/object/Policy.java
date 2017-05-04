package com.sg.compliance.xborder.data.object;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by narisp on 4/27/17.
 */
@Data
@Entity
public class Policy implements Cloneable, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "POLICY_ID")
    private Long policyId;
    private String policyName;
    private String category;
    @Column(name = "policy_Document",
            columnDefinition = "CLOB NULL")
    @Lob
    private Blob policyDocument;
    private String documentName;
    private String documentType;
    private String version;
    private boolean active;

    public Policy clone() {
        return this.clone();
    }
}
