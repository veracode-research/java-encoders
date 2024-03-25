package com.veracode.javaencoders.tests;

import com.veracode.javaencoders.LibraryEncodedResults;
import com.veracode.javaencoders.MethodEncodeResult;
import com.veracode.javaencoders.TestChar;
import com.veracode.javaencoders.TestSet;

import java.util.Iterator;

public class GoogleGWTSafeHtmlUtils implements EncodeTest{

    private String libraryName = "com.google.gwt.safehtml.shared.SafeHtmlUtils";

    @Override
    public LibraryEncodedResults runTest(TestSet testSet, LibraryEncodedResults whereToStoreResults) {

        MethodEncodeResult encRes1 = whereToStoreResults.createNewEmptyMethodResult("SafeHtmlUtils.htmlEscape");
        MethodEncodeResult encRes2 = whereToStoreResults.createNewEmptyMethodResult("SafeHtmlUtils.htmlEscapeAllowEntities");
        MethodEncodeResult encRes3 = whereToStoreResults.createNewEmptyMethodResult("SafeHtmlUtils.fromString");



        Iterator<TestChar> it = testSet.getTestChars().iterator();

        while (it.hasNext()) {
            char c = it.next().getChar();
            encRes1.encodedValuePairs.put(c,com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(String.valueOf(c)));
            encRes2.encodedValuePairs.put(c,com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscapeAllowEntities(String.valueOf(c)));
            encRes3.encodedValuePairs.put(c,com.google.gwt.safehtml.shared.SafeHtmlUtils.fromString(String.valueOf(c)).asString());

        }

        return whereToStoreResults;
    }


    public String getLibraryName() {
        return libraryName;
    }
}
