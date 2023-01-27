package edu;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float exchangeRate = 1136.50F;	// 소수의 기본형은 Double. Float 타입은 뒤에 F.
		double USDAmount = 600.50;
		double KRWAmount = 682468.25;
		
		double summary2 = exchangeRate;	// Float에서 Double로 형변환 OK, Double에서 Float로 형변환은 NG 
		
		System.out.println(exchangeRate);
		System.out.println(USDAmount);
		System.out.println(KRWAmount);
	}

}
