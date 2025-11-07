package adapter;

import java.util.ArrayList;
import java.util.List;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientAdapter implements InvertedIterator{
	
	List<Symptom> symptoms;
	int position;
	
	public Covid19PacientAdapter(Covid19Pacient p) {
		this.symptoms = new ArrayList<>(p.getSymptoms());	
		
		goLast();
	}

	@Override
	public Object previous() {
		Symptom s = symptoms.get(position);
		position --;
		return s;
	}

	@Override
	public boolean hasPrevious() {
		return position>=0;
	}

	@Override
	public void goLast() {
		position = symptoms.size()-1;
		
	}

}
