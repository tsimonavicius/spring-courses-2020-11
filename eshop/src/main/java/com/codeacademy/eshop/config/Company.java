package com.codeacademy.eshop.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable
@Configuration
@ConfigurationProperties(prefix = "company")
public class Company {
    @NotBlank
    private String companyName;

    private long companyNo;

    private Long companyVat;

    @NotBlank
    private String iban;

    @NotBlank
    private String address;
}
