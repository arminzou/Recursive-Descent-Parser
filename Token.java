public class Token{
    public enum TokenType {INT, FLOAT, ID, SEMICOLON, ASSIGNMENTOP, EOI, INVALID}

    private TokenType type;
    private String val;

    Token (TokenType t, String v) {
        type = t; val = v;
    }

    TokenType getTokenType() {return type;}
    String getTokenValue() {return val;}

    void print () {
        String s = "";
        switch (type) {
        case INT: case FLOAT: case ID: s = val; break;
        case SEMICOLON: s = ";"; break;
        case ASSIGNMENTOP: s = ":="; break;
        case EOI: s = "";
        case INVALID: s = "invalid"; break;
        }
        System.out.print(s);
    }

    public static String typeToString (TokenType tp) {
        String s = "";
        switch (tp) {
        case INT: s = "Int"; break;
        case FLOAT: s = "Float"; break;
        case ID: s = "ID"; break;
        case SEMICOLON: s = "Semicolon"; break;
        case ASSIGNMENTOP: s = "AssignmentOP"; break;
        case INVALID: s="Invalid"; break;
        }
        return s;
    }
    
}
