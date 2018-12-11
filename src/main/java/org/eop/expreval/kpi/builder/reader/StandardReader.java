package org.eop.expreval.kpi.builder.reader;

import org.eop.expreval.kpi.builder.OmitChar;
import org.eop.expreval.kpi.builder.Reader;
import org.eop.expreval.kpi.builder.StopChar;

/**
 * 实现表达式读取器
 * @author lixinjie
 * @since 2018-06-14
 */
public class StandardReader implements Reader {
	
	private char[] source;
	private int length;
	private int index;
	private StringBuilder markBuilder = new StringBuilder();
	
	public StandardReader(String expression) {
		source = expression.toCharArray();
		length = source.length;
		index = 0;
	}

	@Override
	public String read() {
		if (index >= length) {
			return null;
		}
		char ch;
		while (index < length) {
			ch = source[index];
			if (OmitChar.needOmit(ch)) {
				index++;
				continue;
			}
			if (StopChar.needStop(ch)) {
				if (markBuilder.length() < 1) {
					markBuilder.append(ch);
					index++;
				}
				break;
			}
			markBuilder.append(ch);
			index++;
		}
		String mark = markBuilder.toString();
		markBuilder.setLength(0);
		return mark;
	}

	@Override
	public void back() {
		if (index > 0) {
			index--;
		}
	}

}
