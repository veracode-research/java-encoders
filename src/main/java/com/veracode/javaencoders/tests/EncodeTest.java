package com.veracode.javaencoders.tests;

import com.veracode.javaencoders.LibraryEncodedResults;
import com.veracode.javaencoders.TestSet;

public interface EncodeTest {

    public LibraryEncodedResults runTest(TestSet testSet, LibraryEncodedResults whereToStoreResults);

    public String getLibraryName();
}
