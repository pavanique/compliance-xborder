package com.sg.compliance.xborder.web.transformer;

import com.sg.compliance.xborder.data.object.Country;
import com.sg.compliance.xborder.web.dto.CountryDTO;

/**
 * Created by narisp on 4/27/17.
 */
public class CountryTransformer {

    public static CountryDTO toDTO(Country country) {
        if (country == null) {
            return null;
        }
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountryISO(country.getCountryISO());
        countryDTO.setId(country.getId());
        countryDTO.setCountryName(country.getCountryName());
        countryDTO.setPolicies(PolicyTransformer.toDTO(country.getPolicies()));
        return countryDTO;
    }

}
