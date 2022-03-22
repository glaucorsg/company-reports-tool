package br.edu.ifpb.companyreportstool.service;

import br.edu.ifpb.companyreportstool.domain.Expense;
import br.edu.ifpb.companyreportstool.repository.ExpenseRepository;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class ExpenseReportTest {

    @Autowired
    private ExpenseReport expenseReport;
    @Autowired
    private ExpenseRepository expenseRepository;

    private Expense expense;

    @BeforeEach
    public void init() {
        expense = Expense.builder()
                .location("BR")
                .amount(new BigDecimal(5))
                .day(Date.from(Instant.now()))
                .description("New expense")
                .build();
        expenseRepository.save(expense);
    }

    @Test
    public void generateHTMLReportTest(@Autowired ExpenseReportHtml expenseReportHtml) {
        String report = expenseReportHtml.generateReport();
        String body = "<ul><li>"+expenseRepository.findAll().stream()
                .map(Objects::toString).collect(Collectors.joining("</li><li>"))+"</li></ul>";
        assertThat(report, equalTo("<header><h1>Company Report</h1></header><main><h2>This is the Expense Report</h2><p>"+body+"</p></main><footer>2022 - Design Patterns IFPB</footer>"));
        System.out.println(report);
    }

    @Test
    public void generateJsonReportTest(@Autowired ExpenseReportJson expenseReportJson) {
        String report = expenseReportJson.generateReport();
        String body = expenseRepository.findAll().stream()
                .map(Objects::toString).collect(Collectors.joining(","));
        assertThat(report, equalTo("{ header: \"Company Report\" ,main: { title: \"This is the Expense Report\", content: \""+body+"\" ,footer: \"2022 - Design Patterns IFPB\" }"));
        System.out.println(report);
    }


    @AfterEach
    public void tearDown() {
        expenseRepository.deleteAll();
    }

}
