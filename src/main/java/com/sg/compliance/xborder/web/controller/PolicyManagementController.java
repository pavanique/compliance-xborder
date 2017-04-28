package com.sg.compliance.xborder.web.controller;

import com.sg.compliance.xborder.data.object.Policy;
import com.sg.compliance.xborder.service.PolicyManagementService;
import com.sg.compliance.xborder.web.dto.PolicyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;

import static com.sg.compliance.xborder.web.transformer.PolicyTransformer.toDomain;

/**
 * Created by narisp on 4/28/17.
 */
@Controller
@RequestMapping(value="/admin/policy", consumes = {MediaType.APPLICATION_OCTET_STREAM_VALUE,
        MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.ALL_VALUE})
public class PolicyManagementController {
    @Autowired
    private PolicyManagementService policyManagementService;

    @PostMapping(value = "/{countryISO}", consumes = {MediaType.APPLICATION_OCTET_STREAM_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.ALL_VALUE})
    @ResponseBody
    public void addPolicy(@PathParam("countryISO") String countryISO, @RequestPart PolicyDTO policyDTO,
                          @RequestPart("document") MultipartFile policyDocument) {
        Policy policy = toDomain(policyDTO);
        policy.setPolicyDocument(policyDocument);
        policyManagementService.add(countryISO, policy);
    }

    @PostMapping(value = "/{countryISO}/policy/{policyId}")
    @ResponseBody
    public void copyPolicy(@PathParam("countryISO") String countryISO, @PathParam("policyId") Long policyId) {
        policyManagementService.copy(countryISO, policyId);
    }
/*

{"active": true,"category": "string","id": 0,"policyId": 0,"policyName": "string","version": "string"};Content-Type: application/json

 */
}
