package lab03;

public class Kolo implements Figura {

	double promien;

	
	
	public Kolo(double promien) {
		super();
		this.promien = promien;
	}



	@Override
	public double obliczObwod() {
		double L = 2 * Pi * promien;
		return L;

	}

	@Override
	public double obliczPole() {
		double A = Pi*promien*promien;
		return A;

	}

}
