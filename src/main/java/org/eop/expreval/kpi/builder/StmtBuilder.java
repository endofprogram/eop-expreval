package org.eop.expreval.kpi.builder;

import org.eop.expreval.kpi.Statement;

/**
 * 把语句字符串变为语句
 * @author lixinjie
 * @since 2018-06-24
 */
public interface StmtBuilder {

	Statement build(String statements);
}
