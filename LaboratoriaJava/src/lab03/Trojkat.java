package lab03;
import java.lang.Math;

public class Trojkat implements Figura {

	double dlugoscBoku1;
	double dlugoscBoku2;
	double dlugoscBoku3;
	
	public Trojkat(double dlugoscBoku1, double dlugoscBoku2, double dlugoscBoku3) {
		this.dlugoscBoku1=dlugoscBoku1;
		this.dlugoscBoku2=dlugoscBoku2;
		this.dlugoscBoku3=dlugoscBoku3;
	}


	@Override
	public double obliczObwod() {
		double obw = dlugoscBoku1+dlugoscBoku2+dlugoscBoku3;
		return obw;
	}

	@Override
	public double obliczPole() {
		double p = (dlugoscBoku1+dlugoscBoku2+dlugoscBoku3)/2;
		double pole = Math.sqrt(p*(p-dlugoscBoku1)*(p-dlugoscBoku2)*(p-dlugoscBoku3));
		
		return pole;
	}

}
