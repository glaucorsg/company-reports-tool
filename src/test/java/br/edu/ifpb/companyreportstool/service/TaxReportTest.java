package br.edu.ifpb.companyreportstool.service;

import br.edu.ifpb.companyreportstool.domain.Tax;
import br.edu.ifpb.companyreportstool.repository.TaxRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class TaxReportTest {

    @Autowired
    private TaxReport expenseReport;
    @Autowired
    private TaxRepository taxRepository;

    private Tax tax;

    @BeforeEach
    public void init() {
        tax = Tax.builder().amount(new BigDecimal("50"))
                .amountExcludingTaxes(new BigDecimal("25"))
                .rate(new BigDecimal("0.5"))
                .build();
        taxRepository.save(tax);

    }

    @Test
    public void generateHTMLReportTest() {
        String report = expenseReport.generateReport("html");
        String body = "<ul><li>"+taxRepository.findAll().stream()
                .map(Objects::toString).collect(Collectors.joining("</li><li>"))+"</li></ul>";
        assertThat(report, equalTo("<header><h1>Company Report</h1></header><main><h2>This is the tax Report</h2><p>"+body+"</p></main><footer>2022 - Design Patterns IFPB</footer>"));
        System.out.println(report);
    }

    @Test
    public void generateJsonReportTest() {
        String report = expenseReport.generateReport("json");
        String body = taxRepository.findAll().stream()
                .map(Objects::toString).collect(Collectors.joining(","));
        assertThat(report, equalTo("{ header: \"Company Report\" ,main: { title: \"This is the tax Report\", content: \""+body+"\" ,footer: \"2022 - Design Patterns IFPB\" }"));
        System.out.println(report);
    }

    @AfterEach
    public void tearDown() {
        taxRepository.deleteAll();
    }

}
