package br.edu.ifpb.companyreportstool.service;

import br.edu.ifpb.companyreportstool.repository.ExpenseRepository;
import org.springframework.stereotype.Service;


public class ExpenseReportHtml extends ExpenseReport{
    public ExpenseReportHtml(ExpenseRepository expenseRepository) {
        super(expenseRepository);
    }


    public ReportExporter getExporter() {
        return new HtmlExporter();
    }
}
