package hardcoded_example;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.*;

public class 支払処理 {

	public static LocalDate 支払期日(LocalDate 納品日, 支払条件 支払条件) {
		return
				switch (支払条件) {
					case 納品後７日以内 -> 納品日.plus(7, DAYS);
					case 納品後２週間以内 -> 納品日.plus(14, DAYS);
					case 納品月末払 -> 月末日(納品日);
					case 月末締翌月末払 -> 月末日(納品日.plus(1, MONTHS));
					case 月末締翌々月末払 -> 月末日(納品日.plus(2, MONTHS));
					case 二十日締翌月二十日払 -> (納品日.getDayOfMonth() <= 20
							? 納品日.plus(1, MONTHS)
							: 納品日.plus(2, MONTHS))
							.withDayOfMonth(20);
				};
	}

	private static LocalDate 月末日(LocalDate 日付) {
		return 日付.withDayOfMonth(日付.lengthOfMonth());
	}
}
