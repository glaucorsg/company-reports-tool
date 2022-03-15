package br.edu.ifpb.companyreportstool.repository;

import br.edu.ifpb.companyreportstool.domain.Expense;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
public class ExpenseRepositoryTest {

    @Autowired
    private ExpenseRepository expenseRepository;

    Expense expense;

    @BeforeEach
    public void init() {
        expense = Expense.builder()
                .location("BR")
                .amount(new BigDecimal(5))
                .day(Date.from(Instant.now()))
                .description("New expense")
                .build();
    }

    @Test
    void shouldSaveExpense() {
        expenseRepository.save(expense);
        assertThat(expense.getId(), notNullValue());
    }

    @Test
    void shouldListExpense() {
        expenseRepository.save(expense);
        assertThat(expenseRepository.findAll(), hasSize(1));
    }

    @Test
    void shouldDeleteExpense() {
        expenseRepository.save(expense);
        assertThat(expenseRepository.findAll(), hasSize(1));
        expenseRepository.delete(expense);
        assertThat(expenseRepository.findAll(), empty());
    }

    @AfterEach
    public void tearDown() {
        expenseRepository.deleteAll();
    }

}
