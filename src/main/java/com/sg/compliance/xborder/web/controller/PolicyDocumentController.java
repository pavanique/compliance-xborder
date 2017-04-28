package com.sg.compliance.xborder.web.controller;

import com.sg.compliance.xborder.data.object.Country;
import com.sg.compliance.xborder.service.PolicyDocumentService;
import com.sg.compliance.xborder.web.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.sg.compliance.xborder.web.transformer.CountryTransformer.toDTO;

/**
 * Created by narisp on 4/27/17.
 */
@Controller
@RequestMapping("/policy")
public class PolicyDocumentController {

    @Autowired
    private PolicyDocumentService policyDocumentService;

    @GetMapping("/country/{countryISO}")
    @ResponseBody
    public CountryDTO getPolicies(@PathVariable String countryISO) {
        Country country = this.policyDocumentService.getPoliciesByCountry(countryISO);
        return toDTO(country);
    }

}
