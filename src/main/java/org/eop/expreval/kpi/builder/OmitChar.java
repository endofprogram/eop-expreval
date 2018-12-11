package org.eop.expreval.kpi.builder;

/**
 * 忽略字符
 * @author lixinjie
 * @since 2018-06-12
 */
public enum OmitChar {

	/**空格*/
	Blank(' '),
	/**制表符*/
	Tab('	'),
	/**回车*/
	CR('\r'),
	/**换行*/
	LF('\n');
	
	private char omitChar;
	
	private OmitChar(char omitChar) {
		this.omitChar = omitChar;
	}
	
	public char getChar() {
		return omitChar;
	}
	
	public static boolean needOmit(char ch) {
		for (OmitChar omitChar : values()) {
			if (omitChar.getChar() == ch) {
				return true;
			}
		}
		return false;
	}
}
