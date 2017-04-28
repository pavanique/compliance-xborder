package com.sg.compliance.xborder.data.repository;

import com.sg.compliance.xborder.data.object.Country;
import com.sg.compliance.xborder.data.object.Policy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by narisp on 4/27/17.
 */
public interface CountryRepository extends CrudRepository<Country, Long> {

    Country findByCountryName(String countryName);

    Country findByCountryISO(String countryISO);

    @Query("select p from Country country inner join country.policies p where p!=null and p.active = 'true' and country.countryISO=?1 order by p.policyId")
    List<Policy> findActivePoliciesByCountryISO(String countryISO);

    List<Country> findAll();

    @Query("select distinct p.category from Country country left join country.policies p " +
            " where p!=null and p.active = 'true' and country.countryISO=?1 order by p.category")
    List<String> findPolicyCategoriesByCountry(String countryISO);
}
