package lab03;

public class ZadanieA {

	public ZadanieA() {
		
	}

	public static void main(String[] args) {
		Trojkat t = new Trojkat(3.0,4.0,5.0);
		Kolo k = new Kolo(4.0);
		
		System.out.println(t.obliczPole());
		System.out.println(t.obliczObwod());
		System.out.println(k.obliczPole());
		System.out.println(k.obliczObwod());
		
		

	}

}
