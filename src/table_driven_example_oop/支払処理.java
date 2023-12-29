package table_driven_example_oop;


public class 支払処理 {

	public static 日付 支払期日(日付 納品日, 支払条件 支払条件) {
		日付 適用締日 =
				支払条件.締日指定方法.適用締日(納品日, 支払条件.締日指定日付);
		日付 支払期日 =
				ｎ期間後(適用締日, 支払条件.LT期間数, 支払条件.LT期間単位);
		return 支払期日;
	}

	static 日付 ｎ期間後(
			日付 日付, int 期間数, 期間単位 期間単位) {
		return 日付.翌日().ｎ期間後(期間数, 期間単位).前日();
	}

}
