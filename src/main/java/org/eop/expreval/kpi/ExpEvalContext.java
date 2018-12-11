package org.eop.expreval.kpi;

import java.util.HashMap;
import java.util.Map;

import org.eop.expreval.kpi.function.Function;

/**
 * 表达式计算上下文
 * @author lixinjie
 * @since 2018-06-11
 */
public class ExpEvalContext {
	
	private Map<String, Object> variables = new HashMap<>();
	private Map<String, Object> basedatas = new HashMap<>();
	private Map<String, Object> arguments = new HashMap<>();
	private Map<String, Object> indicators = new HashMap<>();
	private Map<String, Function> functions = new HashMap<>();

	public Object getVariableValue(String variableName) {
		return variables.get(variableName);
	}
	
	public Object getBasedataValue(String basedataName) {
		return basedatas.get(basedataName);
	}
	
	public Object getArgumentValue(String argumentName) {
		return arguments.get(argumentName);
	}
	
	public Object getIndicatorValue(String indicatorName) {
		return indicators.get(indicatorName);
	}
	
	public Object getFunctionValue(String functionName, Expression[] functionParams) {
		Object[] params = new Object[functionParams.length];
		for (int i = 0, len = params.length; i < len; i++) {
			params[i] = functionParams[i].evaluate(this);
		}
		return functions.get(functionName).call(params);
	}

	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}
	
	public void setBasedatas(Map<String, Object> basedatas) {
		this.basedatas = basedatas;
	}
	
	public void setArguments(Map<String, Object> arguments) {
		this.arguments = arguments;
	}
	
	public void setIndicators(Map<String, Object> indicators) {
		this.indicators = indicators;
	}

	public void setFunctions(Map<String, Function> functions) {
		this.functions = functions;
	}

	public void addVariables(Map<String, Object> variables) {
		this.variables.putAll(variables);
	}
	
	public void addBasedatas(Map<String, Object> basedatas) {
		this.basedatas.putAll(basedatas);
	}
	
	public void addArguments(Map<String, Object> arguments) {
		this.arguments.putAll(arguments);
	}

	public void addIndicators(Map<String, Object> indicators) {
		this.indicators.putAll(indicators);
	}

	public void addFunctions(Map<String, Function> functions) {
		this.functions.putAll(functions);
	}
	
	public void addVariable(String name, Object value) {
		this.variables.put(name, value);
	}
	
	public void addBasedata(String name, Object value) {
		this.basedatas.put(name, value);
	}
	
	public void addArgument(String name, Object value) {
		this.arguments.put(name, value);
	}
	
	public void addIndicator(String name, Object value) {
		this.indicators.put(name, value);
	}
	
	public void addFunction(String name, Function funct) {
		this.functions.put(name, funct);
	}
	
	public void clearVariables() {
		this.variables.clear();
	}
	
	public void clearBasedatas() {
		this.basedatas.clear();
	}
	
	public void clearArguments() {
		this.arguments.clear();
	}
	
	public void clearIndicators() {
		this.indicators.clear();
	}

	public void clearFunctions() {
		this.functions.clear();
	}
}
