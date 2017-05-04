package com.sg.compliance.xborder.service;

import com.sg.compliance.xborder.data.object.Policy;
import com.sg.compliance.xborder.data.repository.CountryRepository;
import com.sg.compliance.xborder.data.repository.DocumentRepository;

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
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private PolicyFileRepo policyFileRepo;

    @Transactional
    public List<Policy> getPoliciesByCountry(String countryISO, String category) {
        if (category != null) {
            return countryRepository.findActivePoliciesByCountryISOAndCategory(countryISO, category);
        } else {
            return countryRepository.findActivePoliciesByCountryISO(countryISO);
        }
    }
    
    @Transactional
    public Policy getActivePolicy(Long policyId){
    	Policy policy = documentRepository.findActivePolicyByPolicyId(policyId);
    	return policy;
    }
    
    public byte[] getDocument(Long id, String documentName) {return policyFileRepo.getFile(id, documentName);}


}
