/*
 * The MIT License
 *
 * Copyright 2016 Fundacion Jala.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.fundacionjala.enforce.sonarqube.apex.api;

import com.sonar.sslr.api.Grammar;
import org.sonar.sslr.grammar.LexerfulGrammarBuilder;

import static com.sonar.sslr.api.GenericTokenType.EOF;
import static com.sonar.sslr.api.GenericTokenType.IDENTIFIER;

import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.ABSTRACT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.AFTER;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.ANOTATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.AURA_ENABLED;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.BEFORE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.BOOLEAN;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.BYTE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.CATCH;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.CATEGORY;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.CHAR;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.CLASS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.DATA;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.CONVERTCURRENCY;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.DELETE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.DEPRECATED;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.DOUBLE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.ELSE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.EXTENDS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.FINAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.FIRST;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.FLOAT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.FOR;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.FUTURE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.GET;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.GROUP;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.IF;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.IMPLEMENTS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.INSERT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.INT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.INTERFACE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.INVOCABLE_METHOD;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.INVOCABLE_VARIABLE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.IS_TEST;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.ITERATOR;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_90_DAYS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_FISCAL_QUARTER;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_FISCAL_YEAR;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_MONTH;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_N_DAYS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_N_FISCAL_QUARTERS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_N_FISCAL_YEARS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_N_MONTHS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_N_QUARTERS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_N_WEEKS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_N_YEARS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_QUARTER;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_WEEK;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST_YEAR;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LIMIT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LONG;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.MERGE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NATIVE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NETWORK;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEW;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_90_DAYS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_FISCAL_QUARTER;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_FISCAL_YEAR;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_MONTH;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_N_DAYS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_N_FISCAL_QUARTERS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_N_FISCAL_YEARS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_N_MONTHS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_N_QUARTERS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_N_WEEKS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_N_YEARS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_QUARTER;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_WEEK;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NEXT_YEAR;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NULL;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.OFFSET;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.PRIVATE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.PROTECTED;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.PUBLIC;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.READ_ONLY;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.REMOTE_ACTION;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.RETURN;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.RETURNING;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.SAVEPOINT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.SEARCH;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.SHARING;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.SHORT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.STAT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.STATIC;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.STRICTFP;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.SUPER;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.SYNCHRONIZED;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.TEST_SETUP;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.TEST_VISIBLE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.THIS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.THIS_FISCAL_QUARTER;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.THIS_FISCAL_YEAR;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.THIS_MONTH;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.THIS_QUARTER;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.THIS_WEEK;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.THIS_YEAR;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.TODAY;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.TOLABEL;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.TOMORROW;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.TRANSIENT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.TRY;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.UNDELETE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.UPDATE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.UPSERT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.VOID;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.VOLATILE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.WHILE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.WITH;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.WITHOUT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.YESTERDAY;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.ASSIGN;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.AT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.COLON;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.COMMA;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.DIV;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.DOT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.GT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.LBRACE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.LBRACKET;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.LPAREN;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.LT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.MINUS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.MOD;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.PLUS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.RBRACE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.RBRACKET;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.RPAREN;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.SEMICOLON;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.STAR;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexTokenType.NUMERIC;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexTokenType.STRING;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ACCESSOR_DECLARATIONS;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ALLOWED_KEYWORDS_AS_IDENTIFIER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ANNOTATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.APEX_GRAMMAR;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ASSIGN_VARIABLE_INITILIZER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.BRACKETS;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.CASTING_EXPRESSION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.CLASS_NAME;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.EXTENDS_LIST;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.IMPLEMENTS_LIST;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.KEYWORD;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.METHOD_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.METHOD_NAME;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.TYPE;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.TYPE_CLASS;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.TYPE_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.VARIABLE_DECLARATOR_ID;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.MODIFIER_KEYWORD;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.MODIFIER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.CLASS_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.CONSTRUCTOR_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.CREATING_EXPRESSION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.EXPRESSION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.FIELD_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.LITERAL_EXPRESSION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.TYPE_SPECIFIER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.VARIABLE_DECLARATOR;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.NUMERIC_EXPRESSION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.NUMERIC_EXPRESSION_OPERATIONS;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.NUMERIC_EXPRESSION_OPERATIONS_SIMPLE;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.INC;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.DEC;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.DML_STATEMENT;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.EQUAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.EXPRESSION_FINAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.FOR_STATEMENT;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.PARAMETER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.PARAMETER_LIST;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.RETURN_STATEMENT;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.STATEMENT;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.STATEMENT_BLOCK;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.STATEMENT_ELSE;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.STATEMENT_IF;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.TERMINAL_EXPRESSION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.TERMINAL_STATEMENT;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.TESTING_EXPRESSION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.TRY_STATEMENT;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.VARIABLE_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.WHILE_STATEMENT;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.INVOKE_EXPRESSION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ARGUMENTS;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.PROPERTY_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.SOQL_NDATE_LITERAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.SOQL_DATE_LITERAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.SPECIAL_KEYWORDS_AS_IDENTIFIER;

/**
 * This class unites all the rules you need a class.
 */
