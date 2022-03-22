package br.edu.ifpb.companyreportstool.service;

import org.springframework.stereotype.Service;

@Service
public abstract class ReportService {
    public String generateReport(){
        return writeHeader()+writeBody()+writeFooter();
    }

    public String writeHeader(){
        return getExporter().exportHeader("Company Report");
    }

    public String writeFooter(){
        return getExporter().exportFooter("2022 - Design Patterns IFPB");

    }

    public abstract String writeBody();

    public abstract ReportExporter getExporter();
}
