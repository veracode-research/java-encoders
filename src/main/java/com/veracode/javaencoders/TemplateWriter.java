package com.veracode.javaencoders;

import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.FileWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ComponentScan
public class TemplateWriter {

    private TemplateEngine te;

    public TemplateWriter(TemplateEngine templateEngine) {
        te = templateEngine;
    }

    public void saveToFile(EncodingTester testObj) throws Exception{

        Context ctx = new Context();
        ctx.setVariable("results", testObj.getResults().getMethodEncodeResults());
        ctx.setVariable("testChars", testObj.getTestSet().getTestChars());
        ctx.setVariable("libraryName", testObj.getLibraryName());

        String dayTime =  LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm"));

        Writer writer = new FileWriter("generated/" + testObj.getLibraryName() + "_" + dayTime.replace(" ", "-") + ".html");
        writer.write(te.process("encodercomparisonbylibrary", ctx));
        writer.close();
    }


    public void sendToWriter(Writer writer, EncodingTester testObj) throws Exception{

        Context ctx = new Context();

        ctx.setVariable("results", testObj.getResults().getMethodEncodeResults());
        ctx.setVariable("testChars", testObj.getTestSet().getTestChars());
        ctx.setVariable("libraryName", testObj.getLibraryName());


        //Writer writer = new FileWriter("generated/mio.html");
        writer.write(te.process("encodercomparisonbylibrary", ctx));
        writer.close();
    }

    public void sendToWriterTester(Writer writer, EncodingTester testObj) throws Exception{

        Context ctx = new Context();

        ctx.setVariable("results", testObj.getResults().getMethodEncodeResults());
        ctx.setVariable("testChars", testObj.getTestSet().getTestChars());
        ctx.setVariable("libraryName", testObj.getLibraryName());

        writer.write(te.process("encodercomparisonbylibrarytest", ctx));
        writer.close();
    }


}
