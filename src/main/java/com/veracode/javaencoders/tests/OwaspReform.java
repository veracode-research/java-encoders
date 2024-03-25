package com.veracode.javaencoders.tests;

import com.veracode.javaencoders.LibraryEncodedResults;
import com.veracode.javaencoders.MethodEncodeResult;
import com.veracode.javaencoders.TestChar;
import com.veracode.javaencoders.TestSet;

import java.util.Iterator;

public class OwaspReform implements EncodeTest{

    private String libraryName = "org.owasp.reform.Reform";

    @Override
    public LibraryEncodedResults runTest(TestSet testSet, LibraryEncodedResults whereToStoreResults) {

        MethodEncodeResult encRes1 = whereToStoreResults.createNewEmptyMethodResult("Reform.HtmlAttributeEncode");
        MethodEncodeResult encRes2 = whereToStoreResults.createNewEmptyMethodResult("Reform.HtmlEncode");
        MethodEncodeResult encRes3 = whereToStoreResults.createNewEmptyMethodResult("Reform.JsString");
        MethodEncodeResult encRes4 = whereToStoreResults.createNewEmptyMethodResult("Reform.VbsString");
        MethodEncodeResult encRes5 = whereToStoreResults.createNewEmptyMethodResult("Reform.XmlAttributeEncode");
        MethodEncodeResult encRes6 = whereToStoreResults.createNewEmptyMethodResult("Reform.XmlEncode");






        Iterator<TestChar> it = testSet.getTestChars().iterator();

        while (it.hasNext()) {
            char c = it.next().getChar();
            encRes1.encodedValuePairs.put(c,org.owasp.reform.Reform.HtmlAttributeEncode(String.valueOf(c)));
            encRes2.encodedValuePairs.put(c,org.owasp.reform.Reform.HtmlEncode(String.valueOf(c)));
            encRes3.encodedValuePairs.put(c,org.owasp.reform.Reform.JsString(String.valueOf(c)));
            encRes4.encodedValuePairs.put(c,org.owasp.reform.Reform.VbsString(String.valueOf(c)));
            encRes5.encodedValuePairs.put(c,org.owasp.reform.Reform.XmlAttributeEncode(String.valueOf(c)));
            encRes6.encodedValuePairs.put(c,org.owasp.reform.Reform.XmlEncode(String.valueOf(c)));

        }

        return whereToStoreResults;
    }


    public String getLibraryName() {
        return libraryName;
    }
}
