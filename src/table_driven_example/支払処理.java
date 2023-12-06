package table_driven_example;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.*;

public class 支払処理 {

	public static LocalDate 支払期日(LocalDate 納品日, 支払条件 支払条件) {
		LocalDate 適用締日 =
				適用締日(納品日, 支払条件.締日指定方法, 支払条件.締日指定日付);
		LocalDate 支払期日 =
				ｎ期間後(適用締日, 支払条件.LT期間数, 支払条件.LT期間単位);
		return 支払期日;
	}

	static LocalDate 適用締日(
			LocalDate 取引日, 期日指定方法 締日指定方法, Integer 指定日付) {
		return switch (締日指定方法) {
			case 即日 -> 取引日;
			case 月末日 -> 月末日(取引日);
			case 指定日付 -> (取引日.getDayOfMonth() <= 指定日付
					? 取引日
					: 取引日.plus(1, MONTHS))
					.withDayOfMonth(指定日付);
		};
	}

	static LocalDate ｎ期間後(
			LocalDate 日付, int 期間数, 期間単位 期間単位) {
		return 前日(ｎ期間後_月末考慮前(翌日(日付), 期間数, 期間単位));
	}

	static LocalDate ｎ期間後_月末考慮前(
			LocalDate 日付, int 期間数, 期間単位 期間単位) {
		return 日付.plus(期間数, 期間単位.chronoUnit);
	}

	static LocalDate 月末日(LocalDate 日付) {
		return 日付.withDayOfMonth(日付.lengthOfMonth());
	}

	static LocalDate 翌日(LocalDate 日付) {
		return 日付.plus(1, DAYS);
	}

	static LocalDate 前日(LocalDate 日付) {
		return 日付.minus(1, DAYS);
	}
}
