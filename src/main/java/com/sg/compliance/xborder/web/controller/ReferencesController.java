package com.sg.compliance.xborder.web.controller;

import com.sg.compliance.xborder.service.ReferencesRetrievalService;
import com.sg.compliance.xborder.web.dto.CountryReferenceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.sg.compliance.xborder.web.transformer.CountryTransformer.toCountryReferenceDTOs;

/**
 * Created by narisp on 4/28/17.
 */
@Controller
@RequestMapping("/reference/values")
public class ReferencesController {
    @Autowired
    private ReferencesRetrievalService referencesRetrievalService;

    @GetMapping("/countries")
    @ResponseBody
    public List<CountryReferenceDTO> getCountries() {
        return toCountryReferenceDTOs(referencesRetrievalService.getCountries());
    }

    @GetMapping("/policyType/{countryISO}")
    @ResponseBody
    public List<String> getPolicyTypes(String countryISO) {
        return referencesRetrievalService.getPolicyTypes(countryISO);
    }
}
