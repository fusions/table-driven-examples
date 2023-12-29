package table_driven_example_oop;

public enum 期日指定方法 {
	即日,
	月末日,
	指定日付;

	日付 適用締日(日付 取引日,Integer 指定日付) {
		return switch (this) {
			case 即日 -> 取引日;
			case 月末日 -> 取引日.月末日();
			case 指定日付 -> (取引日.日() <= 指定日付
					? 取引日
					: 取引日.ｎ期間後(1,期間単位.月))
					.同月中指定日(指定日付);
		};
	}
}
