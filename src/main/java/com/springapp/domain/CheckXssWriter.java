package com.springapp.domain;

import org.owasp.validator.html.*;

import java.io.PrintWriter;
import java.io.Writer;

public class CheckXssWriter extends PrintWriter {
    public CheckXssWriter(Writer writer) {
        super(writer);
    }

    public void write(char buf[], int off, int len) {
        StringBuffer sb = new StringBuffer(len);
        for (int i = 0; i < len; i++) {
            sb.append(buf[off + i]);
        }
        String s = sb.toString();
        String s1 = cleanXSS(s);
        for (int i = 0; i < s1.length(); i++) {
            write(s1.charAt(i));
        }
    }

    public void write(String s, int off, int len) {
        String s1 = cleanXSS(s);
        len = Math.min(s1.length(),len);
        for (int i = 0; i < len; i++) {
            write(s1.charAt(off + i));
        }
    }

    private String cleanXSS(String value) {
        AntiSamy antiSamy = new AntiSamy();
        if(false){
        try {
            final CleanResults cr = antiSamy.scan(value, Policy.getInstance("src/main/resources/antisamy-myspace-1.4.4.xml"), AntiSamy.SAX);
            return cr.getCleanHTML();
        } catch (ScanException e) {
            e.printStackTrace();
        } catch (PolicyException e) {
            e.printStackTrace();
        }
        }
        return value;
    }
}
