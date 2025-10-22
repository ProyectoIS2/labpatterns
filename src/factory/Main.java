package factory;

import domain.Covid19Pacient;
import domain.ISymptonFactory;
import domain.Medicament;
import domain.SymptonFactory;

public class Main {

	public static void main(String[] args) {
		ISymptonFactory symptonFactory = new SymptonFactory();
		Covid19Pacient p1=new Covid19Pacient("aitor", 35, symptonFactory);
		new PacientSymptomGUI(p1);
		new MedicalGUI(new Medicament("Ibuprofeno", symptonFactory));

	}

}
