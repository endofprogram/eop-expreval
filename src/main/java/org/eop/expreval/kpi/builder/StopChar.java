package org.eop.expreval.kpi.builder;

/**
 * 停止字符
 * @author lixinjie
 * @since 2018-06-12
 */
public enum StopChar {

	LeftParent('('),
	RightParent(')'),
	Plus('+'),
	Dash('-'),
	Asterisk('*'),
	Slash('/'),
	Caret('^'),
	Comma(','),
	Greater('>'),
	Less('<'),
	Equal('='),
	Ampersand('&'),
	Vbar('|'),
	Exclam('!'),
	End('\0');
	
	
	private char stopChar;
	
	private StopChar(char stopChar) {
		this.stopChar = stopChar;
	}
	
	public char getChar() {
		return stopChar;
	}
	
	public static boolean needStop(char ch) {
		for (StopChar stopChar : values()) {
			if (stopChar.getChar() == ch) {
				return true;
			}
		}
		return false;
	}
	
	public static StopChar obtainStopChar(char ch) {
		for (StopChar stopChar : values()) {
			if (stopChar.getChar() == ch) {
				return stopChar;
			}
		}
		return null;
	}
}
