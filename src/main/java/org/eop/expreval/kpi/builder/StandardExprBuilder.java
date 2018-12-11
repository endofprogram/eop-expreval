package org.eop.expreval.kpi.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.node.Booler;
import org.eop.expreval.kpi.builder.node.Comma;
import org.eop.expreval.kpi.builder.node.Funct;
import org.eop.expreval.kpi.builder.node.Linker;
import org.eop.expreval.kpi.builder.node.StandardBooler;
import org.eop.expreval.kpi.builder.node.StandardComma;
import org.eop.expreval.kpi.builder.node.StandardFunct;
import org.eop.expreval.kpi.builder.node.StandardLinker;
import org.eop.expreval.kpi.builder.node.StandardToken;
import org.eop.expreval.kpi.builder.node.Token;
import org.eop.expreval.kpi.builder.reader.StandardReader;
import org.eop.expreval.kpi.builder.utils.NodeUtils;

/**
 * @author lixinjie
 * @since 2018-06-14
 */
public class StandardExprBuilder implements ExprBuilder {

	@Override
	public Expression build(String expression) {
		Reader reader = new StandardReader(expression);
		List<Node> bar = new ArrayList<>(20);
		Node head = buildNodes(reader, Priority.Zero(), bar);
		bar = sortByPriority(bar);
		return buildExpression(head, bar);
	}

	protected Node buildNodes(Reader reader, Priority priority, List<Node> bar) {
		String mark;
		Node first = null;
		Node last = null;
		while ((mark = reader.read()) != null) {
			if (mark.equals("(")) {
				priority.plus(Priority.obtainPriority("("));
				continue;
			}
			if (mark.equals(")")) {
				priority.subt(Priority.obtainPriority(")"));
				continue;
			}
			if (NodeUtils.isToken(mark)) {
				Token token = new StandardToken();
				token.setMark(mark);
				token.setPriority(Priority.obtainPriority("t"));
				if (first == null) {
					first = token;
					last = token;
				} else {
					last.setRight(token);
					token.setLeft(last);
					last = token;
				}
				continue;
			}
			if (NodeUtils.isLinker(mark)) {
				Linker linker = new StandardLinker();
				linker.setMark(mark);
				if ("+".equals(mark) || "-".equals(mark)) {
					if ((last == null) || (last instanceof Linker)) {
						//单目正负运算符，其余情况是加减运算符
						mark = "(" + mark;
					}
				}
				linker.setPriority(Priority.obtainPriority(mark));
				linker.plusPriority(priority);
				if (first == null) {
					first = linker;
					last = linker;
				} else {
					last.setRight(linker);
					linker.setLeft(last);
					last = linker;
				}
				bar.add(last);
				continue;
			}
			if (NodeUtils.isBooler(mark)) {
				if ("=".equals(mark) || "&".equals(mark) || "|".equals(mark)) {
					if (last instanceof Booler) {
						//需要和前一个节点合并，构成两个字符的运算符（>=,<=,==,!=,&&,||）
						last.setMark(last.getMark() + mark);
						last.setPriority(Priority.obtainPriority(last.getMark()));
						last.plusPriority(priority);
						continue;
					}
				}
				Booler booler = new StandardBooler();
				booler.setMark(mark);
				booler.setPriority(Priority.obtainPriority(mark));
				booler.plusPriority(priority);
				if (first == null) {
					first = booler;
					last = booler;
				} else {
					last.setRight(booler);
					booler.setLeft(last);
					last = booler;
				}
				bar.add(last);
				continue;
			}
			if (NodeUtils.isFunct(mark)) {
				Funct funct = new StandardFunct();
				funct.setMark(mark);
				funct.setPriority(Priority.obtainPriority("f"));
				funct.plusPriority(priority);
				if (first == null) {
					first = funct;
					last = funct;
				} else {
					last.setRight(funct);
					funct.setLeft(last);
					last = funct;
				}
				bar.add(last);
				continue;
			}
			if (NodeUtils.isComma(mark)) {
				Comma comma = new StandardComma();
				comma.setMark(mark);
				comma.setPriority(Priority.obtainPriority(mark));
				comma.plusPriority(priority);
				if (first == null) {
					first = comma;
					last = comma;
				} else {
					last.setRight(comma);
					comma.setLeft(last);
					last = comma;
				}
				bar.add(last);
				continue;
			}
			if (true) {
				Token token = new StandardToken();
				token.setMark(mark);
				token.setPriority(Priority.obtainPriority("t"));
				if (first == null) {
					first = token;
					last = token;
				} else {
					last.setRight(token);
					token.setLeft(last);
					last = token;
				}
				continue;
			}
		}
		return first;
	}
	
	protected Expression buildExpression(Node head, List<Node> bar) {
		if (bar.isEmpty()) {
			return head.buildExpression();
		}
		Expression expression = null;
		Iterator<Node> iter = bar.iterator();
		Node node;
		while (iter.hasNext()) {
			node = iter.next();
			expression = node.buildExpression();
			iter.remove();
		}
		return expression;
	}
	
	private List<Node> sortByPriority(List<Node> bar) {
		Collections.sort(bar, new Comparator<Node>(){

			@Override
			public int compare(Node node1, Node node2) {
				return node2.getPriority().getValue() - node1.getPriority().getValue();
			}});
		return new LinkedList<>(bar);
	}
	
}
