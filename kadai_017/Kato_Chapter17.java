package kadai_017;

abstract public class Kato_Chapter17 {
	
	//親クラス
	
	//フィールド
	public String familyName;	//姓
	public String givenName;	//名
	public String address;		//住所
	
	public void commonIntroduce(String familyName, String address) {
		familyName = "加藤";
		address = "東京都中野区〇×";
		System.out.println("名前は" + familyName + givenName + "です");
		System.out.println("住所は" + address + "です");
	}
	abstract public void eachIntroduce();	//個別の紹介を出力する
	
	public void execIntroduce() {	//実行する

	}
	

}
