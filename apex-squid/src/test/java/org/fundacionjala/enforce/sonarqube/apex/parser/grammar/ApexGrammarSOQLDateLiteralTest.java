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

import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.SOQL_DATE_LITERAL;
import org.fundacionjala.enforce.sonarqube.apex.parser.ApexRuleTest;
import org.junit.Test;
import org.junit.Before;
import static org.sonar.sslr.tests.Assertions.assertThat;

/**
 *
 * @author kevin_titichoca
 */
public class ApexGrammarSOQLDateLiteralTest extends ApexRuleTest{
    
    @Before
    public void init() {
        setRootRule(SOQL_DATE_LITERAL);
    }

    @Test
    public void positiveRules() {
        assertThat(parser)
                .matches("today")
                .matches("yesterday")
                .matches("tomorrow")
                .matches("last_week")
                .matches("this_week")
                .matches("next_week")
                .matches("last_month")
                .matches("this_month")
                .matches("next_month")
                .matches("last_90_days")
                .matches("next_90_days")
                .matches("this_quarter")
                .matches("last_quarter")
                .matches("next_quarter")
                .matches("this_year")
                .matches("last_year")
                .matches("next_year")
                .matches("this_fiscal_quarter")
                .matches("last_fiscal_quarter")
                .matches("next_fiscal_quarter")
                .matches("this_fiscal_year")
                .matches("last_fiscal_year")
                .matches("next_fiscal_year");
    }
    
}
