package br.edu.ifpb.companyreportstool.service;

import br.edu.ifpb.companyreportstool.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;


public abstract class ExpenseReport extends ReportService {

    private final ExpenseRepository expenseRepository;

    public ExpenseReport(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

//    public String generateReport(String type) {
//        if (type.equals("html")) {
//            return "<header><h1>Company Report</h1></header>" +
//                    "<main><h2>This is the Expense Report</h2>" +
//                    "<p>" + fillBodyHtml() + "</p></main>" +
//                    "<footer>2022 - Design Patterns IFPB</footer>";
//        } else if (type.equals("json")) {
//            return "{ header: \"Company Report\" ," +
//                    "main: { title: \"This is the Expense Report\", " +
//                    "content: \"" + fillBodyJson() + "\" ," +
//                    "footer: \"2022 - Design Patterns IFPB\" }";
//        }
//        return "";
//    }

    public String writeBody() {
        return expenseRepository.findAll().stream()
                .map(Objects::toString).collect(Collectors.joining(" "));
    }

}

