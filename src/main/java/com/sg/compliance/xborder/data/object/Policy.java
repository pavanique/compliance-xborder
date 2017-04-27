package com.sg.compliance.xborder.data.object;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by narisp on 4/27/17.
 */
@Data
@Entity
public class Policy {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long policyId;
    private String  policyName;
    @Column(name="policyDocument",
            columnDefinition="CLOB NOT NULL")
    @Lob
    private String policyDocument;
    private String version;
    private boolean active;
}
