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
package org.fundacionjala.enforce.sonarqube.apex.api.grammar.buildersource;

import org.sonar.sslr.grammar.LexerfulGrammarBuilder;
import static com.sonar.sslr.api.GenericTokenType.IDENTIFIER;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.CLASS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.ENUM;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.EXCEPTION;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.EXTENDS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.FINAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.GET;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.IMPLEMENTS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.INTERFACE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.SET;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.SHARING;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.STATIC;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.SUPER;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.THIS;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.VOID;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.WITH;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.WITHOUT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.ASSIGN;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.COMMA;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.LBRACE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.LPAREN;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.RBRACE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.RPAREN;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.SEMICOLON;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ACCESSOR;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ACCESSOR_BODY;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ACCESSOR_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ACCESSOR_DECLARATIONS;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ALLOWED_KEYWORDS_AS_IDENTIFIER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ANNOTATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ARGUMENTSPI;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ASSIGN_VARIABLE_INITILIZER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.BLOCK;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.BLOCK_STATEMENT;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.BRACKETS;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.CLASS_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.CLASS_NAME;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.CLASS_OR_INTERFACE_BODY;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.CLASS_OR_INTERFACE_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.CLASS_OR_INTERFACE_MEMBER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.CONSTRUCTOR_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.EXPRESSION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.EXTENDS_LIST;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.FIELD_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.FORMAL_PARAMETER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.FORMAL_PARAMETERS;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.IMPLEMENTS_LIST;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.METHOD_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.METHOD_DECLARATION_PI;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.MODIFIER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.MODIFIER_KEYWORD;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.PARAMETER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.PARAMETER_LIST;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.PROPERTY_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.RESULT_TYPE;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.STATEMENT_BLOCK;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.TYPE;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.TYPE_CLASS;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.TYPE_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.VARIABLE_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.VARIABLE_DECLARATOR;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.VARIABLE_DECLARATOR_ID;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.CONSTRUCTOR_DECLARATION_PI;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.DECLARATIONS_WITH_MODIFIERS;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ENUM_BODY;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ENUM_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.EXPLICIT_CONSTRUCTOR_INVOCATION_PI;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.GET_SHARING_RULES;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.FIELD_DECLARATION_PI;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.INITIALIZER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.INITIALIZER_BLOCK;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.INITIALIZER_BLOCK_MEMBER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.LOCAL_VARIABLE_DECLARATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.SPECIAL_KEYWORDS_AS_IDENTIFIER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.VARIABLE_DECLARATOR_PI;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.METHOD_IDENTIFIER;

/**
 * This class contains constructors for Declaration rules and its sub rules.
 *
 */
public class Declaration {

    public static void create(LexerfulGrammarBuilder grammarBuilder) {
        assignVariableInitializer(grammarBuilder);
        variableDeclaration(grammarBuilder);
        variableDeclaratorId(grammarBuilder);
        variableDeclarator(grammarBuilder);
        typeClass(grammarBuilder);
        extendsList(grammarBuilder);
        implementsList(grammarBuilder);
        className(grammarBuilder);
        classDeclaration(grammarBuilder);
        fieldDeclaration(grammarBuilder);
        typeDeclaration(grammarBuilder);
        constructorDeclaration(grammarBuilder);
        parameter(grammarBuilder);
        parameterList(grammarBuilder);
        methodName(grammarBuilder);
        methodDeclaration(grammarBuilder);
        propertyDeclaration(grammarBuilder);
        accessor(grammarBuilder);
        accessorBody(grammarBuilder);
        accessorDeclaration(grammarBuilder);
        accessorDeclarations(grammarBuilder);
        methodDeclarationPI(grammarBuilder);
        resultType(grammarBuilder);
        formalParameters(grammarBuilder);
        formalParameter(grammarBuilder);
        constructorDeclarationPI(grammarBuilder);
        explicitConstructorInvocationPI(grammarBuilder);
        classOrInterfaceDeclaration(grammarBuilder);
        getSharingRules(grammarBuilder);
        enumDeclaration(grammarBuilder);
        enumBody(grammarBuilder);
        fieldDeclarationPi(grammarBuilder);
        variableDeclaratorPi(grammarBuilder);
        initializer(grammarBuilder);
        initializerBlock(grammarBuilder);
        initializerBlockMember(grammarBuilder);
        classOrInterfaceMember(grammarBuilder);
        localVariableDeclaration(grammarBuilder);
        classOrInterfaceBody(grammarBuilder);
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
                CLASS_NAME,
                grammarBuilder.zeroOrMore(COMMA, CLASS_NAME)
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
                grammarBuilder.firstOf(EXCEPTION, CLASS_NAME)
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
        grammarBuilder.rule(METHOD_IDENTIFIER).is(
                grammarBuilder.firstOf(
                        ALLOWED_KEYWORDS_AS_IDENTIFIER,
                        SPECIAL_KEYWORDS_AS_IDENTIFIER));
    }

