package com.veracode.javaencoders;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

/**
 * Library to test how a method call handles CRLF characters
 */
@Controller
public class VerifyCharHandlingForLibrary {
    static org.apache.logging.log4j.Logger logger;

    @RequestMapping(value = "/testLog4jCharHandling")
    public String verifyLog4J() {

        TestSet setOfTestChar = new TestSet();

        logger = LogManager.getLogger(VerifyCharHandlingForLibrary.class.getName());

        Iterator<TestChar> it = setOfTestChar.getTestChars().iterator();

        while (it.hasNext()) {
            char c = it.next().getChar();
            logger.warn("Test -> char [" + (int) c + "]");
            logger.warn("PRE" + c + "POST");
        }


        return "welcome";
    }


    @RequestMapping(value = "/testHeaderCharHandling")
    public String testHeaderInjection(HttpServletResponse res, HttpServletRequest req) {


        TestSet setOfTestChar = new TestSet();
        //StringBuilder payload = new StringBuilder();

        Iterator<TestChar> it = setOfTestChar.getTestChars().iterator();

        while (it.hasNext()) {
            char c = it.next().getChar();
            res.addCookie(req.getCookies()[0]);
             res.addHeader("$B" + c + "A", "$BH_" + (int)c + "_" + c + "AH");
            if (c >= 33 && c != 34 && c != 91 && c != 93 && c != 92 && c != 59) {
                res.addCookie(new Cookie("B_" + (int)c + "_"  + "A", "BC_" + (int)c + "_"  + c + "AC"));
            }
        }

        return "welcome";
    }

    public void checkLibrary(){

    }


}
