package table_driven_example_oop;


import junit.framework.TestCase;

import static table_driven_example_oop.期日指定方法.*;
import static table_driven_example_oop.期間単位.月;

public class 期日指定方法テスト extends TestCase {

	public void test即日() {
		assertEquals(
				new 日付(2024, 4, 10),
				即日.適用締日(new 日付(2024, 4, 10),null)
		);
	}

	public void test月末日() {
		assertEquals(
				new 日付(2024, 4, 30),
				月末日.適用締日(new 日付(2024, 4, 10),null)
		);
	}

	public void test指定日付() {
		assertEquals(
				new 日付(2024, 4, 20),
				指定日付.適用締日(new 日付(2024, 4, 10),20)
		);
		assertEquals(
				new 日付(2024, 4, 20),
				指定日付.適用締日(new 日付(2024, 4, 20),20)
		);
		assertEquals(
				new 日付(2024, 5, 20),
				指定日付.適用締日(new 日付(2024, 4, 21),20)
		);
	}


}
