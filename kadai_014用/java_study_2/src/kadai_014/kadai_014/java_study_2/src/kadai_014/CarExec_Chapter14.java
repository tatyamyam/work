package kadai_014;

public class CarExec_Chapter14 {

	public static void main(String[] args) {
		// 車クラスのインスタンスを作成する->車クラスを呼び出す事
		Car_Chapter14 car = new Car_Chapter14();
		
		//車クラスのgearChangeメソッドを実行する
		int afterGear = 3;
		car.gearChange(afterGear);
		
		//車クラスのrunメソッドを実行する
		car.run();

	}

}
