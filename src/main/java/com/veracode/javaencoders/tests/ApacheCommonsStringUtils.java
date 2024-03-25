package com.veracode.javaencoders.tests;

import com.veracode.javaencoders.LibraryEncodedResults;
import com.veracode.javaencoders.MethodEncodeResult;
import com.veracode.javaencoders.TestChar;
import com.veracode.javaencoders.TestSet;

import java.util.Iterator;

public class ApacheCommonsStringUtils implements EncodeTest{

    private String libraryName = "org.apache.commons.lang.StringUtils";

    @Override
    public LibraryEncodedResults runTest(TestSet testSet, LibraryEncodedResults whereToStoreResults) {

        MethodEncodeResult encRes1 = whereToStoreResults.createNewEmptyMethodResult("StringUtils.normalizeSpace");
        MethodEncodeResult encRes2 = whereToStoreResults.createNewEmptyMethodResult("StringUtils.deleteWhitespace");


        Iterator<TestChar> it = testSet.getTestChars().iterator();

        while (it.hasNext()) {
            char c = it.next().getChar();
            encRes1.encodedValuePairs.put(c,org.apache.commons.lang.StringUtils.normalizeSpace(String.valueOf(c)));
            encRes2.encodedValuePairs.put(c, org.apache.commons.lang.StringUtils.deleteWhitespace(String.valueOf(c)));
        }

        return whereToStoreResults;
    }


    public String getLibraryName() {
        return libraryName;
    }
}
