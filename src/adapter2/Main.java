package adapter2;

import domain.Covid19Pacient;
import domain.*;

public class Main {

	public static void main(String[] args) {
		ISymptonFactory symptonFactory = new SymptonFactory();
		Covid19Pacient pacient=new Covid19Pacient("aitor", 35, symptonFactory);
		
		pacient.addSymptomByName("disnea", 2);
		pacient.addSymptomByName("cefalea", 1);
		pacient.addSymptomByName("astenia", 3);
		
		ShowPacientTableGUI gui=new ShowPacientTableGUI(pacient);
		gui.setPreferredSize(
			      new java.awt.Dimension(300, 200));
		gui.setVisible(true);


	}

}
