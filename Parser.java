class Parser {

    Lexer lexer;
    Token token;
    
    public Parser(String s){
        lexer = new Lexer(s + "$");
        token = lexer.nextToken();
    }

    public void run () {
        statement();
    }

    public void statement () {
        System.out.println("<Statement>");
        assignmentStmt();
        while (token.getTokenType() == Token.TokenType.SEMICOLON) {
            System.out.println("\t<Semicolon>;</Semicolon>");
            token = lexer.nextToken();
            assignmentStmt();
        }
        match(Token.TokenType.EOI);
        System.out.println("</Statement>");
    }

    public void assignmentStmt () {
        System.out.println("\t<Assignment>");
        String val = match(Token.TokenType.ID);
        System.out.println("\t\t<Identifier>" + val + "</Identifier>");
        match(Token.TokenType.ASSIGNMENTOP);
        System.out.println("\t\t<AssignmentOp>:=</AssignmentOp>");
        expression();
        System.out.println("\t</Assignment>");
    }

    public void expression () {
        if (token.getTokenType() == Token.TokenType.ID) {
            System.out.println("\t\t<Identifier>" + token.getTokenValue()
                               + "</Identifier>");
        } else if (token.getTokenType() == Token.TokenType.INT) {
            System.out.println("\t\t<Int>" + token.getTokenValue()
                               + "</Int>");
        } else if (token.getTokenType() == Token.TokenType.FLOAT) {
            System.out.println("\t\t<Float>" + token.getTokenValue()
                               + "</Float>");
        } else {
            System.err.println("Syntax error: expecting an ID, an int, or a float"
                               + "; saw:"
                               + Token.typeToString(token.getTokenType()));
            System.exit(1);
        }
        token = lexer.nextToken();
    }

    private String match (Token.TokenType tp) {
        String value = token.getTokenValue();
        if (token.getTokenType() == tp)
            token = lexer.nextToken();
        else error(tp);
        return value;
    }

    private void error (Token.TokenType tp) {
        System.err.println("Syntax error: expecting: " + Token.typeToString(tp)
                           + "; saw: "
                           + Token.typeToString(token.getTokenType()));
        System.exit(1);
    }

}