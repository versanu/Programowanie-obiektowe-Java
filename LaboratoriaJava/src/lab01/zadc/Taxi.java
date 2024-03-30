package lab01.zadc;

import java.util.Random;

public class Taxi extends Auto {
	
	float[]zarobki = new float[12];
	
	Taxi() {
		Random rand = new Random();
		for (int i = 0; i < zarobki.length; i++) {
			zarobki[i]= rand.nextInt(10000);
		}
	}
	
	float srZarobki() {
		int sum = 0;
		for (int i = 0; i < zarobki.length; i++) {
			sum += zarobki[i];
		}
		return sum/zarobki.length;
	}
	
	public static void main(String[] args) {
		Taxi taxi = new Taxi();
		System.out.println("Średni przebieg: " + taxi.srPrzebieg() + " km");
		System.out.println("Średnie zarobki: " + taxi.srZarobki() + " zł");

	}

}

