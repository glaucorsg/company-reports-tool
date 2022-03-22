package br.edu.ifpb.companyreportstool.service;

import br.edu.ifpb.companyreportstool.repository.ExpenseRepository;
import org.springframework.stereotype.Service;


public class ExpenseReportJson extends ExpenseReport{
    public ExpenseReportJson(ExpenseRepository expenseRepository) {
        super(expenseRepository);
    }


    public ReportExporter getExporter() {
        return new JsonExporter();
    }
}
