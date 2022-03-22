package br.edu.ifpb.companyreportstool.service;

import br.edu.ifpb.companyreportstool.repository.TaxRepository;
import org.springframework.stereotype.Service;


public class TaxReportJson extends TaxReport{
    public TaxReportJson(TaxRepository taxRepository) {
        super(taxRepository);
    }

    public ReportExporter getExporter(){

        return new JsonExporter();
    }
}
