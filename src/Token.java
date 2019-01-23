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
 * This is the token class that stores the value and the categories of the token
 */
public class Token {

    public enum TokenType {Int, Float, Id, Digit, Letter, Keyword, Operator,Comma,
    Query,IdList,CondList,Cond,Term,Invalid,EOI}

    private TokenType type;
    private String val;
    
    //  Token constructor
    Token (TokenType t, String v) {
        type = t; 
        val = v;
    }

    // return the type of token and value
    TokenType getTokenType() {return type;}
    String getTokenValue() {return val;}

    
    public static String typeToString (TokenType tp) {
        String v = "";
        switch (tp) {
        case Int: v = "Int"; break;
        case Float: v = "Float"; break;
        case Id: v = "Id"; break;
        case Digit: v = "Digit"; break;
        case Letter: v = "Letter"; break;
        case Keyword: v = "Keyword";
        case Operator: v="Operator"; break;
        case Comma: v = "Comma"; break;
        case Query: v = "Query"; break;
        case IdList: v = "IdList"; break;
        case CondList: v = "CondList"; break;
        case Cond: v = "Cond"; break;
        case Term: v = "Term"; break;
        case Invalid: v = "Invalid"; break;
        case EOI: v = "EOI"; break;
        
        }
        return v;
    }
    
}
