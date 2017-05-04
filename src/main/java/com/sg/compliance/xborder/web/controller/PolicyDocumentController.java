package com.sg.compliance.xborder.web.controller;

import com.google.common.net.HttpHeaders;
import com.sg.compliance.xborder.data.object.Policy;
import com.sg.compliance.xborder.service.PolicyDocumentService;
import com.sg.compliance.xborder.web.dto.PolicyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import static com.sg.compliance.xborder.web.transformer.PolicyTransformer.toDTO;

/**
 * Created by narisp on 4/27/17.
 */
@Controller
@RequestMapping("/policy")
public class PolicyDocumentController {

	@Autowired
	private PolicyDocumentService policyDocumentService;

	@GetMapping("/country/{countryISO}")
	@ResponseBody
	public List<PolicyDTO> getPolicies(@PathVariable String countryISO,
			@RequestParam(required = false) String category) {
		List<Policy> policies = this.policyDocumentService.getPoliciesByCountry(countryISO, category);
		return toDTO(policies);
	}

	@GetMapping("/document/{policyId}")
	@ResponseBody
	public ResponseEntity<byte[]> getDocument(@PathVariable Long policyId) throws IOException, SQLException{
		Policy policy = policyDocumentService.getActivePolicy(policyId);
		byte[] documentContent = policyDocumentService.getDocument(policy.getPolicyId(), policy.getDocumentName());
		if (policy != null && documentContent != null) {
			Blob document = policy.getPolicyDocument();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "inline; fileName=\"" + policy.getDocumentName() + "\"")
					.contentType(getContentType(policy)).body(documentContent);
		}
		throw new FileNotFoundException("Policy of document not found");

	}

	private MediaType getContentType(Policy policy) {
		if (policy.getDocumentName().endsWith(".pdf")) {
			return new MediaType("application", "pdf");
		}
		return MediaType.valueOf(policy.getDocumentType());
	}

}
