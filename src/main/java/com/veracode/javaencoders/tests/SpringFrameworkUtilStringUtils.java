package com.veracode.javaencoders.tests;

import com.veracode.javaencoders.LibraryEncodedResults;
import com.veracode.javaencoders.MethodEncodeResult;
import com.veracode.javaencoders.TestChar;
import com.veracode.javaencoders.TestSet;

import java.util.Iterator;

public class SpringFrameworkUtilStringUtils implements EncodeTest{

    private String libraryName = "org.springframework.util.StringUtils";

    @Override
    public LibraryEncodedResults runTest(TestSet testSet, LibraryEncodedResults whereToStoreResults) {

        MethodEncodeResult encRes1 = whereToStoreResults.createNewEmptyMethodResult("StringUtils.trimAllWhitespace");
        MethodEncodeResult encRes2 = whereToStoreResults.createNewEmptyMethodResult("StringUtils.trimWhitespace - Not a Cleanser");



        Iterator<TestChar> it = testSet.getTestChars().iterator();

        while (it.hasNext()) {
            char c = it.next().getChar();
            encRes1.encodedValuePairs.put(c,org.springframework.util.StringUtils.trimAllWhitespace(String.valueOf(c)));
            encRes2.encodedValuePairs.put(c,org.springframework.util.StringUtils.trimWhitespace(String.valueOf(c)));
        }

        return whereToStoreResults;
    }


    public String getLibraryName() {
        return libraryName;
    }
}
