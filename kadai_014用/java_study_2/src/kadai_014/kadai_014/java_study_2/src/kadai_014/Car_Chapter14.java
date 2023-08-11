package kadai_014;

public class Car_Chapter14 {
	
	// フィールド
	private int gear = 1;
	private int speed = 10;
	
	//①車クラスは次のメソッドを持つ
	public void gearChange(int afterGear) {
		this.gear = afterGear;
		
	}
	
	//②車クラスは次のメソッドを持つ
	public void run() {
		speed = 30;
		System.out.println("速度は時速" + this.speed + "kmです");
		
	}
	
	/*
	
	//ゲッター
	public int getGear() {
		return this.gear;	
	}
	
	public int getSpeed() {
		return this.speed;	
	}
	//ここまでがゲッター
	
	//セッター
	public void setGearChange(int afterGear) {
		this.gear = afterGear;
		
	}

	public void setRun() {
		System.out.println(this.speed);
		
	}
	//ここまでがセッター
	 *  
	 */
}