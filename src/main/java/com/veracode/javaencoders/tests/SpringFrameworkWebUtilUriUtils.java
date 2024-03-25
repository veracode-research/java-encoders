package com.veracode.javaencoders.tests;

import com.veracode.javaencoders.LibraryEncodedResults;
import com.veracode.javaencoders.MethodEncodeResult;
import com.veracode.javaencoders.TestChar;
import com.veracode.javaencoders.TestSet;

import java.util.Iterator;

public class SpringFrameworkWebUtilUriUtils implements EncodeTest{

    private String libraryName = "org.springframework.web.util.UriUtils";

    @Override
    public LibraryEncodedResults runTest(TestSet testSet, LibraryEncodedResults whereToStoreResults) {

        MethodEncodeResult encRes1 = whereToStoreResults.createNewEmptyMethodResult("SpringFrameworkWebUtilUriUtils.encode (UTF-8)");
        MethodEncodeResult encRes2 = whereToStoreResults.createNewEmptyMethodResult("SpringFrameworkWebUtilUriUtils.encodeAuthority (UTF-8)");
        MethodEncodeResult encRes3 = whereToStoreResults.createNewEmptyMethodResult("SpringFrameworkWebUtilUriUtils.encodeFragment (UTF-8)");
        MethodEncodeResult encRes4 = whereToStoreResults.createNewEmptyMethodResult("SpringFrameworkWebUtilUriUtils.encodeHost (UTF-8)");
        MethodEncodeResult encRes5 = whereToStoreResults.createNewEmptyMethodResult("SpringFrameworkWebUtilUriUtils.encodePath (UTF-8)");
        MethodEncodeResult encRes6 = whereToStoreResults.createNewEmptyMethodResult("SpringFrameworkWebUtilUriUtils.encodePathSegment (UTF-8)");
        MethodEncodeResult encRes7 = whereToStoreResults.createNewEmptyMethodResult("SpringFrameworkWebUtilUriUtils.encodePort (UTF-8)");
        MethodEncodeResult encRes8 = whereToStoreResults.createNewEmptyMethodResult("SpringFrameworkWebUtilUriUtils.encodeQuery (UTF-8)");
        MethodEncodeResult encRes9 = whereToStoreResults.createNewEmptyMethodResult("SpringFrameworkWebUtilUriUtils.encodeQueryParam (UTF-8)");
        MethodEncodeResult encResA = whereToStoreResults.createNewEmptyMethodResult("SpringFrameworkWebUtilUriUtils.encodeScheme (UTF-8)");
        MethodEncodeResult encResB = whereToStoreResults.createNewEmptyMethodResult("SpringFrameworkWebUtilUriUtils.encodeUserInfo (UTF-8)");

        Iterator<TestChar> it = testSet.getTestChars().iterator();

        while (it.hasNext()) {
            char c = it.next().getChar();
            encRes1.encodedValuePairs.put(c, org.springframework.web.util.UriUtils.encode(String.valueOf(c), "UTF-8"));
            encRes2.encodedValuePairs.put(c, org.springframework.web.util.UriUtils.encodeAuthority(String.valueOf(c), "UTF-8"));
            encRes3.encodedValuePairs.put(c, org.springframework.web.util.UriUtils.encodeFragment(String.valueOf(c), "UTF-8"));
            encRes4.encodedValuePairs.put(c, org.springframework.web.util.UriUtils.encodeHost(String.valueOf(c), "UTF-8"));
            encRes5.encodedValuePairs.put(c, org.springframework.web.util.UriUtils.encodePath(String.valueOf(c), "UTF-8"));
            encRes6.encodedValuePairs.put(c, org.springframework.web.util.UriUtils.encodePathSegment(String.valueOf(c), "UTF-8"));
            encRes7.encodedValuePairs.put(c, org.springframework.web.util.UriUtils.encodePort(String.valueOf(c), "UTF-8"));
            encRes8.encodedValuePairs.put(c, org.springframework.web.util.UriUtils.encodeQuery(String.valueOf(c), "UTF-8"));
            encRes9.encodedValuePairs.put(c, org.springframework.web.util.UriUtils.encodeQueryParam(String.valueOf(c), "UTF-8"));
            encResA.encodedValuePairs.put(c, org.springframework.web.util.UriUtils.encodeScheme(String.valueOf(c), "UTF-8"));
            encResB.encodedValuePairs.put(c, org.springframework.web.util.UriUtils.encodeUserInfo(String.valueOf(c), "UTF-8"));
        }

        return whereToStoreResults;
    }


    public String getLibraryName() {
        return libraryName;
    }
}
