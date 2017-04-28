package com.sg.compliance.xborder.service;

import com.sg.compliance.xborder.data.object.Country;
import com.sg.compliance.xborder.data.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by narisp on 4/28/17.
 */
@Component
public class CountryManagementService {
    @Autowired
    private CountryRepository countryRepository;

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public void updateCountry(Country userCountry) {
        Country oldCountry = countryRepository.findByCountryISO(userCountry.getCountryISO());
        if (oldCountry != null) {
            countryRepository.save(userCountry);
        }
    }

}
