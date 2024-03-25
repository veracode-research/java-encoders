package com.veracode.javaencoders;

import com.veracode.javaencoders.tests.EncodeTest;

public class EncodingTester {

    private TestSet testSet;
    private EncodeTest encodeTest;
    private LibraryEncodedResults results;


    public EncodingTester(TestSet testSet, EncodeTest encodeTest) {
        this.testSet = testSet;
        this.encodeTest = encodeTest;
        this.results = new LibraryEncodedResults(this.encodeTest.getLibraryName());
    }


    /**
     * This method runs the tests on the test set and generates a LibraryEncodedResults object containing the outcome of the tests.
     *
     * @return
     */
    public LibraryEncodedResults runTest() {

        if(this.results == null){
            this.results = new LibraryEncodedResults("No Library Set");
        }

        this.encodeTest.runTest(this.testSet, this.results);

        return this.results;

    }

    public LibraryEncodedResults getResults() {
        if(this.results == null){
            this.results = new LibraryEncodedResults("No Library Set");
        }

        return results;
    }

    public String getLibraryName() {
        return encodeTest.getLibraryName();
    }

    public TestSet getTestSet() {
        return testSet;
    }
}
