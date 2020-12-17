package com.codeacademy.eshop.config;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Configuration
@PropertySource("classpath:company.properties")
public class Company {
    @NotBlank
    @Value("${name}")
    private String name;

    @Value("${number}")
    private long number;

    @Value("${vat}")
    private Long vat;

    @NotBlank
    @Value("${iban}")
    private String iban;

    @NotBlank
    @Value("${address}")
    private String address;

    @NotBlank
    @Value("${sequence.name}")
    private String sequenceName;

}
