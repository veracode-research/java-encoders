package com.veracode.javaencoders;

import java.util.ArrayList;

public class LibraryEncodedResults {

    private String libraryName;
    private ArrayList<MethodEncodeResult> methodEncodeResults;

    public LibraryEncodedResults(String libraryName) {
        this.libraryName = libraryName;
    }

    public ArrayList<MethodEncodeResult> getMethodEncodeResults() {
        return methodEncodeResults;
    }

    public LibraryEncodedResults addEncodeResult(MethodEncodeResult resultToAdd){
        if(this.methodEncodeResults == null) {
            this.methodEncodeResults = new ArrayList<>();
        }
        this.methodEncodeResults.add(resultToAdd);
        return this;
    }

    public MethodEncodeResult createNewEmptyMethodResult(String method){
        MethodEncodeResult newEmptyMethodEncodeResult = new MethodEncodeResult(this, method);

        this.addEncodeResult(newEmptyMethodEncodeResult);

        return newEmptyMethodEncodeResult;
    }

    public String getLibraryName() {
        return libraryName;
    }
}
