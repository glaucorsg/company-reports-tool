package br.edu.ifpb.companyreportstool.service;

import br.edu.ifpb.companyreportstool.repository.TaxRepository;
import org.springframework.stereotype.Service;


public class TaxReportHtml extends TaxReport{
    public TaxReportHtml(TaxRepository taxRepository) {
        super(taxRepository);
    }

    public ReportExporter getExporter() {
        return new HtmlExporter();
    }
}
