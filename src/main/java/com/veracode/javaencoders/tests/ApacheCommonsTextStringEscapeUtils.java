package com.veracode.javaencoders.tests;

import com.veracode.javaencoders.LibraryEncodedResults;
import com.veracode.javaencoders.MethodEncodeResult;
import com.veracode.javaencoders.TestChar;
import com.veracode.javaencoders.TestSet;

import java.util.Iterator;

public class ApacheCommonsTextStringEscapeUtils implements EncodeTest{

    private String libraryName = "org.apache.commons.text.StringEscapeUtils";

    @Override
    public LibraryEncodedResults runTest(TestSet testSet, LibraryEncodedResults whereToStoreResults) {

        MethodEncodeResult encRes1 = whereToStoreResults.createNewEmptyMethodResult("StringEscapeUtils.escapeCsv");
        MethodEncodeResult encRes2 = whereToStoreResults.createNewEmptyMethodResult("StringEscapeUtils.escapeEcmaScript");
        MethodEncodeResult encRes3 = whereToStoreResults.createNewEmptyMethodResult("StringEscapeUtils.escapeHtml3");
        MethodEncodeResult encRes4 = whereToStoreResults.createNewEmptyMethodResult("StringEscapeUtils.escapeHtml4");
        MethodEncodeResult encRes5 = whereToStoreResults.createNewEmptyMethodResult("StringEscapeUtils.escapeJava");
        MethodEncodeResult encRes6 = whereToStoreResults.createNewEmptyMethodResult("StringEscapeUtils.escapeJson");
        MethodEncodeResult encRes7 = whereToStoreResults.createNewEmptyMethodResult("StringEscapeUtils.escapeXml10");
        MethodEncodeResult encRes8 = whereToStoreResults.createNewEmptyMethodResult("StringEscapeUtils.escapeXml11");
        MethodEncodeResult encRes9 = whereToStoreResults.createNewEmptyMethodResult("StringEscapeUtils.escapeXSI");


        Iterator<TestChar> it = testSet.getTestChars().iterator();

        while (it.hasNext()) {
            char c = it.next().getChar();
            encRes1.encodedValuePairs.put(c,org.apache.commons.text.StringEscapeUtils.escapeCsv(String.valueOf(c)));
            encRes2.encodedValuePairs.put(c,org.apache.commons.text.StringEscapeUtils.escapeEcmaScript(String.valueOf(c)));
            encRes3.encodedValuePairs.put(c,org.apache.commons.text.StringEscapeUtils.escapeHtml3(String.valueOf(c)));
            encRes4.encodedValuePairs.put(c,org.apache.commons.text.StringEscapeUtils.escapeHtml4(String.valueOf(c)));
            encRes5.encodedValuePairs.put(c,org.apache.commons.text.StringEscapeUtils.escapeJava(String.valueOf(c)));
            encRes6.encodedValuePairs.put(c,org.apache.commons.text.StringEscapeUtils.escapeJson(String.valueOf(c)));
            encRes7.encodedValuePairs.put(c,org.apache.commons.text.StringEscapeUtils.escapeXml10(String.valueOf(c)));
            encRes8.encodedValuePairs.put(c,org.apache.commons.text.StringEscapeUtils.escapeXml11(String.valueOf(c)));
            encRes9.encodedValuePairs.put(c,org.apache.commons.text.StringEscapeUtils.escapeXSI(String.valueOf(c)));
        }

        return whereToStoreResults;
    }


    public String getLibraryName() {
        return libraryName;
    }
}
