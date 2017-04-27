package com.sg.compliance.xborder.web.dto;

import lombok.Data;

/**
 * Created by narisp on 4/27/17.
 */
@Data
public class PolicyDTO {
    private Long id;
    private Long policyId;
    private String policyName;
    private String version;
    private boolean active;
}
