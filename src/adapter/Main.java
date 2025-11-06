package adapter;

import domain.Covid19Pacient;
import domain.ISymptonFactory;
import domain.Symptom;
import domain.SymptonFactory;

public class Main {

	public static void main(String[] args) {
		ISymptonFactory symptonFactory = new SymptonFactory();
		Covid19Pacient p = new Covid19Pacient("Agus", 21, symptonFactory);
		p.addSymptom(new Symptom("Sintoma1", 7, 4), 1);
		p.addSymptom(new Symptom("Sintoma2", 9, 5), 2);
		p.addSymptom(new Symptom("Sintoma3", 3, 6), 3);
		p.addSymptom(new Symptom("Sintoma4", 1, 7), 2);
		p.addSymptom(new Symptom("Sintoma5", 8, 8), 1);

	}

}
