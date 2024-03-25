package com.veracode.javaencoders.tests;

import com.veracode.javaencoders.LibraryEncodedResults;
import com.veracode.javaencoders.MethodEncodeResult;
import com.veracode.javaencoders.TestChar;
import com.veracode.javaencoders.TestSet;

import java.util.Iterator;

public class OwaspJavaEncoder implements EncodeTest {

    private String libraryName = "org.owasp.encoder";

    @Override
    public LibraryEncodedResults runTest(TestSet testSet, LibraryEncodedResults whereToStoreResults) {

        MethodEncodeResult encRes1 = whereToStoreResults.createNewEmptyMethodResult("encoder.forCDATA");
        MethodEncodeResult encRes2 = whereToStoreResults.createNewEmptyMethodResult("encoder.forCssString");
        MethodEncodeResult encRes3 = whereToStoreResults.createNewEmptyMethodResult("encoder.forCssUrl");
        MethodEncodeResult encRes4 = whereToStoreResults.createNewEmptyMethodResult("encoder.forHtml");
        MethodEncodeResult encRes5 = whereToStoreResults.createNewEmptyMethodResult("encoder.forHtmlAttribute");
        MethodEncodeResult encRes6 = whereToStoreResults.createNewEmptyMethodResult("encoder.forHtmlContent");
        MethodEncodeResult encRes7 = whereToStoreResults.createNewEmptyMethodResult("encoder.forHtmlUnquotedAttribute");
        MethodEncodeResult encRes8 = whereToStoreResults.createNewEmptyMethodResult("encoder.forJava");
        MethodEncodeResult encRes9 = whereToStoreResults.createNewEmptyMethodResult("encoder.forJavaScript");
        MethodEncodeResult encRes10 = whereToStoreResults.createNewEmptyMethodResult("encoder.forJavaScriptAttribute");
        MethodEncodeResult encRes11 = whereToStoreResults.createNewEmptyMethodResult("encoder.forJavaScriptBlock");
        MethodEncodeResult encRes12 = whereToStoreResults.createNewEmptyMethodResult("encoder.forJavaScriptSource");
        MethodEncodeResult encRes13 = whereToStoreResults.createNewEmptyMethodResult("encoder.forUri");
        MethodEncodeResult encRes14 = whereToStoreResults.createNewEmptyMethodResult("encoder.forUriComponent");
        MethodEncodeResult encRes15 = whereToStoreResults.createNewEmptyMethodResult("encoder.forXml");
        MethodEncodeResult encRes16 = whereToStoreResults.createNewEmptyMethodResult("encoder.forXmlComment");
        MethodEncodeResult encRes17 = whereToStoreResults.createNewEmptyMethodResult("encoder.forXmlContent");

        Iterator<TestChar> it = testSet.getTestChars().iterator();

        while (it.hasNext()) {
            char c = it.next().getChar();
            encRes1.encodedValuePairs.put(c, org.owasp.encoder.Encode.forCDATA(String.valueOf(c)));
            encRes2.encodedValuePairs.put(c, org.owasp.encoder.Encode.forCssString(String.valueOf(c)));
            encRes3.encodedValuePairs.put(c, org.owasp.encoder.Encode.forCssUrl(String.valueOf(c)));
            encRes4.encodedValuePairs.put(c, org.owasp.encoder.Encode.forHtml(String.valueOf(c)));
            encRes5.encodedValuePairs.put(c, org.owasp.encoder.Encode.forHtmlAttribute(String.valueOf(c)));
            encRes6.encodedValuePairs.put(c, org.owasp.encoder.Encode.forHtmlContent(String.valueOf(c)));
            encRes7.encodedValuePairs.put(c, org.owasp.encoder.Encode.forHtmlUnquotedAttribute(String.valueOf(c)));
            encRes8.encodedValuePairs.put(c, org.owasp.encoder.Encode.forJava(String.valueOf(c)));
            encRes9.encodedValuePairs.put(c, org.owasp.encoder.Encode.forJavaScript(String.valueOf(c)));
            encRes10.encodedValuePairs.put(c, org.owasp.encoder.Encode.forJavaScriptAttribute(String.valueOf(c)));
            encRes11.encodedValuePairs.put(c, org.owasp.encoder.Encode.forJavaScriptBlock(String.valueOf(c)));
            encRes12.encodedValuePairs.put(c, org.owasp.encoder.Encode.forJavaScriptSource(String.valueOf(c)));
            encRes13.encodedValuePairs.put(c, org.owasp.encoder.Encode.forUri(String.valueOf(c)));
            encRes14.encodedValuePairs.put(c, org.owasp.encoder.Encode.forUriComponent(String.valueOf(c)));
            encRes15.encodedValuePairs.put(c, org.owasp.encoder.Encode.forXml(String.valueOf(c)));
            encRes16.encodedValuePairs.put(c, org.owasp.encoder.Encode.forXmlComment(String.valueOf(c)));
            encRes17.encodedValuePairs.put(c, org.owasp.encoder.Encode.forXmlContent(String.valueOf(c)));

        }

        return whereToStoreResults;
    }


    public String getLibraryName() {
        return libraryName;
    }
}
