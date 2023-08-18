package kadai_017;

public class KatoTaro_Chapter17 extends Kato_Chapter17 {
	
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public KatoTaro_Chapter17(String familyName, String address) {
		super(familyName, address);
		setGivenName("太郎");
	}
	
	@Override
	public void eachIntroduce() {
		System.out.println("私はJavaが得意です");
	}

}