public class ApexGrammar {

    /**
     * Default constructor.
     */
    private ApexGrammar() {
    }

    /**
     * It is the main method of grammar. Here all other grammars are
     * constructed.
     *
     * @return the grammar
     */
    public static Grammar create() {
        LexerfulGrammarBuilder grammarBuilder = LexerfulGrammarBuilder.create();
        expression(grammarBuilder);
        expressionFinal(grammarBuilder);
        statement(grammarBuilder);
        whileStatement(grammarBuilder);
        tryStatement(grammarBuilder);
        forStatement(grammarBuilder);
        returnStatement(grammarBuilder);
        dmlStatement(grammarBuilder);
        statementBlock(grammarBuilder);
        statementIf(grammarBuilder);
        statamentElse(grammarBuilder);
        variableDeclaration(grammarBuilder);
        testingExpressionEqual(grammarBuilder);
        testingExpression(grammarBuilder);
        creatingExpression(grammarBuilder);
        castingExpression(grammarBuilder);
        brackets(grammarBuilder);
        literalExpression(grammarBuilder);
        numericExpressionOperationsSimpleInc(grammarBuilder);
        numericExpressionOperationsSimpleDec(grammarBuilder);
        numericExpressionOperations(grammarBuilder);
        numericExpressionOperationsSimple(grammarBuilder);
        numericExpression(grammarBuilder);
        invokeExpression(grammarBuilder);
        terminalExpression(grammarBuilder);
        assignVariableInitializer(grammarBuilder);
        variableDeclaratorId(grammarBuilder);
        variableDeclarator(grammarBuilder);
        typeSpecifier(grammarBuilder);
        type(grammarBuilder);
        annotation(grammarBuilder);
        arguments(grammarBuilder);
        parameter(grammarBuilder);
        parameterList(grammarBuilder);
        methodName(grammarBuilder);
        methodDeclaration(grammarBuilder);
        constructorDeclaration(grammarBuilder);
        typeClass(grammarBuilder);
        extendsList(grammarBuilder);
        implementsList(grammarBuilder);
        className(grammarBuilder);
        classDeclaration(grammarBuilder);
        keyword(grammarBuilder);
        modifier(grammarBuilder);
        fieldDeclaration(grammarBuilder);
        modifierKeyWord(grammarBuilder);
        typeDeclaration(grammarBuilder);
        propertyDeclaration(grammarBuilder);
        allowedKeywordsAsIdentifier(grammarBuilder);
        specialKeywordsAsIdentifier(grammarBuilder);
        soqlDateLiteral(grammarBuilder);
        soqlNDateLiteral(grammarBuilder);
            
        grammarBuilder.rule(APEX_GRAMMAR).is(TYPE_DECLARATION, EOF);
        grammarBuilder.setRootRule(APEX_GRAMMAR);
        return grammarBuilder.build();
    }

