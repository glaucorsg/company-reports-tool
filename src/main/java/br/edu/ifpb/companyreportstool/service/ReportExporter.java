package br.edu.ifpb.companyreportstool.service;

import org.springframework.stereotype.Service;

import java.util.List;


public interface ReportExporter {

    String exportHeader(String title);
    String exportBody(String subtitle, List<String> dados);
    String exportFooter(String desc);
    
}
