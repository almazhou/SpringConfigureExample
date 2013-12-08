package com.springapp.domain;

import org.owasp.validator.html.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseWrapper extends HttpServletResponseWrapper {
    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public String getCharacterEncoding() {
        String value = super.getCharacterEncoding();
        if(value == null){
            return null;
        }
        return cleanXSS(value);
    }

    private String cleanXSS(String value) {
        AntiSamy antiSamy = new AntiSamy();
        try {
            final CleanResults cr = antiSamy.scan(value, Policy.getInstance("src/main/resources/antisamy-myspace-1.4.4.xml"), AntiSamy.SAX);
            return cr.getCleanHTML();
        } catch (ScanException e) {
            e.printStackTrace();
        } catch (PolicyException e) {
            e.printStackTrace();
        }
        return "";
    }

}
