package com.sg.compliance.xborder.web.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by narisp on 4/27/17.
 */
@Data
public class CountryDTO {
    private long id;
    private String countryISO;
    private String countryName;
    private List<PolicyDTO> policies;
}
