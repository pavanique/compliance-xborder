package com.sg.compliance.xborder.service;

import com.sg.compliance.xborder.data.object.Policy;
import com.sg.compliance.xborder.data.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by narisp on 4/27/17.
 */
@Component
public class PolicyDocumentService {
    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Policy> getPoliciesByCountry(String countryISO, String category) {
        if (category != null) {
            return countryRepository.findActivePoliciesByCountryISOAndCategory(countryISO, category);
        } else {
            return countryRepository.findActivePoliciesByCountryISO(countryISO);
        }
    }


}
