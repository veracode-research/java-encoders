package com.veracode.javaencoders.tests;

import com.veracode.javaencoders.LibraryEncodedResults;
import com.veracode.javaencoders.MethodEncodeResult;
import com.veracode.javaencoders.TestChar;
import com.veracode.javaencoders.TestSet;

import java.util.Iterator;

public class ApacheCommonsStringEscapeUtils implements EncodeTest{

    private String libraryName = "org.apache.commons.lang.StringEscapeUtils";

    @Override
    public LibraryEncodedResults runTest(TestSet testSet, LibraryEncodedResults whereToStoreResults) {

        MethodEncodeResult encRes3 = whereToStoreResults.createNewEmptyMethodResult("StringEscapeUtils.escapeHtml");
        MethodEncodeResult encRes4 = whereToStoreResults.createNewEmptyMethodResult("StringEscapeUtils.escapeJava");
        MethodEncodeResult encRes5 = whereToStoreResults.createNewEmptyMethodResult("StringEscapeUtils.escapeJavaScript");


        Iterator<TestChar> it = testSet.getTestChars().iterator();

        while (it.hasNext()) {
            char c = it.next().getChar();
            encRes3.encodedValuePairs.put(c, org.apache.commons.lang.StringEscapeUtils.escapeHtml(String.valueOf(c)));
            encRes4.encodedValuePairs.put(c, org.apache.commons.lang.StringEscapeUtils.escapeJava(String.valueOf(c)));
            encRes5.encodedValuePairs.put(c, org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(String.valueOf(c)));
        }

        return whereToStoreResults;
    }


    public String getLibraryName() {
        return libraryName;
    }
}
