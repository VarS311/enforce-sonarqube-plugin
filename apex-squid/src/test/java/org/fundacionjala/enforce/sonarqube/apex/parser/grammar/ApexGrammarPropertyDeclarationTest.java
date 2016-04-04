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
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.PROPERTY_DECLARATION;
import static org.sonar.sslr.tests.Assertions.assertThat;

/**
 *
 * @author vicente_rodriguez
 */
public class ApexGrammarPropertyDeclarationTest extends ApexRuleTest {

    @Before
    public void init() {
        setRootRule(PROPERTY_DECLARATION);
    }

    @Test
    public void positiveRules() {
        assertThat(parser)
                //only get
                .matches("public integer Prop { get; }")
                //only set
                .matches("public integer Prop { set; }")
                //get and set
                .matches("public double Prop { get; set; }")
                //get and set with accessors
                .matches("public double Prop {public get; private set; }")
                //get and set with body
                .matches("public integer Prop {\n"
                        + "get { return Prop; }\n"
                        + "set { Prop = value; }\n"
                        + "}")
                //static property with protected accessor
                .matches("public static integer Prop {protected get; set;}")
                //with private access_modifier
                .matches("private integer Prop {get; set;}")
                //with global access_modifier
                .matches("global integer Prop {get; set;}")
                //with protected access_modifier
                .matches("protected integer Prop {get; set;}");
    }
}
