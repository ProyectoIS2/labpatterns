package observer;

import domain.ISymptonFactory;
import domain.SymptonFactory;

public class Main {
    public static void main(String[] args) {

        ISymptonFactory factory = new SymptonFactory();

        // Primer paciente
        Covid19Pacient pacient1 = new Covid19Pacient("Aitor", 35, factory);
        new PacientObserverGUI(pacient1);   // GUI que observa al paciente 1
        new PacientSymptomGUI(pacient1);    // GUI para modificar síntomas del paciente 1

        // Segundo paciente
        Covid19Pacient pacient2 = new Covid19Pacient("Maddi", 28, factory);
        new PacientObserverGUI(pacient2);   // GUI que observa al paciente 2
        new PacientSymptomGUI(pacient2);    // GUI para modificar síntomas del paciente 2
        
    }
}
