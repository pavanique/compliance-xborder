package com.sg.compliance.xborder.data.object;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by narisp on 4/27/17.
 */
@Entity
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String countryISO;
    private String countryName;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "COUNTRY_POLICY",
            joinColumns = @JoinColumn(name = "COUNTRY_ID"),
            inverseJoinColumns = @JoinColumn(name = "POLICY_ID"))
    private List<Policy> policies = new ArrayList<>();

    public void addPolicy(Policy policy) {
        if (!getPolicies().contains(policy)){
            getPolicies().add(policy);
        }
    }
}
