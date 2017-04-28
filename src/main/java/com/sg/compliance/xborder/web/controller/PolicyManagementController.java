package com.sg.compliance.xborder.web.controller;

import com.sg.compliance.xborder.data.object.Policy;
import com.sg.compliance.xborder.service.PolicyManagementService;
import com.sg.compliance.xborder.web.dto.PolicyDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.sg.compliance.xborder.web.transformer.PolicyTransformer.toDomain;

/**
 * Created by narisp on 4/28/17.
 */
@Controller
@RequestMapping("/admin/policy")
public class PolicyManagementController {
    @Autowired
    private PolicyManagementService policyManagementService;

    @PostMapping("/{countryISO}")
    @ResponseBody
    public void addPolicy(@ApiParam(required = true) @PathVariable("countryISO") String countryISO, @RequestBody PolicyDTO policyDTO) {
        Policy policy = toDomain(policyDTO);
        policyManagementService.add(countryISO, policy);
    }

    @PostMapping(value = "/{countryISO}/policy/{policyId}")
    @ResponseBody
    public void copyPolicy(@ApiParam(required = true)  @PathVariable("countryISO") String countryISO, @PathVariable("policyId") Long policyId) {
        policyManagementService.copy(countryISO, policyId);
    }
/*

{"active": true,"category": "string","id": 0,"policyId": 0,"policyName": "string","version": "string"};Content-Type: application/json

 */
}
