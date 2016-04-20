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
package org.fundacionjala.enforce.sonarqube.apex.parser.grammar;

import org.fundacionjala.enforce.sonarqube.apex.parser.ApexRuleTest;
import org.junit.Before;
import org.junit.Test;
import static org.sonar.sslr.tests.Assertions.assertThat;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.EXPRESSION_PI;

public class ApexGrammarExpressionPiTest extends ApexRuleTest {

    @Before
    public void init() {
        setRootRule(EXPRESSION_PI);
    }

    @Test
    public void positiveRules() {
        assertThat(parser)
                .matches("1")
                .matches("a")
                .matches("someIdentifier")
                .matches("this")
                .matches("null")
                .matches("super")
                .matches("1009")
                //with assignmentOperators
                .matches("x = 5")
                .matches("x = y = 2")
                .matches("count += 4")
                //with conditional expression
                .matches("thisValue ? 0 : 1")
                .matches("x = somethingTrue ? this : null")
                .matches("y += question ? 1 : 10")
                //with AND and OR expressions
                .matches("a || b")
                .matches("aBooleanValue = firstCondition && secondCondition || thirdCondition")
                .matches("a = b || c ? someValue : someOtherValue");
                
    }
    
    @Test
    public void negativeRules() {
        assertThat(parser)
                .notMatches("private")
                .notMatches("void")
                .notMatches("class = this")
                .notMatches("this == that")
                .notMatches("4 == 4")
                .notMatches("*")
                .notMatches("y == question ? 1 : 10")
                .notMatches("a && b == c")
                .notMatches("a = b &| c");
    }
}
