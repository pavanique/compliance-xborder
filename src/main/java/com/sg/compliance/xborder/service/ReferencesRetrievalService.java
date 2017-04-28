package com.sg.compliance.xborder.service;

import com.sg.compliance.xborder.data.object.Country;
import com.sg.compliance.xborder.data.object.Policy;
import com.sg.compliance.xborder.data.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by narisp on 4/28/17.
 */
@Component
public class ReferencesRetrievalService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public List<String> getPolicyTypes(String countryISO) {
        return countryRepository.findPolicyCategoriesByCountry(countryISO);
    }
}