    /**
     * Grammar is created for the head of a class with the switch and whether it
     * will extend or implement otherwise.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void typeDeclaration(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(TYPE_DECLARATION).is(
                grammarBuilder.oneOrMore(CLASS_DECLARATION)
        );
    }

    /**
     * Grammar is created for a class modifier (lookahead or keyword).
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void modifierKeyWord(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(MODIFIER_KEYWORD).is(
                grammarBuilder.optional(MODIFIER),
                grammarBuilder.optional(KEYWORD)
        );
    }

    /**
     * Grammar for different access modifiers of a class is created.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void modifier(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(MODIFIER).is(grammarBuilder.firstOf(
                PUBLIC,
                STATIC,
                PROTECTED,
                PRIVATE,
                FINAL,
                ABSTRACT,
                SYNCHRONIZED,
                NATIVE,
                TRANSIENT,
                VOLATILE,
                STRICTFP,
                ANOTATION)
        );
    }

    /**
     * Grammar to identify a sharing rule keyword.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void keyword(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(KEYWORD).is(
                grammarBuilder.firstOf(
                        WITHOUT,
                        WITH),
                SHARING
        );
    }

    /**
     * Grammar to identify a sharing rule keyword.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void annotation(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(ANNOTATION).is(
                AT,
                grammarBuilder.firstOf(
                        AURA_ENABLED,
                        DEPRECATED,
                        FUTURE,
                        INVOCABLE_METHOD,
                        INVOCABLE_VARIABLE,
                        IS_TEST,
                        READ_ONLY,
                        REMOTE_ACTION,
                        TEST_SETUP,
                        TEST_VISIBLE
                )
        );
    }

    /**
     * It is responsible for managing the class name.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void className(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(CLASS_NAME).is(IDENTIFIER);
    }

    /**
     * Grammar for the declaration of a class or interface is constructed.
     * Composed of the rules of a class type, its identified, extends, and
     * implements.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void classDeclaration(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(CLASS_DECLARATION).is(
                grammarBuilder.zeroOrMore(ANNOTATION),
                MODIFIER_KEYWORD,
                TYPE_CLASS,
                CLASS_NAME,
                grammarBuilder.optional(IMPLEMENTS_LIST),
                grammarBuilder.optional(EXTENDS_LIST),
                LBRACE,
                grammarBuilder.zeroOrMore(FIELD_DECLARATION),
                RBRACE
        );
    }

    /**
     * Grammar is created to implement another class or not.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void implementsList(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(IMPLEMENTS_LIST).is(
                IMPLEMENTS,
                CLASS_NAME
        );
    }

    /**
     * Grammar is created to extend another class or just skip.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void extendsList(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(EXTENDS_LIST).is(
                EXTENDS,
                CLASS_NAME
        );
    }

    /**
     * Grammar is created to identify if a class or interface.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void typeClass(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(TYPE_CLASS).is(
                grammarBuilder.firstOf(
                        CLASS,
                        INTERFACE)
        );
    }

    /**
     * The grammar of the empty body of a class is built.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void fieldDeclaration(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(FIELD_DECLARATION).is(
                grammarBuilder.firstOf(
                        METHOD_DECLARATION,
                        CONSTRUCTOR_DECLARATION,
                        VARIABLE_DECLARATION)
        );
    }

    /**
     * It is responsible for setting the rules for arguments.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void arguments(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(ARGUMENTS).is(
                TERMINAL_EXPRESSION,
                grammarBuilder.zeroOrMore(
                        COMMA,
                        TERMINAL_EXPRESSION
                )
        );
    }

    /**
     * It is responsible for setting the rules for parameters.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void parameter(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(PARAMETER).is(
                TYPE,
                IDENTIFIER,
                grammarBuilder.optional(BRACKETS)
        );
    }

    /**
     * It is responsible for setting the rules for the parameter list.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void parameterList(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(PARAMETER_LIST).is(
                PARAMETER,
                grammarBuilder.zeroOrMore(COMMA, PARAMETER)
        );
    }

    /**
     * It is responsible for managing the method name.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void methodName(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(METHOD_NAME).is(IDENTIFIER);
    }

    /**
     * Creates rules to the last line of the method and the completion of the
     * method.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void methodDeclaration(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(METHOD_DECLARATION).is(
                grammarBuilder.zeroOrMore(ANNOTATION),
                MODIFIER,
                TYPE,
                METHOD_NAME,
                LPAREN,
                grammarBuilder.optional(PARAMETER_LIST),
                RPAREN,
                STATEMENT_BLOCK
        );
    }

    /**
     * Creates rules for method's last line and completion.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void constructorDeclaration(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(CONSTRUCTOR_DECLARATION).is(
                grammarBuilder.zeroOrMore(ANNOTATION),
                MODIFIER,
                CLASS_NAME,
                LPAREN,
                grammarBuilder.optional(PARAMETER_LIST),
                RPAREN,
                STATEMENT_BLOCK
        );
    }

    /**
     * Creates rules for the primitive values of a class.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void typeSpecifier(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(TYPE_SPECIFIER).is(
                grammarBuilder.firstOf(
                        BOOLEAN,
                        CHAR,
                        BYTE,
                        SHORT,
                        INT,
                        LONG,
                        FLOAT,
                        VOID,
                        DOUBLE,
                        CLASS_NAME
                )
        );
    }

    /**
     * It is responsible for creating the rule for merge with symbol '=' and an
     * expression.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void assignVariableInitializer(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(ASSIGN_VARIABLE_INITILIZER).is(
                ASSIGN,
                EXPRESSION
        );
    }

    /**
     * It is responsible for managing the rule of integers, strings, characters.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void literalExpression(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(LITERAL_EXPRESSION).is(
                grammarBuilder.firstOf(
                        STRING,
                        NUMERIC)
        );
    }

    /**
     * It is responsible for creating the rules to make the casting of an
     * expression.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void castingExpression(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(CASTING_EXPRESSION).is(
                LPAREN,
                TYPE,
                RPAREN,
                TERMINAL_EXPRESSION
        );
    }

    /**
     * It is responsible for setting the rules for equal comparison.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    public static void testingExpressionEqual(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(EQUAL).is(ASSIGN, ASSIGN);
    }

    /**
     * It is responsible for creating the rules to make the testing of an
     * expression.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void testingExpression(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(TESTING_EXPRESSION).is(
                TERMINAL_EXPRESSION,
                grammarBuilder.firstOf(EQUAL, GT, LT),
                TERMINAL_EXPRESSION
        );
    }

    /**
     * It is responsible for creating the rules to make the creating of an
     * expression.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void creatingExpression(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(CREATING_EXPRESSION).is(
                NEW,
                CLASS_NAME,
                LPAREN,
                grammarBuilder.optional(
                        IDENTIFIER,
                        grammarBuilder.zeroOrMore(
                                COMMA,
                                IDENTIFIER)),
                RPAREN
        );
    }

    /**
     * It is responsible for setting the rules for simple mathematical
     * operations.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void numericExpressionOperations(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(NUMERIC_EXPRESSION_OPERATIONS).is(
                TERMINAL_EXPRESSION,
                grammarBuilder.firstOf(
                        PLUS,
                        MINUS,
                        STAR,
                        DIV,
                        MOD
                ),
                TERMINAL_EXPRESSION
        );
    }

    /**
     * It is responsible for creating the rules to make one increment.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void numericExpressionOperationsSimpleInc(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(INC).is(PLUS, PLUS);
    }

    /**
     * It is responsible for creating the rules to make one decrement.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void numericExpressionOperationsSimpleDec(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(DEC).is(MINUS, MINUS);
    }

    /**
     * It is responsible for creating the rules to make one increment or
     * decrement.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void numericExpressionOperationsSimple(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(NUMERIC_EXPRESSION_OPERATIONS_SIMPLE).is(
                TERMINAL_EXPRESSION,
                grammarBuilder.firstOf(INC, DEC)
        );
    }

    /**
     * It is responsible for creating the rules for numeric operations.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void numericExpression(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(NUMERIC_EXPRESSION).is(
                grammarBuilder.firstOf(
                        NUMERIC_EXPRESSION_OPERATIONS,
                        NUMERIC_EXPRESSION_OPERATIONS_SIMPLE
                )
        );
    }

    /**
     * It is responsible for setting the rules for invoke expression.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void invokeExpression(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(INVOKE_EXPRESSION).is(
                IDENTIFIER,
                grammarBuilder.optional(
                        LPAREN,
                        grammarBuilder.optional(ARGUMENTS),
                        RPAREN),
                grammarBuilder.zeroOrMore(
                        DOT,
                        INVOKE_EXPRESSION)
        );
    }

    /**
     * It is responsible for setting the rules for terminal expression.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void terminalExpression(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(TERMINAL_EXPRESSION).is(
                grammarBuilder.firstOf(
                        INVOKE_EXPRESSION,
                        LITERAL_EXPRESSION,
                        NULL,
                        SUPER,
                        THIS
                )
        );
    }

    /**
     * It is responsible for creating a rule expression language.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void expression(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(EXPRESSION).is(
                grammarBuilder.firstOf(
                        NUMERIC_EXPRESSION,
                        TESTING_EXPRESSION,
                        CREATING_EXPRESSION,
                        CASTING_EXPRESSION,
                        TERMINAL_EXPRESSION
                )
        );
    }

    /**
     * It is responsible for setting the rules for final expression.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void expressionFinal(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(EXPRESSION_FINAL).is(EXPRESSION, SEMICOLON);
    }

    /**
     * It is responsible for setting the rules for the else.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void statamentElse(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(STATEMENT_ELSE).is(
                ELSE,
                grammarBuilder.firstOf(
                        TERMINAL_STATEMENT,
                        STATEMENT_BLOCK)
        );
    }

    /**
     * It is responsible for setting the rules for the if else.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void statementIf(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(STATEMENT_IF).is(
                IF,
                LPAREN,
                EXPRESSION,
                RPAREN,
                grammarBuilder.firstOf(
                        TERMINAL_STATEMENT,
                        STATEMENT_BLOCK),
                grammarBuilder.optional(STATEMENT_ELSE)
        );
    }

    /**
     * It is responsible for setting the rules for a block of statements.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void statementBlock(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(STATEMENT_BLOCK).is(
                LBRACE,
                grammarBuilder.zeroOrMore(STATEMENT),
                RBRACE);
    }

    /**
     * It is responsible for creating the rules for a while.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void whileStatement(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(WHILE_STATEMENT).is(
                WHILE,
                LPAREN,
                EXPRESSION,
                RPAREN,
                grammarBuilder.firstOf(
                        TERMINAL_STATEMENT,
                        STATEMENT_BLOCK)
        );
    }

    /**
     * It is responsible for creating the rules for a while.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void forStatement(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(FOR_STATEMENT).is(
                FOR,
                LPAREN,
                TYPE,
                VARIABLE_DECLARATOR_ID,
                COLON,
                VARIABLE_DECLARATOR_ID,
                RPAREN,
                grammarBuilder.firstOf(
                        TERMINAL_STATEMENT,
                        STATEMENT_BLOCK)
        );
    }

    /**
     * It is responsible for creating the rules for a try catch.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void tryStatement(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(TRY_STATEMENT).is(
                TRY,
                grammarBuilder.firstOf(
                        TERMINAL_STATEMENT,
                        STATEMENT_BLOCK),
                CATCH,
                LPAREN,
                PARAMETER,
                RPAREN,
                grammarBuilder.firstOf(
                        TERMINAL_STATEMENT,
                        STATEMENT_BLOCK)
        );
    }

    /**
     * It is responsible for creating the rules for a DML statement.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void dmlStatement(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(DML_STATEMENT).is(
                grammarBuilder.firstOf(
                        INSERT,
                        UPDATE,
                        UPSERT,
                        DELETE,
                        UNDELETE,
                        MERGE),
                EXPRESSION_FINAL
        );
    }

    /**
     * It is responsible for creating the rules for a return statement.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void returnStatement(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(RETURN_STATEMENT).is(
                RETURN,
                EXPRESSION_FINAL
        );
    }

    /**
     * It is responsible for setting the rules for the all statements.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void statement(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(STATEMENT).is(
                grammarBuilder.firstOf(
                        TERMINAL_STATEMENT,
                        STATEMENT_IF,
                        WHILE_STATEMENT,
                        FOR_STATEMENT,
                        TRY_STATEMENT,
                        RETURN_STATEMENT)
        );
        grammarBuilder.rule(TERMINAL_STATEMENT).is(
                grammarBuilder.firstOf(
                        EXPRESSION_FINAL,
                        VARIABLE_DECLARATION,
                        DML_STATEMENT)
        );
    }

    /**
     * It is responsible for setting the rules for the declaration of a
     * variable.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void variableDeclaration(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(VARIABLE_DECLARATION).is(
                grammarBuilder.optional(MODIFIER),
                TYPE,
                VARIABLE_DECLARATOR,
                SEMICOLON
        );
    }

    /**
     * It is responsible for creating the rule for declaring a variable.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void variableDeclarator(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(VARIABLE_DECLARATOR).is(
                VARIABLE_DECLARATOR_ID,
                grammarBuilder.optional(ASSIGN_VARIABLE_INITILIZER)
        );
    }

    /* It is responsible for creating the rule for identifying a variable.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void variableDeclaratorId(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(VARIABLE_DECLARATOR_ID).is(
                IDENTIFIER,
                grammarBuilder.optional(BRACKETS)
        );
    }

    /**
     * It is responsible for creating the rule for the brackets.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void brackets(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(BRACKETS).is(LBRACKET, RBRACKET);
    }

    /**
     * It is responsible for building the rules for the different types of
     * return of a method.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void type(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(TYPE).is(TYPE_SPECIFIER);
    }

    /**
     * Creates the rule for Property Declaration within a class.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void propertyDeclaration(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(PROPERTY_DECLARATION).is(
                grammarBuilder.rule(TYPE), grammarBuilder.firstOf(grammarBuilder
                .rule(ALLOWED_KEYWORDS_AS_IDENTIFIER),
                grammarBuilder.rule(SPECIAL_KEYWORDS_AS_IDENTIFIER)), LBRACE,
                grammarBuilder.rule(ACCESSOR_DECLARATIONS), RBRACE);
    }
    
	/**
     * Creates the rule for using a specialKeyword as identifier.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void specialKeywordsAsIdentifier(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(PROPERTY_DECLARATION).is(
                grammarBuilder.firstOf(WITHOUT, OFFSET, DATA, GROUP, LIMIT));
    }

    /**
     * Creates the rule for allow keywords as identifier within a class.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void allowedKeywordsAsIdentifier(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(ALLOWED_KEYWORDS_AS_IDENTIFIER).is(
                grammarBuilder.firstOf(
                        IDENTIFIER, 
                        TRANSIENT,
                        RETURNING,
                        SEARCH,
                        STAT,
                        CONVERTCURRENCY,
                        SAVEPOINT,
                        TOLABEL,
                        SHARING,
                        GET,
                        AFTER,
                        BEFORE,
                        FIRST,
                        LAST,
                        CATEGORY,
                        NETWORK,
                        ITERATOR,
                grammarBuilder.rule(SOQL_DATE_LITERAL),
                grammarBuilder.rule(SOQL_NDATE_LITERAL)));
    }
    
    /**
     * Creates the rule for SOQL date literal within a class.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void soqlDateLiteral(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(SOQL_DATE_LITERAL).is(
                grammarBuilder.firstOf(
                        TODAY, 
                        YESTERDAY,
                        TOMORROW,
                        LAST_WEEK,
                        THIS_WEEK,
                        NEXT_WEEK,
                        LAST_MONTH,
                        THIS_MONTH,
                        NEXT_MONTH,
                        LAST_90_DAYS,
                        NEXT_90_DAYS,
                        THIS_QUARTER,
                        LAST_QUARTER,
                        NEXT_QUARTER,
                        THIS_YEAR,
                        LAST_YEAR,
                        NEXT_YEAR,
                        THIS_FISCAL_QUARTER,
                        LAST_FISCAL_QUARTER,
                        NEXT_FISCAL_QUARTER,
                        THIS_FISCAL_YEAR,
                        LAST_FISCAL_YEAR,
                        NEXT_FISCAL_YEAR));
    }
    
    /**
     * Creates the rule for SOQL date literal within a class.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void soqlNDateLiteral(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(SOQL_NDATE_LITERAL).is(
                grammarBuilder.firstOf(
                        LAST_N_DAYS,
                        NEXT_N_DAYS,
                        LAST_N_WEEKS,
                        NEXT_N_WEEKS,
                        LAST_N_MONTHS,
                        NEXT_N_MONTHS,
                        LAST_N_QUARTERS,
                        NEXT_N_QUARTERS,
                        LAST_N_YEARS,
                        NEXT_N_YEARS,
                        LAST_N_FISCAL_QUARTERS,
                        NEXT_N_FISCAL_QUARTERS,
                        LAST_N_FISCAL_YEARS,
                        NEXT_N_FISCAL_YEARS));
    }
}
