package com.veracode.javaencoders;

import com.veracode.javaencoders.tests.ApacheCommonsStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ApacheCommonsStringUtilsController {

    @Autowired
    private TemplateEngine te;

    @RequestMapping(value = "/ApacheCommonsStringUtils/generateFile")
    public ModelAndView generateFile() {

        try {
            TestSet myTestSet = new TestSet();
            EncodingTester testerApacheCommonsStringUtils = new EncodingTester(myTestSet, new ApacheCommonsStringUtils());
            testerApacheCommonsStringUtils.runTest();

            TemplateWriter tw = new TemplateWriter(te);
            tw.saveToFile(testerApacheCommonsStringUtils);
        }catch (Exception ex){
            ModelAndView mv = new ModelAndView("error");
            mv.addObject("message", "Error generating file. "  + ex.getMessage());
            return mv;
        }

        ModelAndView mv = new ModelAndView("confirm_saved_file");
        mv.addObject("message", "File generated successfully");
        return mv;
    }




    @RequestMapping(value = "/ApacheCommonsStringUtils/esegui")
    public void display(HttpServletResponse response ) throws IOException {

        try {
            TestSet myTestSet = new TestSet();
            EncodingTester testerApacheCommonsStringUtils = new EncodingTester(myTestSet, new ApacheCommonsStringUtils());
            testerApacheCommonsStringUtils.runTest();

            TemplateWriter tw = new TemplateWriter(te);
                       tw.sendToWriter(response.getWriter(), testerApacheCommonsStringUtils);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            response.sendError(500);
        }
    }


    @RequestMapping(value = "/ApacheCommonsStringUtils/test")
    public void test(HttpServletResponse response ) throws IOException {

        try {
            TestSet myTestSet = new TestSet();
            EncodingTester testerApacheCommonsStringUtils = new EncodingTester(myTestSet, new ApacheCommonsStringUtils());
            testerApacheCommonsStringUtils.runTest();

            TemplateWriter tw = new TemplateWriter(te);
                       tw.sendToWriterTester(response.getWriter(), testerApacheCommonsStringUtils);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            response.sendError(500);
        }
    }


}
