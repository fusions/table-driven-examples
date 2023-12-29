package table_driven_example_oop;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public record 日付(LocalDate 日付) {

	public 日付(int 年, int 月, int 日){
		this (LocalDate.of(年, 月, 日));
	}

	public int 日(){
		return this.日付.getDayOfMonth();
	}

	public 日付 同月中指定日(int 日){
		return new 日付(this.日付.withDayOfMonth(日));
	}

	public 日付 月末日() {
		return new 日付(this.日付.withDayOfMonth(this.日付.lengthOfMonth()));
	}

	public 日付 翌日() {
		return new 日付(this.日付.plus(1, DAYS));
	}

	public 日付 前日() {
		return new 日付(this.日付.minus(1, DAYS));
	}

	public 日付 ｎ期間後(int 期間数, 期間単位 期間単位) {
		return new 日付(this.日付.plus(期間数, 期間単位.chronoUnit));
	}
}
