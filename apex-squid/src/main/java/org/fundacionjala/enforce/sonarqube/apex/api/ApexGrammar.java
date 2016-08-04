/*
 * Copyright (c) Fundacion Jala. All rights reserved.
 * Licensed under the MIT license. See LICENSE file in the project root for full license information.
 */

package org.fundacionjala.enforce.sonarqube.apex.api;

import org.fundacionjala.enforce.sonarqube.apex.api.grammar.buildersource.*;
import org.fundacionjala.enforce.sonarqube.apex.api.grammar.buildersource.SOQLExpressions;
import org.sonar.sslr.grammar.LexerfulGrammarBuilder;

import com.sonar.sslr.api.Grammar;

import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.APEX_GRAMMAR;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.ApexGrammarRuleKey.TYPE_DECLARATION;
import static com.sonar.sslr.api.GenericTokenType.EOF;
import com.sun.source.tree.Tree;
import org.fundacionjala.oblivion.apex.ast.tree.ApexTreeFactory;
import org.fundacionjala.oblivion.apex.grammar.ast.TreeFactory;

/**
 * This class unites all the rules you need a class.
 */
public class ApexGrammar {

    /**
     * Default constructor.
     */
    private ApexGrammar() {
    }
    
    private static Tree tree;
    

    /**
     * It is the main method of grammar. Here all other grammars are
     * constructed.
     *
     * @return the grammar
     */
    public static Grammar create() {
        LexerfulGrammarBuilder grammarBuilder = LexerfulGrammarBuilder.create();
        
        TreeFactory factory = new ApexTreeFactory();

        MostUsed.create(grammarBuilder);

        Expression.create(grammarBuilder);

        Type.create(grammarBuilder);

        Statement.create(grammarBuilder);

        Declaration.create(grammarBuilder);
        
        SOQLExpressions.create(grammarBuilder);

        Tree cuTree = factory.createCompilationUnit(tree);
        
        grammarBuilder.rule(APEX_GRAMMAR).is(Declaration.TYPE_DECLARATION(grammarBuilder, factory), EOF);
        
        
        grammarBuilder.setRootRule(APEX_GRAMMAR);
        
        
        return grammarBuilder.build();
    }
    
    public static Tree getTree() {
        return tree;
    }
}
