package table_driven_example_oop;


import junit.framework.TestCase;
import static table_driven_example_oop.支払条件.*;

public class 支払条件テスト extends TestCase {

	public void test納品後７日以内() {
		assertEquals(
				new 日付(2024, 4, 12),
				納品後７日以内.支払期日(new 日付(2024, 4, 5))
		);
	}

	public void test納品後２週間以内() {
		assertEquals(
				new 日付(2024, 4, 19),
				納品後２週間以内.支払期日(new 日付(2024, 4, 5))
		);
	}

	public void test納品月末払() {
		assertEquals(
				new 日付(2024, 4, 30),
				納品月末払.支払期日(new 日付(2024, 4, 5))
		);
	}

	public void test月末締翌月末払() {
		assertEquals(
				new 日付(2024, 5, 31),
				月末締翌月末払.支払期日(new 日付(2024, 4, 30))
		);
		assertEquals(
				new 日付(2024, 6, 30),
				月末締翌月末払.支払期日(new 日付(2024, 5, 31))
		);
	}

	public void test月末締翌々月末払() {
		assertEquals(
				new 日付(2024, 6, 30),
				月末締翌々月末払.支払期日(new 日付(2024, 4, 30))
		);
		assertEquals(
				new 日付(2024, 8, 31),
				月末締翌々月末払.支払期日(new 日付(2024, 6, 30))
		);
	}

	public void test二十日締翌月二十日払() {
		assertEquals(
				new 日付(2024, 5, 20),
				二十日締翌月二十日払.支払期日(new 日付(2024, 4, 10))
		);
		assertEquals(
				new 日付(2024, 5, 20),
				二十日締翌月二十日払.支払期日(new 日付(2024, 4, 20))
		);
		assertEquals(
				new 日付(2024, 6, 20),
				二十日締翌月二十日払.支払期日(new 日付(2024, 4, 21))
		);
		assertEquals(
				new 日付(2024, 7, 20),
				二十日締翌月二十日払.支払期日(new 日付(2024, 5, 31))
		);
	}
}
