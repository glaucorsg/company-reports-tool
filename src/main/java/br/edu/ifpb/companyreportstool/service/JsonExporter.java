package br.edu.ifpb.companyreportstool.service;

import org.springframework.stereotype.Service;

import java.util.List;


public class JsonExporter implements ReportExporter{
    public String exportHeader(String title) {
        return "{header: \""+title+"\"}";
    }

    public String exportFooter(String desc){
        return "footer: \""+desc+"\"}";
    }

    public String exportBody(String subtitle, List<String> dados){
        return "main: { title: \""+subtitle+"\""+"content: \""+dados+"\"";
    }
}
