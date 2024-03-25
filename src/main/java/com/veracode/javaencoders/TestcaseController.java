package com.veracode.javaencoders;

import com.liferay.portal.util.HtmlImpl;
import org.apache.axis.components.encoding.XMLEncoder;
import org.apache.axis.components.encoding.XMLEncoderFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class TestcaseController {
    //static org.apache.logging.log4j.Logger logger = LogManager.getLogger(VerifyCharHandlingForLibrary.class.getName());
    static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VerifyCharHandlingForLibrary.class.getName());
    ;


    /**
     * Testcase to validate the cleansers
     *
     * @param response
     * @param taint
     * @return
     */
    @RequestMapping(value = "/TestcaseControllerSanitized/{taint}")
    public void runTestCaseSanitized(HttpServletResponse response, @PathVariable("taint") String taint) throws IOException {

        logger.info(taint);

        //org.apache.commons.lang.StringEscapeUtils
        logger.info(org.apache.commons.lang.StringEscapeUtils.escapeJava(taint));
        logger.info(org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(taint));

        //org.apache.commons.lang.StringUtils
        logger.info(org.apache.commons.lang.StringUtils.normalizeSpace(taint));
        logger.info(org.apache.commons.lang.StringUtils.deleteWhitespace(taint));

        //org.owasp.reform.Reform
        logger.info(org.owasp.reform.Reform.HtmlEncode(taint));

        //org.apache.commons.lang3.StringUtils
        logger.info(org.apache.commons.lang3.StringUtils.deleteWhitespace(taint));
        logger.info(org.apache.commons.lang3.StringUtils.normalizeSpace(taint));


        logger.info(org.springframework.web.util.UriUtils.encode(taint, "UTF-8"));
        logger.info(org.springframework.web.util.UriUtils.encodeAuthority(taint, "UTF-8"));
        logger.info(org.springframework.web.util.UriUtils.encodeFragment(taint, "UTF-8"));
        logger.info(org.springframework.web.util.UriUtils.encodeHost(taint, "UTF-8"));
        logger.info(org.springframework.web.util.UriUtils.encodePath(taint, "UTF-8"));
        logger.info(org.springframework.web.util.UriUtils.encodePathSegment(taint, "UTF-8"));
        logger.info(org.springframework.web.util.UriUtils.encodePort(taint, "UTF-8"));
        logger.info(org.springframework.web.util.UriUtils.encodeQuery(taint, "UTF-8"));
        logger.info(org.springframework.web.util.UriUtils.encodeQueryParam(taint, "UTF-8"));
        logger.info(org.springframework.web.util.UriUtils.encodeScheme(taint, "UTF-8"));
        logger.info(org.springframework.web.util.UriUtils.encodeUserInfo(taint, "UTF-8"));


        java.io.PrintWriter outStream =  response.getWriter();

        outStream.println(taint);

        outStream.println(org.springframework.web.util.UriUtils.encode(taint, "UTF-8"));
        outStream.println(org.springframework.web.util.UriUtils.encodePort(taint, "UTF-8"));
        outStream.println(org.springframework.web.util.UriUtils.encodeScheme(taint, "UTF-8"));

        /*
        The following methods are not considered as valid cleansers for XSS because
        they don't encode single quote.
         */
        outStream.println(org.springframework.web.util.UriUtils.encodeAuthority(taint, "UTF-8"));
        outStream.println(org.springframework.web.util.UriUtils.encodeFragment(taint, "UTF-8"));
        outStream.println(org.springframework.web.util.UriUtils.encodeHost(taint, "UTF-8"));
        outStream.println(org.springframework.web.util.UriUtils.encodePath(taint, "UTF-8"));
        outStream.println(org.springframework.web.util.UriUtils.encodePathSegment(taint, "UTF-8"));
        outStream.println(org.springframework.web.util.UriUtils.encodeQuery(taint, "UTF-8"));
        outStream.println(org.springframework.web.util.UriUtils.encodeQueryParam(taint, "UTF-8"));
        outStream.println(org.springframework.web.util.UriUtils.encodeUserInfo(taint, "UTF-8"));

        /*
        org.apache.commons.text.StringEscapeUtils
        The escapeHtml3 and escapeHtml4 methods don't properly convert the single quote character, and for this reason we don't
        consider them as valid cleansers for XSS.
        The only methods that properly convert >, <, ", ' are escapeXml10 and escapeXml11
         */

        logger.info(org.apache.commons.text.StringEscapeUtils.escapeXml10(taint));
        logger.info(org.apache.commons.text.StringEscapeUtils.escapeXml11(taint));

        logger.info(org.apache.commons.text.StringEscapeUtils.escapeCsv(taint));
        logger.info(org.apache.commons.text.StringEscapeUtils.escapeEcmaScript(taint));
        logger.info(org.apache.commons.text.StringEscapeUtils.escapeHtml3(taint));
        logger.info(org.apache.commons.text.StringEscapeUtils.escapeHtml4(taint));
        logger.info(org.apache.commons.text.StringEscapeUtils.escapeJava(taint));
        logger.info(org.apache.commons.text.StringEscapeUtils.escapeJson(taint));
        logger.info(org.apache.commons.text.StringEscapeUtils.escapeXml10(taint));
        logger.info(org.apache.commons.text.StringEscapeUtils.escapeXml11(taint));
        logger.info(org.apache.commons.text.StringEscapeUtils.escapeXSI(taint));

        /*
        they properly convert the new line characters
         */
        outStream.println(org.apache.commons.text.StringEscapeUtils.escapeXml10(taint));
        outStream.println(org.apache.commons.text.StringEscapeUtils.escapeXml11(taint));

        outStream.println(org.apache.commons.text.StringEscapeUtils.escapeCsv(taint));
        outStream.println(org.apache.commons.text.StringEscapeUtils.escapeEcmaScript(taint));
        outStream.println(org.apache.commons.text.StringEscapeUtils.escapeHtml3(taint));
        outStream.println(org.apache.commons.text.StringEscapeUtils.escapeHtml4(taint));
        outStream.println(org.apache.commons.text.StringEscapeUtils.escapeJava(taint));
        outStream.println(org.apache.commons.text.StringEscapeUtils.escapeJson(taint));
        outStream.println(org.apache.commons.text.StringEscapeUtils.escapeXml10(taint));
        outStream.println(org.apache.commons.text.StringEscapeUtils.escapeXml11(taint));
        outStream.println(org.apache.commons.text.StringEscapeUtils.escapeXSI(taint));

        //return "<html><body>End Execution <p>" + cleansedString + "</p><body></html>"; // ?
    }



    @RequestMapping(value = "/runTestCaseForNotCleansers/{taint}")
    public String runTestCaseForNotCleansers(HttpServletResponse response, @PathVariable("taint") String taint) throws IOException  {


        taint = taint + "\\n:\nend";


        logger.info(taint);


        /*
        GWT
         */
        logger.info(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(taint));
        logger.info(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscapeAllowEntities(taint));
        logger.info(com.google.gwt.safehtml.shared.SafeHtmlUtils.fromString(taint).asString());


        /*
        org.springframework.web.util.HtmlUtils
         */
        logger.info(org.springframework.web.util.HtmlUtils.htmlEscape(taint));
        logger.info(org.springframework.web.util.HtmlUtils.htmlEscapeDecimal(taint));
        logger.info(org.springframework.web.util.HtmlUtils.htmlEscapeHex(taint));

        /*
        org.apache.axis.components.encoding.XMLEncoder
         */
        XMLEncoder encoder = XMLEncoderFactory.getDefaultEncoder();
        logger.info(encoder.encode(taint));

        /*
        Liferay
         */
        com.liferay.portal.util.HtmlImpl newLifeRayHtml = new HtmlImpl();
        com.liferay.portal.kernel.util.HtmlUtil liferayPortalObj = new com.liferay.portal.kernel.util.HtmlUtil();
        liferayPortalObj.setHtml(newLifeRayHtml);

        logger.info(liferayPortalObj.escapeAttribute(taint));
        logger.info(liferayPortalObj.escape(taint));
        logger.info(liferayPortalObj.escapeCSS(taint));
        logger.info(liferayPortalObj.escapeHREF(taint));
        logger.info(liferayPortalObj.escapeJS(taint));
        logger.info(liferayPortalObj.escapeXPath(taint));
        logger.info(liferayPortalObj.escapeXPathAttribute(taint));
        logger.info(liferayPortalObj.escapeURL(taint));

        return "<html><body>TestCase completed" + taint + "<body></html>";
    }

}
