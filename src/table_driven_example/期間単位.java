package table_driven_example;

import java.time.temporal.ChronoUnit;

public enum 期間単位 {
	日(ChronoUnit.DAYS),
	月(ChronoUnit.MONTHS);

	final ChronoUnit chronoUnit;

	期間単位(ChronoUnit chronoUnit) {
		this.chronoUnit = chronoUnit;
	}
}
