package hardcoded_example;


import java.time.LocalDate;
import junit.framework.TestCase;

public class 支払処理テスト extends TestCase {

	public void test納品後７日以内(){
		assertEquals(
			LocalDate.of(2024,4,12),
			支払処理.支払期日(
				LocalDate.of(2024,4,5),
				支払条件.納品後７日以内
				)
			);
	}

	public void test納品後２週間以内(){
		assertEquals(
			LocalDate.of(2024,4,19),
			支払処理.支払期日(
				LocalDate.of(2024,4,5),
				支払条件.納品後２週間以内
			)
		);
	}

	public void test納品月末払(){
		assertEquals(
			LocalDate.of(2024,4,30),
			支払処理.支払期日(
				LocalDate.of(2024,4,5),
				支払条件.納品月末払
			)
		);
	}

	public void test月末締翌月末払(){
		assertEquals(
			LocalDate.of(2024,6,30),
			支払処理.支払期日(
				LocalDate.of(2024,5,31),
				支払条件.月末締翌月末払
			)
		);
	}

	public void test月末締翌々月末払(){
		assertEquals(
			LocalDate.of(2024,6,30),
			支払処理.支払期日(
				LocalDate.of(2024,4,30),
				支払条件.月末締翌々月末払
			)
		);
	}

	public void test二十日締翌月二十日払(){
		assertEquals(
			LocalDate.of(2024,5,20),
			支払処理.支払期日(
				LocalDate.of(2024,4,10),
				支払条件.二十日締翌月二十日払
			)
		);
		assertEquals(
			LocalDate.of(2024,5,20),
			支払処理.支払期日(
				LocalDate.of(2024,4,20),
				支払条件.二十日締翌月二十日払
			)
		);
		assertEquals(
			LocalDate.of(2024,6,20),
			支払処理.支払期日(
				LocalDate.of(2024,4,21),
				支払条件.二十日締翌月二十日払
			)
		);
	}
}
