package org.eop.expreval.kpi.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * 优先级
 * @author lixinjie
 * @since 2018-06-12
 */
public class Priority {

	public static Priority Comma() {
		return new Priority(1);
	}
	public static Priority Add() {
		return new Priority(10);
	}
	public static Priority Sub() {
		return new Priority(10);
	}
	public static Priority Mul() {
		return new Priority(100);
	}
	public static Priority Div() {
		return new Priority(100);
	}
	public static Priority Minus() {
		return new Priority(1000);
	}
	public static Priority Positive() {
		return new Priority(1000);
	}
	public static Priority Pow() {
		return new Priority(10000);
	}
	public static Priority Funct() {
		return new Priority(100000);
	}
	public static Priority Parent() {
		return new Priority(1000000);
	}
	public static Priority Token() {
		return new Priority(0);
	}
	public static Priority Zero() {
		return new Priority(0);
	}
	public static Priority Gt() {
		return new Priority(-1);
	}
	public static Priority Lt() {
		return new Priority(-1);
	}
	public static Priority GtEq() {
		return new Priority(-1);
	}
	public static Priority LtEq() {
		return new Priority(-1);
	}
	public static Priority Eq() {
		return new Priority(-10);
	}
	public static Priority NtEq() {
		return new Priority(-10);
	}
	public static Priority Not() {
		return new Priority(-100);
	}
	public static Priority And() {
		return new Priority(-1000);
	}
	public static Priority Or() {
		return new Priority(-10000);
	}
	
	private int value;
	private static Map<String, Builder> CONTAINER;
	
	static {
		CONTAINER = new HashMap<>();
		CONTAINER.put(",", new Builder() {
			
			@Override
			public Priority build() {
				return Priority.Comma();
			}});
		CONTAINER.put("+", new Builder() {

			@Override
			public Priority build() {
				return Priority.Add();
			}});
		CONTAINER.put("-", new Builder() {

			@Override
			public Priority build() {
				return Priority.Sub();
			}});
		CONTAINER.put("*", new Builder() {

			@Override
			public Priority build() {
				return Priority.Mul();
			}});
		CONTAINER.put("/", new Builder() {

			@Override
			public Priority build() {
				return Priority.Div();
			}});
		CONTAINER.put("(-", new Builder() {

			@Override
			public Priority build() {
				return Priority.Minus();
			}});
		CONTAINER.put("(+", new Builder() {

			@Override
			public Priority build() {
				return Priority.Positive();
			}});
		CONTAINER.put("^", new Builder() {

			@Override
			public Priority build() {
				return Priority.Pow();
			}});
		CONTAINER.put("f", new Builder() {

			@Override
			public Priority build() {
				return Priority.Funct();
			}});
		CONTAINER.put("(", new Builder() {

			@Override
			public Priority build() {
				return Priority.Parent();
			}});
		CONTAINER.put(")", new Builder() {

			@Override
			public Priority build() {
				return Priority.Parent();
			}});
		CONTAINER.put("t", new Builder() {

			@Override
			public Priority build() {
				return Priority.Token();
			}});
		CONTAINER.put(">", new Builder() {
			
			@Override
			public Priority build() {
				return Priority.Gt();
			}});
		CONTAINER.put("<", new Builder() {
			
			@Override
			public Priority build() {
				return Priority.Lt();
			}});
		CONTAINER.put(">=", new Builder() {
			
			@Override
			public Priority build() {
				return Priority.GtEq();
			}});
		CONTAINER.put("<=", new Builder() {
			
			@Override
			public Priority build() {
				return Priority.LtEq();
			}});
		CONTAINER.put("==", new Builder() {
			
			@Override
			public Priority build() {
				return Priority.Eq();
			}});
		CONTAINER.put("!=", new Builder() {
			
			@Override
			public Priority build() {
				return Priority.NtEq();
			}});
		CONTAINER.put("!", new Builder() {
			
			@Override
			public Priority build() {
				return Priority.Not();
			}});
		CONTAINER.put("&&", new Builder() {
			
			@Override
			public Priority build() {
				return Priority.And();
			}});
		CONTAINER.put("||", new Builder() {
			
			@Override
			public Priority build() {
				return Priority.Or();
			}});
	}
	
	private Priority(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static Priority obtainPriority(String mark) {
		return CONTAINER.containsKey(mark) ? CONTAINER.get(mark).build() : null;
	}
	
	public void plus(Priority priority) {
		value += priority.value;
	}
	
	public void subt(Priority priority) {
		value -= priority.value;
	}
	
	public boolean higher(Priority priority) {
		return value > priority.value;
	}
	
	public boolean lower(Priority priority) {
		return value < priority.value;
	}
	
	public boolean equal(Priority priority) {
		return value == priority.value;
	}
	
	public boolean lowerOrEqual(Priority priority) {
		return lower(priority) || equal(priority);
	}
	
	private interface Builder {
		Priority build();
	}
	
}
