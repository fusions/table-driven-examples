package table_driven_example_oop;


public class 支払処理 {

	public static 日付 支払期日(日付 納品日, 支払条件 支払条件) {
		return 支払条件.支払期日(納品日);
	}

}
