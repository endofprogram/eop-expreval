package org.eop.expreval.kpi.builder.node;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Node;

/**
 * 逗号实现，合并函数参数
 * @author lixinjie
 * @since 2018-06-15
 */
public class StandardComma extends AbstractNode implements Comma {

	@Override
	public Expression buildExpression() {
		Node comma = this;
		Node left = getLeft();
		Node right = getRight();
		Node lleft = left.getLeft();
		Node rright = right.getRight();
		Param param;
		if (!(left instanceof Param)) {
			param = new StandardParam();
			param.addNode(left);
			left.setLeft(null);
			left.setRight(null);
			param.setLeft(lleft);
			lleft.setRight(param);
			param.setRight(comma);
			comma.setLeft(param);
		} else {
			param = (Param)left;
		}
		param.addNode(right);
		comma.setLeft(null);
		comma.setRight(null);
		right.setLeft(null);
		right.setRight(null);
		param.setRight(rright);
		if (rright != null) {
			rright.setLeft(param);
		}
		return null;
	}

}
