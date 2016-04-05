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

import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.SOQL_NDATE_LITERAL;
import org.fundacionjala.enforce.sonarqube.apex.parser.ApexRuleTest;
import org.junit.Test;
import org.junit.Before;
import static org.sonar.sslr.tests.Assertions.assertThat;

/**
 *
 * @author kevin_titichoca
 */
public class ApexGrammarSOQLNDateLiteralTest extends ApexRuleTest {
    
     @Before
    public void init() {
        setRootRule(SOQL_NDATE_LITERAL);
    }

    @Test
    public void positiveRules() {
        assertThat(parser)
                .matches("last_n_days")
                .matches("next_n_days")
                .matches("next_n_weeks")
                .matches("last_n_weeks")
                .matches("last_n_months")
                .matches("next_n_months")
                .matches("last_n_quarters")
                .matches("next_n_quarters")
                .matches("last_n_years")
                .matches("next_n_years")
                .matches("last_n_fiscal_quarters")
                .matches("next_n_fiscal_quarters")
                .matches("last_n_fiscal_years")
                .matches("next_n_fiscal_years");
    }
    
}