    /**
     * Creates rules to the last line of the method and the completion of the
     * method.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void methodDeclaration(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(METHOD_DECLARATION).is(grammarBuilder.zeroOrMore(ANNOTATION),
                MODIFIER,
                TYPE,
                METHOD_IDENTIFIER,
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
     * Creates rules for method's last line and completion.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void constructorDeclarationPI(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(CONSTRUCTOR_DECLARATION_PI).is(
                grammarBuilder.firstOf(
                        ALLOWED_KEYWORDS_AS_IDENTIFIER,
                        SPECIAL_KEYWORDS_AS_IDENTIFIER),
                FORMAL_PARAMETERS,
                LBRACE,
                grammarBuilder.optional(EXPLICIT_CONSTRUCTOR_INVOCATION_PI),
                grammarBuilder.zeroOrMore(BLOCK_STATEMENT),
                RBRACE
        );
    }

    /**
     * Creates rules for method's last line and completion.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void explicitConstructorInvocationPI(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(EXPLICIT_CONSTRUCTOR_INVOCATION_PI).is(
                grammarBuilder.firstOf(THIS, SUPER),
                ARGUMENTSPI,
                SEMICOLON
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
                grammarBuilder.firstOf(EXPRESSION, THIS)
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

    /**
     * It is responsible for creating the rule for identifying a variable.
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
     * Creates the rule for Property Declaration within a class.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void propertyDeclaration(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(PROPERTY_DECLARATION).is(
                TYPE,
                grammarBuilder.firstOf(ALLOWED_KEYWORDS_AS_IDENTIFIER, SPECIAL_KEYWORDS_AS_IDENTIFIER),
                LBRACE,
                ACCESSOR_DECLARATIONS,
                RBRACE);
    }

    /**
     * Creates the rule for accessor within a class.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void accessor(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(ACCESSOR).is(
                grammarBuilder.firstOf(GET, SET));
    }

    /**
     * Creates the rule for accessor body.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void accessorBody(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(ACCESSOR_BODY).is(BLOCK);
    }

    /**
     * Creates the rule for accessor declarations within a class.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void accessorDeclarations(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(ACCESSOR_DECLARATIONS).is(
                grammarBuilder.oneOrMore(
                        ACCESSOR_DECLARATION));
    }

    /**
     * Creates the rule for accessor declaration within a class.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void accessorDeclaration(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(ACCESSOR_DECLARATION).is(
                MODIFIER, ACCESSOR,
                grammarBuilder.firstOf(ACCESSOR_BODY, SEMICOLON));
    }

    /**
     * Creates rules to the last line of the method and the completion of the
     * method.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void methodDeclarationPI(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(METHOD_DECLARATION_PI).is(grammarBuilder.zeroOrMore(ANNOTATION),
                RESULT_TYPE,
                METHOD_IDENTIFIER,
                FORMAL_PARAMETERS,
                grammarBuilder.firstOf(BLOCK, SEMICOLON)
        );
    }

    /**
     * Creates the rule that defines the return type a method can have.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void resultType(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(RESULT_TYPE).is(
                grammarBuilder.firstOf(VOID, TYPE)
        );
    }

    /**
     * Creates the rule that defines a set of formal parameters for a method.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void formalParameters(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(FORMAL_PARAMETERS).is(
                LPAREN, grammarBuilder.optional(FORMAL_PARAMETER,
                        grammarBuilder.zeroOrMore(COMMA, FORMAL_PARAMETER)), RPAREN
        );
    }

    /**
     * Creates the rule that defines a formal parameter for a method.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void formalParameter(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(FORMAL_PARAMETER).is(
                grammarBuilder.optional(FINAL), TYPE,
                grammarBuilder.firstOf(ALLOWED_KEYWORDS_AS_IDENTIFIER,
                        SPECIAL_KEYWORDS_AS_IDENTIFIER)
        );
    }

    /**
     * Creates the rule that defines an enum declaration.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void enumDeclaration(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(ENUM_DECLARATION).is(
                ENUM,
                grammarBuilder.firstOf(ALLOWED_KEYWORDS_AS_IDENTIFIER,
                        SPECIAL_KEYWORDS_AS_IDENTIFIER),
                LBRACE,
                ENUM_BODY,
                RBRACE
        );
    }

    /**
     * Creates the rule that defines an enum body.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void enumBody(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(ENUM_BODY).is(
                grammarBuilder.firstOf(ALLOWED_KEYWORDS_AS_IDENTIFIER,
                        SPECIAL_KEYWORDS_AS_IDENTIFIER),
                grammarBuilder.zeroOrMore(COMMA,
                        grammarBuilder.firstOf(
                                ALLOWED_KEYWORDS_AS_IDENTIFIER,
                                SPECIAL_KEYWORDS_AS_IDENTIFIER
                        )
                )
        );
    }

    /**
     * Creates the rule that defines field declaration.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void fieldDeclarationPi(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(FIELD_DECLARATION_PI).is(
                TYPE,
                VARIABLE_DECLARATOR_PI,
                grammarBuilder.zeroOrMore(
                        COMMA,
                        VARIABLE_DECLARATOR_PI
                ),
                SEMICOLON
        );
    }

    /**
     * Creates the rule that defines a variable declarator.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void variableDeclaratorPi(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(VARIABLE_DECLARATOR_PI).is(
                grammarBuilder.firstOf(
                        ALLOWED_KEYWORDS_AS_IDENTIFIER,
                        SPECIAL_KEYWORDS_AS_IDENTIFIER
                ),
                grammarBuilder.optional(
                        ASSIGN_VARIABLE_INITILIZER
                )
        );
    }

    /**
     * Grammar for the declaration of a class or interface is constructed.
     * Composed of the rules of a class type, its identified, extends, and
     * implements.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void classOrInterfaceDeclaration(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(CLASS_OR_INTERFACE_DECLARATION).is(
                GET_SHARING_RULES,
                MODIFIER,
                TYPE_CLASS,
                grammarBuilder.firstOf(ALLOWED_KEYWORDS_AS_IDENTIFIER, SPECIAL_KEYWORDS_AS_IDENTIFIER),
                grammarBuilder.optional(EXTENDS_LIST),
                grammarBuilder.optional(IMPLEMENTS_LIST),
                LBRACE,
                CLASS_OR_INTERFACE_BODY,
                RBRACE
        );

    }

    /**
     * Grammar for the declaration of a class or interface body.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void classOrInterfaceBody(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(CLASS_OR_INTERFACE_BODY).is(
                grammarBuilder.zeroOrMore(CLASS_OR_INTERFACE_MEMBER)
        );
    }

    /**
     * Defines the possible sharing rules a class declaration can have.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void getSharingRules(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(GET_SHARING_RULES).is(
                grammarBuilder.firstOf(
                        WITHOUT,
                        WITH),
                SHARING
        );
    }

    /**
     * Creates the rule that defines an initializer.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void initializer(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(INITIALIZER).is(
                grammarBuilder.optional(STATIC),
                INITIALIZER_BLOCK
        );
    }

    /**
     * Creates the rule that defines an initializer block .
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void initializerBlock(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(INITIALIZER_BLOCK).is(
                LBRACE,
                grammarBuilder.zeroOrMore(
                        INITIALIZER_BLOCK_MEMBER),
                RBRACE
        );
    }

    /**
     * Creates the rule that defines an initializerBlockMember.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void initializerBlockMember(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(INITIALIZER_BLOCK_MEMBER).is(
                grammarBuilder.firstOf(
                        INITIALIZER_BLOCK,
                        FIELD_DECLARATION_PI
                )
        );
    }

    /**
     * Creates the rule for all the possible class or interface members.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void classOrInterfaceMember(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(CLASS_OR_INTERFACE_MEMBER).is(
                grammarBuilder.firstOf(
                        INITIALIZER,
                        DECLARATIONS_WITH_MODIFIERS
                )
        );
        grammarBuilder.rule(DECLARATIONS_WITH_MODIFIERS).is(
                MODIFIER,
                grammarBuilder.firstOf(METHOD_DECLARATION_PI,
                        PROPERTY_DECLARATION,
                        CLASS_OR_INTERFACE_DECLARATION,
                        ENUM_DECLARATION,
                        CONSTRUCTOR_DECLARATION_PI,
                        FIELD_DECLARATION_PI
                )
        );
    }

    /**
     * Creates the rule for localVariableDeclaration.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void localVariableDeclaration(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(LOCAL_VARIABLE_DECLARATION).is(
                grammarBuilder.optional(FINAL),
                TYPE,
                VARIABLE_DECLARATOR_PI,
                grammarBuilder.zeroOrMore(COMMA, VARIABLE_DECLARATOR_PI)
        );
    }
}
