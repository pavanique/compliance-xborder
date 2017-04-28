package com.sg.compliance.xborder.service;

import com.sg.compliance.xborder.data.object.Country;
import com.sg.compliance.xborder.data.object.Policy;
import com.sg.compliance.xborder.data.repository.CountryRepository;
import com.sg.compliance.xborder.data.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by narisp on 4/28/17.
 */
@Component
public class PolicyManagementService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private DocumentRepository documentRepository;

    @Transactional
    public void add(String countryISO, Policy policy) {
        Country country = countryRepository.findByCountryISO("IN");
        if (country != null) {
            policy.setPolicyId(getNewPolicyId());
            documentRepository.save(policy);
            country.addPolicy(policy);
            countryRepository.save(country);
        } else {
            throw new IllegalArgumentException("Country Not found");
        }
    }

    @Transactional
    public void copy(String countryISO, Long policyId) {
        Country country = countryRepository.findByCountryISO(countryISO);
        Policy activePolicyToBeCopied = documentRepository.findActivePolicyByPolicyId(policyId);
        if (country != null && activePolicyToBeCopied != null) {
            Policy policy = activePolicyToBeCopied.clone();
            policy.setId(null);
            Long newPolicyId = getNewPolicyId();
            policy.setPolicyId(newPolicyId);
            country.addPolicy(policy);
            countryRepository.save(country);
        }
    }

    private long getNewPolicyId() {
        Long maxPolicyId = documentRepository.findMaxPolicyId();
        return maxPolicyId == null ? 1 : ++maxPolicyId;
    }
}
