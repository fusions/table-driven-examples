package table_driven_example_oop;


import junit.framework.TestCase;
import static table_driven_example_oop.期間単位.*;

public class 日付テスト extends TestCase {

	public void test日() {
		assertEquals(1, new 日付(2024, 4, 1).日());
		assertEquals(12, new 日付(2024, 4, 12).日());
		assertEquals(30, new 日付(2024, 4, 30).日());
	}

	public void test同月中指定日() {
		assertEquals(
				new 日付(2024, 4, 1),
				new 日付(2024, 4, 15).同月中指定日(1));
		assertEquals(
				new 日付(2024, 4, 20),
				new 日付(2024, 4, 15).同月中指定日(20));
		assertEquals(
				new 日付(2024, 4, 30),
				new 日付(2024, 4, 15).同月中指定日(30));
	}

	public void test月末日() {
		assertEquals(
				new 日付(2024, 4, 30),
				new 日付(2024, 4, 15).月末日());
		assertEquals(
				new 日付(2024, 5, 31),
				new 日付(2024, 5, 1).月末日());
		assertEquals(
				new 日付(2024, 2, 29),
				new 日付(2024, 2, 27).月末日());
	}
	public void test翌日() {
		assertEquals(
				new 日付(2024, 4, 16),
				new 日付(2024, 4, 15).翌日());
		assertEquals(
				new 日付(2024, 5, 1),
				new 日付(2024, 4, 30).翌日());
		assertEquals(
				new 日付(2024, 2, 29),
				new 日付(2024, 2, 28).翌日());
	}
	public void test前日() {
		assertEquals(
				new 日付(2024, 4, 14),
				new 日付(2024, 4, 15).前日());
		assertEquals(
				new 日付(2024, 4, 30),
				new 日付(2024, 5, 1).前日());
		assertEquals(
				new 日付(2024, 2, 29),
				new 日付(2024, 3, 1).前日());
	}
	public void testｎ期間後() {
		assertEquals(
				new 日付(2024, 4, 20),
				new 日付(2024, 4, 15).ｎ期間後(5, 日));
		assertEquals(
				new 日付(2024, 9, 15),
				new 日付(2024, 4, 15).ｎ期間後(5, 月));
		assertEquals(
				new 日付(2024, 5, 30),		// 5月31日ではない！
				new 日付(2024, 4, 30).ｎ期間後(1, 月));
		assertEquals(
				new 日付(2024, 6, 30),		// 7月1日ではない！
				new 日付(2024, 5, 31).ｎ期間後(1, 月));
	}
}
