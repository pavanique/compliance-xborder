package com.sg.compliance.xborder.web.transformer;

import com.sg.compliance.xborder.data.object.Country;
import com.sg.compliance.xborder.web.dto.CountryDTO;
import com.sg.compliance.xborder.web.dto.CountryReferenceDTO;

import java.util.List;
import java.util.stream.Collectors;

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
        countryDTO.setCountryName(country.getCountryName());
        countryDTO.setPolicies(PolicyTransformer.toDTO(country.getPolicies()));
        return countryDTO;
    }

    public static Country toDomain(CountryDTO countryDTO) {
        if (countryDTO == null) {
            return null;
        }
        Country country = new Country();
        country.setCountryISO(countryDTO.getCountryISO());
        country.setCountryName(countryDTO.getCountryName());
        return country;
    }

    public static List<CountryReferenceDTO> toCountryReferenceDTOs(List<Country> countries) {
        if (countries == null) {
            return null;
        }
        List<CountryReferenceDTO> countryReferenceDTOS = countries.stream()
                .filter(country -> country != null)
                .map(CountryTransformer::toCountryReferenceDTO)
                .collect(Collectors.toList());
        return countryReferenceDTOS;


    }

    private static CountryReferenceDTO toCountryReferenceDTO(Country country) {
        CountryReferenceDTO countryReferenceDTO = new CountryReferenceDTO();
        countryReferenceDTO.setCountryISO(country.getCountryISO());
        countryReferenceDTO.setCountryName(country.getCountryName());
        return countryReferenceDTO;
    }

}
