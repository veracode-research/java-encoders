package com.veracode.javaencoders;


import java.util.LinkedHashMap;

public class MethodEncodeResult {

    private LibraryEncodedResults libraryResultContainer;
    public String methodFullName;
    public LinkedHashMap<Character, String> encodedValuePairs;

    public MethodEncodeResult(LibraryEncodedResults libraryResultContainer, String methodFullName) {
        this.libraryResultContainer = libraryResultContainer;
        this.methodFullName = methodFullName;
        this.encodedValuePairs = new LinkedHashMap<>();
    }

    public MethodEncodeResult(String methodFullName) {
        this.methodFullName = methodFullName;
    }

    /**
     * Assign the current method object to a container Library object. This method is used when
     * the current method is created directly and not from the factory method from LibraryEncodedResults
     *
     * @param containerLibrary
     * @return
     */
    public MethodEncodeResult assignToLibraryContainer(LibraryEncodedResults containerLibrary) {
        this.libraryResultContainer = containerLibrary;
        return this;
    }

    /**
     * Return the name of the library that contains the current method.
     * If the method is not assigned to any library it returns a standard message
     *
     * @return
     */
    public String getLibraryName() {
        if (this.libraryResultContainer == null) {
            return "Not Assigned to Any Library set";
        }

        return libraryResultContainer.getLibraryName();
    }


    public LinkedHashMap<Character, String> getEncodedValuePairs() {
        return encodedValuePairs;
    }

    public String getMethodFullName() {
        return methodFullName;
    }

    public String getValue(char value) {
        // This value is used to identify when the character is deleted from the string and make it explicit in the rendered output
        String outValue = "EMPTY";
        String currentValue = this.encodedValuePairs.get(value);


        if(currentValue.length() > 0){

            outValue = "";

            for (int i = 0; i < currentValue.length(); i++) {
                final char actualChar = currentValue.charAt(i);
                final boolean isWhitespace = Character.isWhitespace((int)actualChar);
                final boolean isControl = Character.isISOControl((int)actualChar);

                if(isWhitespace || isControl){
                    outValue += String.format("[%d]", (int)actualChar);
                } else {
                    outValue += Character.toString(actualChar);
                }
            }
            if (currentValue.length() == 1 && currentValue.charAt(0) == value){
                outValue += "   ~unchgd";
            }
        }

        return outValue;
    }

    /**
     * This methods extracts the last two parts of the method namespace, if the namespace is made of two or more parts.
     * It will return the full module name if it cannot be split in segments
     * @return
     */
    public String getMethodName() {
        String segments[] = methodFullName.split("\\.");
        String subName = methodFullName;

        if (segments.length >= 1) {
            subName = segments[segments.length - 1];
        }

        return subName;
    }
}
