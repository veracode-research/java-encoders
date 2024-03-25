package com.veracode.javaencoders.tests;

import com.veracode.javaencoders.LibraryEncodedResults;
import com.veracode.javaencoders.MethodEncodeResult;
import com.veracode.javaencoders.TestChar;
import com.veracode.javaencoders.TestSet;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encoder;
import org.owasp.esapi.StringUtilities;

import java.util.Iterator;

public class OwaspESAPI implements EncodeTest {

    private String libraryName = "org.owasp.esapi.ESAPI";

    @Override
    public LibraryEncodedResults runTest(TestSet testSet, LibraryEncodedResults whereToStoreResults) {

        MethodEncodeResult encRes1 = whereToStoreResults.createNewEmptyMethodResult("Encoder.encodeForBase64");
        MethodEncodeResult encRes2 = whereToStoreResults.createNewEmptyMethodResult("Encoder.encodeForCSS");
        MethodEncodeResult encRes3 = whereToStoreResults.createNewEmptyMethodResult("Encoder.encodeForHTML");
        MethodEncodeResult encRes4 = whereToStoreResults.createNewEmptyMethodResult("Encoder.encodeForHTMLAttribute");
        MethodEncodeResult encRes5 = whereToStoreResults.createNewEmptyMethodResult("Encoder.encodeForJavaScript");
        MethodEncodeResult encRes6 = whereToStoreResults.createNewEmptyMethodResult("Encoder.encodeForURL");
        MethodEncodeResult encRes7 = whereToStoreResults.createNewEmptyMethodResult("Encoder.encodeForXML");
        MethodEncodeResult encRes8 = whereToStoreResults.createNewEmptyMethodResult("Encoder.encodeForXMLAttribute");
        MethodEncodeResult encRes9 = whereToStoreResults.createNewEmptyMethodResult("ESAPI.StringUtilities.replaceLinearWhiteSpace");
        MethodEncodeResult encRes10 = whereToStoreResults.createNewEmptyMethodResult("ESAPI.StringUtilities.stripControls");


        Encoder encoder = ESAPI.encoder();

        Iterator<TestChar> it = testSet.getTestChars().iterator();

        while (it.hasNext()) {
            char c = it.next().getChar();
            encRes1.encodedValuePairs.put(c, encoder.encodeForBase64(new byte[]{(byte) c}, true));
            encRes2.encodedValuePairs.put(c, encoder.encodeForCSS(String.valueOf(c)));
            encRes3.encodedValuePairs.put(c, encoder.encodeForHTML(String.valueOf(c)));
            encRes4.encodedValuePairs.put(c, encoder.encodeForHTMLAttribute(String.valueOf(c)));
            encRes5.encodedValuePairs.put(c, encoder.encodeForJavaScript(String.valueOf(c)));
            try {

                encRes6.encodedValuePairs.put(c, encoder.encodeForURL(String.valueOf(c)));
            } catch (Exception ex) {
                encRes1.encodedValuePairs.put(c, "Exception encoding..." + ex.getMessage());
            }
            encRes7.encodedValuePairs.put(c, encoder.encodeForXML(String.valueOf(c)));
            encRes8.encodedValuePairs.put(c, encoder.encodeForXMLAttribute(String.valueOf(c)));
            encRes9.encodedValuePairs.put(c, StringUtilities.replaceLinearWhiteSpace(String.valueOf(c)));
            encRes10.encodedValuePairs.put(c, StringUtilities.stripControls(String.valueOf(c)));
        }

        return whereToStoreResults;
    }


    public String getLibraryName() {
        return libraryName;
    }
}
