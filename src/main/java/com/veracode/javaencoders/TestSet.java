package com.veracode.javaencoders;

import java.util.*;

public class TestSet {


    private Vector<TestChar> testChars;


    public TestSet() {

        this.testChars = new Vector<>();

        testChars.add(new TestChar((char)0x000A, new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF})); /* LF - Line feed */
        testChars.add(new TestChar((char)0x000B, new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF})); // VT - Vertical Tab
        testChars.add(new TestChar((char)0x000C, new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF})); // FF - Form feed
        testChars.add(new TestChar((char)0x000D, new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF})); // CR -  Carriage Return
        testChars.add(new TestChar((char)0x0085, new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF})); // NEL - Next line
        testChars.add(new TestChar((char)0x008B, new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF})); // Partial line forward
        testChars.add(new TestChar((char)0x008D, new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF})); // Reverse line feed
        testChars.add(new TestChar((char)0x2028, new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF})); // LS - Line separator
        testChars.add(new TestChar((char)0x2029, new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF})); // PS - Paragraph separator
        testChars.add(new TestChar('\\', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF}));
        testChars.add(new TestChar('\'', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.XSS_HTML, TestChar.CharRelevantFor.XSS_HTML_ATTRIBUTE}));
        testChars.add(new TestChar('"', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.XSS_HTML, TestChar.CharRelevantFor.XSS_HTML_ATTRIBUTE}));
        testChars.add(new TestChar('<', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.XSS_HTML, TestChar.CharRelevantFor.XSS_HTML_CONTENT}));
        testChars.add(new TestChar('>', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.XSS_HTML, TestChar.CharRelevantFor.XSS_HTML_CONTENT}));
        testChars.add(new TestChar(':', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.XSS_URL, TestChar.CharRelevantFor.XSS_CSS_URL}));
        testChars.add(new TestChar(';', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.NO_SPECIAL_CARE}));
        testChars.add(new TestChar('&', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.XSS_HTML, TestChar.CharRelevantFor.XSS_HTML_CONTENT, TestChar.CharRelevantFor.XSS_URL}));
        testChars.add(new TestChar('/', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.XSS_HTML, TestChar.CharRelevantFor.XSS_HTML_CONTENT}));
        testChars.add(new TestChar('=', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF}));
        testChars.add(new TestChar('(', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF}));
        testChars.add(new TestChar(')', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF}));
        testChars.add(new TestChar('[', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF}));
        testChars.add(new TestChar('{', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF}));
        testChars.add(new TestChar('}', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF}));
        testChars.add(new TestChar('#', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF}));
        testChars.add(new TestChar('`', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF}));
        testChars.add(new TestChar('$', new TestChar.CharRelevantFor[]{TestChar.CharRelevantFor.CRLF}));
    }

    public Vector<TestChar> getTestChars() {
        return testChars;
    }
}
