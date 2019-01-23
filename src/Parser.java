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
 * This is the parser class that parses the tokens given by Lexier using the recursive descent technique
 */
public class Parser {

    Token token;
    Lexer lexer;

    // Parser constructor
    public Parser(String input) {
        lexer = new Lexer(input + '$');
        token = lexer.nextToken();
    }

    // Method to start the parse
    public void run() {
        query();
    }


    // Method reads in next token
    private void next() {
        token = lexer.nextToken();
    }

    // Method parses the query
    public void query() {
        System.out.println("<Query>");
        if (token.getTokenType() == Token.TokenType.Keyword && (token.getTokenValue().equals("SELECT"))) {
            System.out.println("   <Keyword>" + token.getTokenValue() + "</Keyword>");
            next();
            idList();
        } else {
            error(Token.TokenType.Keyword);
        }
        if (token.getTokenType() == Token.TokenType.Keyword && (token.getTokenValue().equals("FROM"))) {
            System.out.println("   <Keyword>" + token.getTokenValue() + "</Keyword>");
            next();
            idList();
        } else {
            error(Token.TokenType.Keyword);
        }
        if (token.getTokenType() == Token.TokenType.Keyword && (token.getTokenValue().equals("WHERE"))) {
            System.out.println("   <Keyword>" + token.getTokenValue() + "</Keyword>");
            next();
            condList();
        }
        if (token.getTokenType() == Token.TokenType.EOI) {
            System.out.println("</Query>");
        }
        if (token.getTokenType() == Token.TokenType.Invalid) {
            error(token.getTokenType());
            next();
        }
    }


    // Method parses grammar for idList
    public void idList() {
        System.out.println("   <IdList>");
        if (token.getTokenType() == Token.TokenType.Id) {
            System.out.println("      <Id>" + token.getTokenValue() + "</Id>");
            next();
        }
        while (token.getTokenType() == Token.TokenType.Comma) {
            System.out.println("      <Comma>" + "," + "</Comma>");
            next();
            if (token.getTokenType() == Token.TokenType.Id) {
                System.out.println("      <Id>" + token.getTokenValue() + "</Id>");
                next();
            } else {
                error(Token.TokenType.Id);
            }
        }
        System.out.println("   </IdList>");

    }

    // Method parses grammar for condList
    public void condList() {
        System.out.println("   <CondList>");
        if (token.getTokenType() == Token.TokenType.Id) {
            cond();
        } else {
            error(token.getTokenType());
        }
        while (token.getTokenType() == Token.TokenType.Keyword && token.getTokenValue().equals("AND")) {
            System.out.println("   <Keyword>" + token.getTokenValue() + "</Keyword>");
            next();
            if (token.getTokenType() == Token.TokenType.Id) {
                cond();
            } else {
                error(Token.TokenType.CondList);
            }
        }
        System.out.println("   </CondList>");
    }

    // Method parses grammar for cond
    public void cond() {
        System.out.println("      <Cond>");
        System.out.println("         <Id>" + token.getTokenValue() + "</Id>");
        next();
        if (token.getTokenType() == Token.TokenType.Operator) {
            System.out.println("         <Operator>" + token.getTokenValue() + "</Operator>");
            next();
            term();
        } else {
            error(Token.TokenType.Cond);
        }
        System.out.println("      </Cond>");
    }

    // Method parses grammar for term
    public void term() {
        System.out.println("         <Term>");
        if (token.getTokenType() == Token.TokenType.Id) {
            System.out.println("         <Id>" + token.getTokenValue() + "</Id>");
            next();
        } else if (token.getTokenType() == Token.TokenType.Int) {
            System.out.println("         <Int>" + token.getTokenValue() + "</Int>");
            next();
        } else if (token.getTokenType() == Token.TokenType.Float) {
            System.out.println("            <Float>" + token.getTokenValue() + "</Float>");
            next();
        } else {
            error(Token.TokenType.Term);
        }
        System.out.println("         </Term>");
    }


    // Output error message 
    private void error(Token.TokenType type) {
        System.err.println("Syntax error: Expecting: " + Token.typeToString(type) + "; saw: " + Token.typeToString(token.getTokenType()));
        System.exit(1);
    }
}