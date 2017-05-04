package com.sg.compliance.xborder.service;

import com.sg.compliance.xborder.data.object.Country;
import com.sg.compliance.xborder.data.object.Policy;
import com.sg.compliance.xborder.data.repository.CountryRepository;
import com.sg.compliance.xborder.data.repository.DocumentRepository;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private PolicyFileRepo policyFileRepo;

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

    @Transactional
    public void addPolicyDocument(Long id, MultipartFile file){
     policyFileRepo.saveFile(id, file);
     Policy policy = documentRepository.findOne(id);
     try{
    	 EntityManager entityManager = entityManagerFactory.createEntityManager();
    	 Session session = entityManager.unwrap(Session.class);
    	 Blob blob = Hibernate.getLobCreator(session).createBlob(file.getBytes());
    	 policy.setPolicyDocument(blob);
     }catch(IOException io){
    	io.printStackTrace(); 
     }
     policy.setDocumentType(file.getContentType());
     policy.setDocumentName(file.getOriginalFilename());
     documentRepository.save(policy);
    }
    
    private long getNewPolicyId() {
        Long maxPolicyId = documentRepository.findMaxPolicyId();
        return maxPolicyId == null ? 1 : ++maxPolicyId;
    }
    
    
}
