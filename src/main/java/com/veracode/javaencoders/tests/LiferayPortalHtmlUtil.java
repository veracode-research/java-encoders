package com.veracode.javaencoders.tests;

import com.liferay.portal.util.HtmlImpl;
import com.veracode.javaencoders.LibraryEncodedResults;
import com.veracode.javaencoders.MethodEncodeResult;
import com.veracode.javaencoders.TestChar;
import com.veracode.javaencoders.TestSet;

import java.util.Iterator;

public class LiferayPortalHtmlUtil implements EncodeTest{

    private String libraryName = "com.liferay.portal.kernel.util.HtmlUtil";

    @Override
    public LibraryEncodedResults runTest(TestSet testSet, LibraryEncodedResults whereToStoreResults) {

        MethodEncodeResult encRes1 = whereToStoreResults.createNewEmptyMethodResult("HtmlUtil.escapeAttribute");
        MethodEncodeResult encRes2 = whereToStoreResults.createNewEmptyMethodResult("HtmlUtil.escape");
        MethodEncodeResult encRes3 = whereToStoreResults.createNewEmptyMethodResult("HtmlUtil.escapeCSS");
        MethodEncodeResult encRes4 = whereToStoreResults.createNewEmptyMethodResult("HtmlUtil.escapeHREF");
        MethodEncodeResult encRes5 = whereToStoreResults.createNewEmptyMethodResult("HtmlUtil.escapeJS");
        MethodEncodeResult encRes6 = whereToStoreResults.createNewEmptyMethodResult("HtmlUtil.escapeURL");
        MethodEncodeResult encRes7 = whereToStoreResults.createNewEmptyMethodResult("HtmlUtil.escapeXPath");
        MethodEncodeResult encRes8 = whereToStoreResults.createNewEmptyMethodResult("HtmlUtil.escapeXPathAttribute");



        Iterator<TestChar> it = testSet.getTestChars().iterator();

        com.liferay.portal.util.HtmlImpl newHtml = new HtmlImpl();
        com.liferay.portal.kernel.util.HtmlUtil portalObj = new com.liferay.portal.kernel.util.HtmlUtil();
        portalObj.setHtml(newHtml);


        while (it.hasNext()) {
            char c = it.next().getChar();

            encRes1.encodedValuePairs.put(c, portalObj.escapeAttribute(String.valueOf(c)));
            encRes2.encodedValuePairs.put(c, portalObj.escape(String.valueOf(c)));
            encRes3.encodedValuePairs.put(c, portalObj.escapeCSS(String.valueOf(c)));
            encRes4.encodedValuePairs.put(c, portalObj.escapeHREF(String.valueOf(c)));
            encRes5.encodedValuePairs.put(c, portalObj.escapeJS(String.valueOf(c)));
            encRes6.encodedValuePairs.put(c, portalObj.escapeURL(String.valueOf(c)));
            encRes7.encodedValuePairs.put(c, portalObj.escapeXPath(String.valueOf(c)));
            encRes8.encodedValuePairs.put(c, portalObj.escapeXPathAttribute(String.valueOf(c)));



        }

        return whereToStoreResults;
    }


    public String getLibraryName() {
        return libraryName;
    }
}
