package kadai_017;

abstract public class Kato_Chapter17 {
	
	//親クラス
	
	//フィールド
	public String familyName;	//姓
	public String givenName;	//名
	public String address;		//住所
	
	
	public void commonIntroduce() {
		System.out.println("名前は" + familyName + givenName + "です");
		System.out.println("住所は" + address+ "です");
	}
	
	abstract public void eachIntroduce();	//抽象メソッド
	
	public void execIntroduce() {
		commonIntroduce();
		eachIntroduce();
		
	}

}
