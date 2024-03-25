package com.veracode.javaencoders.tests;

import com.veracode.javaencoders.LibraryEncodedResults;
import com.veracode.javaencoders.MethodEncodeResult;
import com.veracode.javaencoders.TestChar;
import com.veracode.javaencoders.TestSet;
import org.apache.axis.components.encoding.XMLEncoder;
import org.apache.axis.components.encoding.XMLEncoderFactory;

import java.util.Iterator;

public class ApacheAxisXMLEncoder implements EncodeTest {

    private String libraryName = "org.apache.axis.components.encoding.XMLEncoder";

    @Override
    public LibraryEncodedResults runTest(TestSet testSet, LibraryEncodedResults whereToStoreResults) {

        MethodEncodeResult encRes1 = whereToStoreResults.createNewEmptyMethodResult("XMLEncoder.encode");
        XMLEncoder encoder = XMLEncoderFactory.getDefaultEncoder();

        Iterator<TestChar> it = testSet.getTestChars().iterator();

        while (it.hasNext()) {
            char c = it.next().getChar();
            try {
                encRes1.encodedValuePairs.put(c, encoder.encode(String.valueOf(c)));
            } catch (Exception ex) {
                encRes1.encodedValuePairs.put(c, "Exception encoding..." + ex.getMessage());
            }

        }

        return whereToStoreResults;
    }


    public String getLibraryName() {
        return libraryName;
    }
}
