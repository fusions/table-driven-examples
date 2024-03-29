package table_driven_example_oop;

import static table_driven_example_oop.期日指定方法.*;
import static table_driven_example_oop.期間単位.*;

public enum 支払条件 {
	納品後７日以内(即日, null, 日, 7),
	納品後２週間以内(即日, null, 日, 14),
	納品月末払(月末日, null, 月, 0),
	月末締翌月末払(月末日, null, 月, 1),
	月末締翌々月末払(月末日, null, 月, 2),
	二十日締翌月二十日払(指定日付, 20, 月, 1);

	final 期日指定方法 締日指定方法;
	final Integer 締日指定日付;
	final 期間単位 LT期間単位;
	final Integer LT期間数;

	支払条件(期日指定方法 締日指定方法, Integer 締日指定日付,
			 期間単位 LT期間単位, Integer LT期間数) {
		this.締日指定方法 = 締日指定方法;
		this.締日指定日付 = 締日指定日付;
		this.LT期間単位 = LT期間単位;
		this.LT期間数 = LT期間数;
	}

	public 日付 支払期日(日付 納品日) {
		日付 適用締日 =
				this.締日指定方法.適用締日(納品日, this.締日指定日付);
		日付 支払期日 =
				ｎ期間後(適用締日, this.LT期間数, this.LT期間単位);
		return 支払期日;
	}

	static 日付 ｎ期間後(
			日付 日付, int 期間数, 期間単位 期間単位) {
		return 日付.翌日().ｎ期間後(期間数, 期間単位).前日();
	}
}
