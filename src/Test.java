/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpsc.pkg461.project1;

/**
 *
 * Name: Chengmin Zou
 * PSU ID: cvz5138
 * Version: Java 8
 * Window 10 64-bit OS
 * This is the test class that testing the parser using query string 
 */
public class Test {

    // Test for output
    public static void main(String args[]) {
        // testing the parser
        Parser parser = new Parser("SELECT C1,C2 FROM T1 WHERE C1=5.23");
        parser.run();
        
    }
}
