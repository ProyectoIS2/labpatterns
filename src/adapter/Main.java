package adapter;

import java.util.Comparator;
import java.util.Iterator;

import domain.Covid19Pacient;
import domain.ISymptonFactory;
import domain.Symptom;
import domain.SymptonFactory;

public class Main {

	public static void main(String[] args) {
		ISymptonFactory symptonFactory = new SymptonFactory();
		Covid19Pacient p = new Covid19Pacient("Agus", 21, symptonFactory);
		p.addSymptom(new Symptom("Sintoma1", 7, 4), 1);
		p.addSymptom(new Symptom("Sintoma2", 9, 3), 2);
		p.addSymptom(new Symptom("Sintoma3", 3, 7), 3);
		p.addSymptom(new Symptom("Sintoma4", 1, 1), 2);
		p.addSymptom(new Symptom("Sintoma5", 8, 9), 1);
		
		InvertedIterator pacientAdapter = new Covid19PacientAdapter(p);
		
		Comparator comparatorSymtomName = new SymptomNameComparator();
		Comparator comparatorSeverityIndex = new SeverityIndexComparator();
		
		//Ordenado por nombre
		System.out.println("Ordenado por name");
		Iterator sortedByName = Sorting.sortedIterator(pacientAdapter, comparatorSymtomName);
		while (sortedByName.hasNext()) {
			System.out.println(sortedByName.next());
		}
		
	
		//Ordenado por severity index
		System.out.println("\nOrdenado por severity");
		Iterator sortedBySeverity = Sorting.sortedIterator(pacientAdapter, comparatorSeverityIndex);
		while (sortedBySeverity.hasNext()) {
			System.out.println(sortedBySeverity.next());
		}
	}

}
