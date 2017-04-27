package com.sg.compliance.xborder.data.repository;

import com.sg.compliance.xborder.data.object.Policy;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by narisp on 4/27/17.
 */
public interface DocumentRepository extends Repository<Policy, Long> {

    List<Policy> findAll(Pageable pageable);

    @Query("select p from Policy p where p.policyName=?1 and p.active='true'")
    Policy findActivePolicyByName(String policyName);

    @Query("select p from Policy p where p.policyId=?1 and p.active='true'")
    Policy findActivePolicyByPolicyId(Long policyId);
}
