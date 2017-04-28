package com.sg.compliance.xborder.web.transformer;

import com.sg.compliance.xborder.data.object.Policy;
import com.sg.compliance.xborder.web.dto.PolicyDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by narisp on 4/27/17.
 */
public class PolicyTransformer {

    public static List<PolicyDTO> toDTO(List<Policy> policies) {
        if (policies == null) {
            return null;
        }
        List<PolicyDTO> policyDTOs = policies.stream()
                .filter(policy -> policy != null)
                .map(PolicyTransformer::toDTO)
                .collect(Collectors.toList());
        return policyDTOs;
    }

    public static PolicyDTO toDTO(Policy policy) {
        if (policy == null) {
            return null;
        }

        PolicyDTO policyDTO = new PolicyDTO();
        policyDTO.setId(policy.getId());
        policyDTO.setPolicyId(policy.getPolicyId());
        policyDTO.setPolicyName(policy.getPolicyName());
        policyDTO.setActive(policy.isActive());
        policyDTO.setCategory(policy.getCategory());
        return policyDTO;
    }

    public static Policy toDomain(PolicyDTO policyDTO) {
        if(policyDTO ==null){
            return null;
        }

        Policy policy = new Policy();
        policy.setPolicyId(policyDTO.getPolicyId());
        policy.setCategory(policyDTO.getCategory());
        policy.setActive(policyDTO.isActive());
        policy.setPolicyName(policyDTO.getPolicyName());
        policy.setVersion(policyDTO.getVersion());
        return policy;
    }

}
