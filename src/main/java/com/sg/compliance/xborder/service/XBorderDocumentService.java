package com.sg.compliance.xborder.service;

import com.sg.compliance.xborder.data.object.Country;
import com.sg.compliance.xborder.data.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by narisp on 4/27/17.
 */
@Component
public class XBorderDocumentService {
    @Autowired
    private CountryRepository countryRepository;

    public Country getPoliciesByCountry(String countryISO) {
        return countryRepository.findActivePoliciesByCountryISO("IN");
    }


}
