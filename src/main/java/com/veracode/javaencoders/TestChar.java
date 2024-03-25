package com.veracode.javaencoders;

public class TestChar {
    public enum CharRelevantFor {
        CRLF,
        XSS_HTML_CONTENT,
        XSS_HTML_ATTRIBUTE,
        XSS_HTML,
        XSS_CSS_URL,
        XSS_CSS_STRING,
        XSS_URL,
        NO_SPECIAL_CARE
    }

    ;

    private char c;

    private CharRelevantFor[] relevantFor;

    public TestChar(char c, CharRelevantFor[] relevantFor) {
        this.c = c;
        this.relevantFor = relevantFor;
    }

    public char getChar() {
        return c;
    }

    public CharRelevantFor[] getRelevantFor() {
        return relevantFor;
    }

    public String getPrintableCharName() {

        if (Character.isWhitespace(c) || Character.isISOControl(c)) {
            return String.format("[0x%04X] - %s", (int) c, Character.getName(c));
        }

        return String.format("[0x%04X] - %s", (int) c, String.valueOf(c));
    }
}
