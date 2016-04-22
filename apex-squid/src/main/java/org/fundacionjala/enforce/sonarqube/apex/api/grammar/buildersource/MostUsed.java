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
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.AFTER;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.BEFORE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.CATEGORY;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.CONVERT_CURRENCY;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.DATA;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.FALSE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.FIRST;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.GET;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.GROUP;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.ITERATOR;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LAST;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.LIMIT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NETWORK;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NULL;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.OFFSET;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.RETURNING;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.SAVE_POINT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.SEARCH;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.SHARING;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.STAT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.TO_LABEL;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.TRANSIENT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.TRUE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.WITHOUT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.DOT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.LBRACE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexPunctuator.RBRACE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexTokenType.HEXADECIMAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexTokenType.NUMERIC;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexTokenType.STRING;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.ALLOWED_KEYWORDS_AS_IDENTIFIER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.BLOCK;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.BLOCK_STATEMENT;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.BOOLEAN_LITERAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.DECIMAL_LITERAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.HEX_LITERAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.INTEGER_LITERAL_NUMBER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.LITERAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.METHOD_IDENTIFIER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.NAME;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.NULL_LITERAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.OCTAL_LITERAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.SPECIAL_KEYWORDS_AS_IDENTIFIER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.STRING_LITERAL_STRING;

/**
 * This class contains constructors for most used rules and its sub rules.
 *
 */
public class MostUsed {

    public static void create(LexerfulGrammarBuilder grammarBuilder) {
        allowedKeywordsAsIdentifier(grammarBuilder);
        specialKeywordsAsIdentifier(grammarBuilder);
        block(grammarBuilder);
        name(grammarBuilder);
        decimalLiteral(grammarBuilder);
        hexLiteral(grammarBuilder);
        octalLiteral(grammarBuilder);
        integerLiteralNumber(grammarBuilder);
        stringLiteralString(grammarBuilder);
        booleanLiteral(grammarBuilder);
        nullLiteral(grammarBuilder);
        literal(grammarBuilder);
    }

    /**
     * Grammar to define which are the allowed keywords to be use as identifier.
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
                        CONVERT_CURRENCY,
                        SAVE_POINT,
                        TO_LABEL,
                        SHARING,
                        GET,
                        AFTER,
                        BEFORE,
                        FIRST,
                        LAST,
                        CATEGORY,
                        NETWORK,
                        ITERATOR));
    }

    /**
     * Grammar to define which are the allowed keywords to be used as
     * identifier.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void specialKeywordsAsIdentifier(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(SPECIAL_KEYWORDS_AS_IDENTIFIER).is(
                grammarBuilder.firstOf(
                        WITHOUT,
                        OFFSET,
                        DATA,
                        GROUP,
                        LIMIT
                ));
    }

    /**
     * Grammar to define block rule.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void block(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(BLOCK).is(
                LBRACE,
                grammarBuilder.zeroOrMore(BLOCK_STATEMENT),
                RBRACE
        );
    }

    /**
     * Defines the rule for name.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void name(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(NAME).is(
                METHOD_IDENTIFIER,
                grammarBuilder.zeroOrMore(
                        DOT,
                        METHOD_IDENTIFIER
                )
        );
    }

    /**
     * Defines decimal literal rule.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void decimalLiteral(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(DECIMAL_LITERAL).is(
                NUMERIC
        );
    }

    /**
     * Defines rule for hexadecimal literal.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void hexLiteral(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(HEX_LITERAL).is(
                NUMERIC,
                HEXADECIMAL
        );
    }

    /**
     * Defines rule for octal literal.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void octalLiteral(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(OCTAL_LITERAL).is(
                NUMERIC
        );
    }

    /**
     * Defines rule for integer literal number.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void integerLiteralNumber(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(INTEGER_LITERAL_NUMBER).is(
                grammarBuilder.firstOf(
                        HEX_LITERAL,
                        OCTAL_LITERAL,
                        DECIMAL_LITERAL
                )
        );
    }

    /**
     * Defines rule for string literal string.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void stringLiteralString(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(STRING_LITERAL_STRING).is(
                STRING
        );
    }

    /**
     * Defines rule for boolean literal.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void booleanLiteral(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(BOOLEAN_LITERAL).is(
                grammarBuilder.firstOf(
                        TRUE,
                        FALSE)
        );
    }

    /**
     * Defines rule for null literal.
     *
     * @param grammarBuilder ApexGrammarBuilder parameter.
     */
    private static void nullLiteral(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(NULL_LITERAL).is(
                NULL
        );
    }
    
    private static void literal(LexerfulGrammarBuilder grammarBuilder) {
        grammarBuilder.rule(LITERAL).is(
                grammarBuilder.firstOf(
                        INTEGER_LITERAL_NUMBER,
                        STRING_LITERAL_STRING,
                        BOOLEAN_LITERAL,
                        NULL_LITERAL,
                        SPECIAL_KEYWORDS_AS_IDENTIFIER
                )
        );
    }
}
