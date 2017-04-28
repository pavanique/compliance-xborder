package com.sg.compliance.xborder.web.controller;

import com.sg.compliance.xborder.service.CountryManagementService;
import com.sg.compliance.xborder.web.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

import static com.sg.compliance.xborder.web.transformer.CountryTransformer.toDomain;

/**
 * Created by narisp on 4/28/17.
 */
@Controller
@RequestMapping("/admin/country")
public class CountryManagementController {
    @Autowired
    private CountryManagementService countryManagementService;

    @PostMapping("/{countryISO}")
    @ResponseBody
    public void addCountry(@PathParam("countryISO") String countryISO, CountryDTO countryDTO) {
        if (countryISO == null || !countryISO.equals(countryDTO.getCountryISO())) {
            throw new IllegalArgumentException("Invalid data submitted");
        }
        countryManagementService.addCountry(toDomain(countryDTO));
    }
}
