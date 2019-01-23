public class Test {
    public static void main (String args[]) {

        // testing the lexer
        Lexer lex = new Lexer ("x := 1 $");
        Token tk = lex.nextToken();
        while (tk.getTokenType() != Token.TokenType.EOI) {
            tk.print();
            System.out.print(" ");
            tk = lex.nextToken();
        }
        System.out.println("");

        lex = new Lexer ("x := 1; y := 2.3; z := x $");
        tk = lex.nextToken();
        while (tk.getTokenType() != Token.TokenType.EOI) {
            tk.print();
            System.out.print(" ");
            tk = lex.nextToken();
        }
        System.out.println("");

        lex = new Lexer ("x := 1; y : 2; z := x $");
        tk = lex.nextToken();
        while (tk.getTokenType() != Token.TokenType.EOI) {
            tk.print();
            System.out.print(" ");
            tk = lex.nextToken();
        }
        System.out.println("");
        
        // testing the parser
        Parser parser = new Parser ("x := 1");
        parser.run();
        parser = new Parser ("x := 1; y := 2.3; z := x");
        parser.run();
        parser = new Parser ("x := 1; y ; 2; z := x");
        parser.run();
    }
}