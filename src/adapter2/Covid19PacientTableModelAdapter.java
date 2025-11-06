package adapter2;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientTableModelAdapter extends AbstractTableModel {
	  protected Covid19Pacient pacient;
	  protected String[] columnNames =
	    new String[] {"Symptom", "Weight" };
	  private ArrayList symptomsList;

	  public Covid19PacientTableModelAdapter(Covid19Pacient p) {
	    this.pacient=p;
	    this.symptomsList = new ArrayList<>(pacient.getSymptoms());
	  }
	  
	  @Override
	  public int getColumnCount() {
		 return 2;
	  }
	  
	  @Override
	  public String getColumnName(int i) {
		  if (i == 0) {
			  return "Symptom";
		  }
		  else if (i == 1) {
			  return "Weight";
		  }
		  return null;
	  }
	  
	  @Override
	  public int getRowCount() {
		  return symptomsList.size();
	  }
	  
	  @Override
	  public Object getValueAt(int row, int col) {
		  Symptom s = (Symptom) symptomsList.get(row);
		  if (col == 0) {
			  return s.getName();
		  }
		  else if (col == 1) {
			  return pacient.getWeight(s);
		  }
		  else {
			  return null;
		  }
		  
	  }
	}
