package com.sg.compliance.xborder.web.controller;

import com.sg.compliance.xborder.data.object.Policy;
import com.sg.compliance.xborder.service.PolicyManagementService;
import com.sg.compliance.xborder.web.dto.PolicyDTO;
import com.sg.compliance.xborder.web.transformer.PolicyTransformer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.sg.compliance.xborder.web.transformer.PolicyTransformer.toDomain;

/**
 * Created by narisp on 4/28/17.
 */
@Controller
@RequestMapping("/admin/policy")
@Api("Policy management")
public class PolicyManagementController {
	@Autowired
	private PolicyManagementService policyManagementService;

	@PostMapping(value = "/{countryISO}")
	@ResponseBody
	@ApiOperation("Add a policy to the given country")
	public PolicyDTO addPolicy(@ApiParam(required = true) @PathVariable("countryISO") String countryISO,
			@RequestBody PolicyDTO policyDTO) {
		Policy policy = toDomain(policyDTO);
		// policy.setPolicyDocument(document);
		policyManagementService.add(countryISO, policy);
		return PolicyTransformer.toDTO(policy);
	}

	@PostMapping(value="/document/{policyVersionId}")
    @ResponseBody
    @ApiOperation("Upload a policy document to the policy unique version country")
    public String uploadPolicyDocument(@ApiParam(required=true) @PathVariable("policyVersionId") Long id,
    		@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
    if(file.isEmpty()){
    	redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
    	return "redirect:uploadStatus";
    }
    policyManagementService.addPolicyDocument(id, file);
    return "redirect:uploadStatus";
    }

	@PostMapping(value = "/{countryISO}/policy/{policyId}")
	@ResponseBody
	public void copyPolicy(@ApiParam(required = true) @PathVariable("countryISO") String countryISO,
			@PathVariable("policyId") Long policyId) {
		policyManagementService.copy(countryISO, policyId);
	}
	/*
	 * ,
	 * 
	 * @ApiParam(required = true) @RequestPart MultipartFile document {"active":
	 * true,"category": "string","id": 0,"policyId": 0,"policyName":
	 * "string","version": "string"};Content-Type: application/json
	 * 
	 */
}
