# Recursive-Descent-Parser
This is a Recursive Descent Parser for a restricted form of SQL

The lexical syntax is specified by regular expressions:

  | Category        | Definition  |
  | ------------- | ------------- |
  | digit      | [0-9] |
  | letter      | [a-zA-Z]      |
  | int | <digit>+      |
  | float | <digit>+.<digit>+      |
  | id | <letter>(<letter> j <digit>)*      |
  | keyword | SELECT \| FROM \| WHERE \| AND |
  | operator | = \| < \| > |
  | comma | , |
  
  
  The concrete syntax is specified by the following `E-BNF` grammar, where `<Query>` is the start symbol:
  ```
  <Query> -> SELECT <IDList> FROM <IDList> [WHERE <CondList>]

  <IDList> -> <id> {, <id>}

  <CondList> -> <Cond> {AND <Cond>}

  <Cond> -> <id> <operator> <Term>

  <Term> -> <id> | <int> | <float>
  
  ```

   Here **\<id>**, **\<float>**, and **\<operator>** are token categories defined by the regular expressions above,
   and the terminal symbols **SELECT**, **FROM**, **WHERE**, and **AND** are of category keyword, while "**,**"
   is a terminal symbol with category **\<comma>**.
   Note arbitrary whitespace can appear between tokens, and no space is needed between an operator and its operands,
   or between the items in a list and the commas that separate them.
   
1. Write a class Token that can store the value and category of any token.

2.  Develop a lexical analyzer. You should start by drawing on paper a finite state automaton that can recognize types of tokens and
then convert the automaton into code. Name this class Lexer and ensure that it has a public method nextToken() which returns a Token.
Lexer should have a constructor with the signature Lexer(String input), where the input is the string representing the query to be parsed. As mentioned before, the code for recognizing an identifier should check to see if the terminal string is a keyword, and if so, then the category of the token should be set to the keyword, instead of ID. If nextToken() is called when no input is left, then it should return a token with category EOI (EndOfInput). If the next terminal string is not considered a token by the lexical syntax, then return a token with category Invalid.

3. Write a syntactic analyzer which parses the tokens given by Lexer using the recursive descent technique. Name this class Parser.
Like Lexer, Parser should have a public constructor with the signature Parser(String input). This input string should be used to create
a Lexer object. There should also be a public method run() that will start the parse. As you parse the input, Parser should output
(by writing to System.out) the non-terminal that was matched, surrounded by angle brackets, e.g. **\<Query>**. Whenever it applies a new rule, it should indent by a tab. When it has parsed all tokens that constitute a nonterminal, it should print out the non-terminal's name, preceded by a slash, and surrounded by angle-brackets, e.g. **</Query>**. When a terminal symbol (token) is matched, it should output the token category, surrounded by angle-brackets, the tokens string, and the token category preceded by a slash and surrounded by angle-brackets (e.g. **\<Int>42\</Int>**). Whenever the parser comes across a token that does not fit the grammar, it should output a message of the form *"Syntax error: expecting expected-token-category; saw token"* and immediately exit. Note, the input string is expected to contain exactly one sentence of the form **Query**.
  
    
