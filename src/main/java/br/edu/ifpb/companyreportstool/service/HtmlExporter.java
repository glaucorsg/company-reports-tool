package br.edu.ifpb.companyreportstool.service;

import org.springframework.stereotype.Service;

import java.util.List;


public class HtmlExporter implements ReportExporter {

    public String exportHeader(String title) {
        return "<header><h1>"+title+"</h1></header>";
    }

    public String exportFooter(String desc){
        return "<footer>"+desc+"</footer>";
    }


    public String exportBody(String subtitle, List<String> dados){
        return "<main><h2>"+subtitle+"</h2>"+"<p>"+dados+"</p></main>";
    }


}
