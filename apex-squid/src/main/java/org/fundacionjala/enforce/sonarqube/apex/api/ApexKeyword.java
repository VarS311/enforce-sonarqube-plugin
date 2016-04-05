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

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.TokenType;

/**
 * Enum save the keywords that are used throughout the squid module.
 */
public enum ApexKeyword implements TokenType {

    /**
     * RESERVED WORDS AND LITERALS.
     */
    ABSTRACT("abstract"),
    ACTIVATE("activate"),
    AND("and"),
    ANY("any"),
    ARRAY("array"),
    AS("as"),
    ASC("asc"),
    AUTONOMOUS("autonomous"),
    AFTER("after"),
    ANOTATION("anotation"),
    BEGIN("begin"),
    BIGDECIMAL("bigdecimal"),
    BLOB("blob"),
    BREAK("break"),
    BEFORE("before"),
    BOOLEAN("boolean"),
    BULK("bulk"),
    BY("by"),
    BYTE("byte"),
    CASE("case"),
    CAST("cast"),
    CATCH("catch"),
    CATEGORY("category"),
    CHAR("char"),
    CLASS("class"),
    COLLECT("collect"),
    COMMIT("commit"),
    CONST("const"),
    CONTINUE("continue"),
    CONVERTCURRENCY("convertcurrency"),
    DATA("data"),
    DECIMAL("decimal"),
    DEFAULT("default"),
    DELETE("delete"),
    DESC("desc"),
    DO("do"),
    DOUBLE("double"),
    ELSE("else"),
    END("end"),
    ENUM("enum"),
    EXCEPTION("exception"),
    EXIT("exit"),
    EXPORT("export"),
    EXTENDS("extends"),
    FALSE("false"),
    FINAL("final"),
    FINALLY("finally"),
    FIRST("first"),
    FLOAT("float"),
    FOR("for"),
    FROM("from"),
    GET("get"),
    GLOBAL("global"),
    GOTO("goto"),
    GROUP("group"),
    HAVING("having"),
    HINT("hint"),
    IF("if"),
    IMPLEMENTS("implements"),
    IMPORT("import"),
    INNER("inner"),
    INSERT("insert"),
    INSTANCEOF("instanceof"),
    INTERFACE("interface"),
    INTO("into"),
    INT("int"),
    ITERATOR("iterator"),
    JOIN("join"),
    LAST("last"),
    LIKE("like"),
    LIMIT("limit"),
    LIST("list"),
    LONG("long"),
    LOOP("loop"),
    MAP("map"),
    MERGE("merge"),
    NATIVE("native"),
    NEW("new"),
    NETWORK("network"),
    NOT("not"),
    NULL("null"),
    NULLS("nulls"),
    NUMBER("number"),
    OBJECT("object"),
    OF("of"),
    OFFSET("offset"),
    ON("on"),
    OR("or"),
    OUTER("outer"),
    OVERRIDE("override"),
    PACKAGE("package"),
    PARALLEL("parallel"),
    PRAGMA("pragma"),
    PRIVATE("private"),
    PROTECTED("protected"),
    PUBLIC("public"),
    RETRIEVE("retrieve"),
    RETURN("return"),
    RETURNING("returning"),
    ROLLBACK("rollback"),
    SAVEPOINT("savepoint"),
    SEARCH("search"),
    SELECT("select"),
    SET("set"),
    SHARING("sharing"),
    SHORT("short"),
    STAT("stat"),
    STATIC("static"),
    STRICTFP("strictfp"),
    SUPER("super"),
    SWITCH("switch"),
    SYNCHRONIZED("synchronized"),
    SYSTEM("system"),
    TESTMETHOD("testmethod"),
    THEN("then"),
    THIS("this"),
    THROW("throw"),
    TOLABEL("tolabel"),
    TRANSACTION("transaction"),
    TRANSIENT("transient"),
    TRIGGER("trigger"),
    TRUE("true"),
    TRY("try"),
    TYPE("type"),
    UNDELETE("undelete"),
    UPDATE("update"),
    UPSERT("upsert"),
    USING("using"),
    VIRTUAL("virtual"),
    VOID("void"),
    VOLATILE("volatile"),
    WEBSITE("website"),
    WHEN("when"),
    WHERE("where"),
    WHILE("while"),
    WITH("with"),
    WITHOUT("without"),

    /**
     * APEX ANNOTATIONS.
     */
    AURA_ENABLED("AuraEnabled"),
    DEPRECATED("deprecated"),
    FUTURE("future"),
    INVOCABLE_METHOD("InvocableMethod"),
    INVOCABLE_VARIABLE("InvocableVariable"),
    IS_TEST("isTest"),
    READ_ONLY("ReadOnly"),
    REMOTE_ACTION("RemoteAction"),
    TEST_SETUP("testSetup"),
    TEST_VISIBLE("TestVisible"),

    /**
     * SOQL DATE LITERAL
     */
    TODAY("today"),
    YESTERDAY("yesterday"),
    TOMORROW("tomorrow"),
    LAST_WEEK("last_week"),
    THIS_WEEK("this_week"),
    NEXT_WEEK("next_week"),
    LAST_MONTH("last_month"),
    THIS_MONTH("this_month"),
    NEXT_MONTH("next_month"),
    LAST_90_DAYS("last_90_days"),
    NEXT_90_DAYS("next_90_days"),
    THIS_QUARTER("this_quarter"),
    LAST_QUARTER("last_quarter"),
    NEXT_QUARTER("next_quarter"),
    THIS_YEAR("this_year"),
    LAST_YEAR("last_year"),
    NEXT_YEAR("next_year"),
    THIS_FISCAL_QUARTER("this_fiscal_quarter"),
    LAST_FISCAL_QUARTER("last_fiscal_quarter"),
    NEXT_FISCAL_QUARTER("next_fiscal_quarter"),
    THIS_FISCAL_YEAR("this_fiscal_year"),
    LAST_FISCAL_YEAR("last_fiscal_year"),
    NEXT_FISCAL_YEAR("next_fiscal_year"),
    
    /**
     * SOQL NDate Literal
     */
    LAST_N_DAYS("last_n_days"),
    NEXT_N_DAYS("next_n_days"),
    LAST_N_WEEKS("last_n_weeks"),
    NEXT_N_WEEKS("next_n_weeks"),
    LAST_N_MONTHS("last_n_months"),
    NEXT_N_MONTHS("next_n_months"),
    LAST_N_QUARTERS("last_n_quarters"),
    NEXT_N_QUARTERS("next_n_quarters"),
    LAST_N_YEARS("last_n_years"),
    NEXT_N_YEARS("next_n_years"),
    LAST_N_FISCAL_QUARTERS("last_n_fiscal_quarters"),
    NEXT_N_FISCAL_QUARTERS("next_n_fiscal_quarters"),
    LAST_N_FISCAL_YEARS("last_n_fiscal_years"),
    NEXT_N_FISCAL_YEARS("next_n_fiscal_years");
    
    /**
     * Save the value with enums.
     */
    private final String value;

    private ApexKeyword(String value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean hasToBeSkippedFromAst(AstNode an) {
        return Boolean.FALSE;
    }

}
