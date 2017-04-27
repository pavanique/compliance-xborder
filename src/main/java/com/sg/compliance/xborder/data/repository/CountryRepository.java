package com.sg.compliance.xborder.data.repository;

import com.sg.compliance.xborder.data.object.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Created by narisp on 4/27/17.
 */
public interface CountryRepository extends Repository<Country, Long> {

    Country findByCountryName(String countryName);

    Country findByCountryISO(String countryISO);

    @Query("select country from Country country left join country.policies p where p!=null and p.active = 'true' and country.countryISO=?1 order by p.policyId")
    Country findActivePoliciesByCountryISO(String countryISO);
}
