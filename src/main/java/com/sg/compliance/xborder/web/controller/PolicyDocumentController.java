package com.sg.compliance.xborder.web.controller;

import com.sg.compliance.xborder.data.object.Policy;
import com.sg.compliance.xborder.service.PolicyDocumentService;
import com.sg.compliance.xborder.web.dto.PolicyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public List<PolicyDTO> getPolicies(@PathVariable String countryISO, @RequestParam(required = false) String category) {
        List<Policy> policies = this.policyDocumentService.getPoliciesByCountry(countryISO, category);
        return toDTO(policies);
    }

}
