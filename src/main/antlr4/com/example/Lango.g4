grammar Lango;

// Парсер правила
program: statement* EOF;

statement: assignmentStatement
         | printStatement
         | ifStatement
         | whileStatement
         ;

assignmentStatement: ID '=' expression ';';

printStatement: 'print' expression ';';

ifStatement: 'if' '(' expression ')' '{' statement* '}' ('else' '{' statement* '}')?;

whileStatement: 'while' '(' expression ')' '{' statement* '}';

expression: expression ('*' | '/') expression                    # MulDivExpr
          | expression ('+' | '-') expression                    # AddSubExpr
          | expression ('>' | '<' | '>=' | '<=' | '==' | '!=') expression  # CompExpr
          | '(' expression ')'                                   # ParenExpr
          | atom                                                 # AtomExpr
          ;

atom: INT                                                        # IntAtom
    | DOUBLE                                                     # DoubleAtom
    | STRING                                                     # StringAtom
    | ID                                                         # IdAtom
    ;

// Лексер правила
ID: [a-zA-Z_][a-zA-Z0-9_]*;
INT: [0-9]+;
DOUBLE: [0-9]+ '.' [0-9]+;
STRING: '"' (~["\\\r\n] | '\\' .)* '"';

// Пропускаем пробелы и комментарии
WS: [ \t\r\n]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip; 
