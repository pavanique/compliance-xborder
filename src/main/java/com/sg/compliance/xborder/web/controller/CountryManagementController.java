package com.sg.compliance.xborder.web.controller;

import com.sg.compliance.xborder.service.CountryManagementService;
import com.sg.compliance.xborder.web.dto.CountryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.sg.compliance.xborder.web.transformer.CountryTransformer.toDomain;

/**
 * Created by narisp on 4/28/17.
 */
@Controller
@RequestMapping("/admin/country")
@Api(value = "/admin/country", description="Manage countries")
public class CountryManagementController {
    @Autowired
    private CountryManagementService countryManagementService;

    @PostMapping("/{countryISO}")
    @ResponseBody
    @ApiOperation(value="Add a new country")
    public void addCountry(@ApiParam(value="country ISO", required = true) @PathVariable("countryISO") String countryISO,
                           @RequestBody CountryDTO countryDTO) {
        if (countryISO == null || !countryISO.equals(countryDTO.getCountryISO())) {
            throw new IllegalArgumentException("Invalid data submitted");
        }
        countryManagementService.addCountry(toDomain(countryDTO));
    }
}
