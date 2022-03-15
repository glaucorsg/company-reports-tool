package br.edu.ifpb.companyreportstool.repository;

import br.edu.ifpb.companyreportstool.domain.Tax;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
public class TaxRepositoryTest {

    @Autowired
    private TaxRepository taxRepository;

    Tax tax;

    @BeforeEach
    public void init() {
        tax = Tax.builder().amount(new BigDecimal("50"))
                .amountExcludingTaxes(new BigDecimal("25"))
                .rate(new BigDecimal("0.5"))
                .build();
    }

    @Test
    void shouldSaveTax() {
        taxRepository.save(tax);
        assertThat(tax.getId(), notNullValue());
    }

    @Test
    void shouldListTax() {
        taxRepository.save(tax);
        assertThat(taxRepository.findAll(), hasSize(1));
    }

    @Test
    void shouldDeleteTax() {
        taxRepository.save(tax);
        assertThat(taxRepository.findAll(), hasSize(1));
        taxRepository.delete(tax);
        assertThat(taxRepository.findAll(), empty());
    }

    @AfterEach
    public void tearDown() {
        taxRepository.deleteAll();
    }

}
