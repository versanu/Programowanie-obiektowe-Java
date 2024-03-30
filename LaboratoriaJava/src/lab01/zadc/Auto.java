package lab01.zadc;

import java.util.Random;

public class Auto {

	float[] przebieg = new float[12];
	
	Auto() {
		Random rand = new Random();
		for (int i = 0; i < przebieg.length; i++) {
			przebieg[i]= rand.nextInt(10000);
		}
	}
	
	float srPrzebieg() {
		int sum = 0;
		for (int i = 0; i < przebieg.length; i++) {
			sum += przebieg[i];
		}
		return sum/przebieg.length;
	}
}

