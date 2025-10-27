package observer;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Symptom;

import javax.swing.JLabel;

public class PacientObserverGUI extends JFrame implements Observer{

	private JPanel contentPane;
	private final JLabel symptomLabel = new JLabel("");

	/**
	 * Create the frame.
	 */
	public PacientObserverGUI() {
		setTitle("Pacient symptoms");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 100, 200, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		symptomLabel.setBounds(19, 38, 389, 199);
		contentPane.add(symptomLabel);
		symptomLabel.setText("Still no symptoms");
		this.setVisible(true);
	}
	public PacientObserverGUI(Observable obs) {
		this();
		obs.addObserver(this);
	}
	 @Override
	 public void update(Observable o, Object arg) {
		 Covid19Pacient p = (Covid19Pacient) o;
		 String s = "<html> Pacient: <b>" + p.getName() + "</b> <br>";
	     s += "Covid impact: <b>" + p.covidImpact() + "</b><br><br>";
	     s += " _____________________ <br> Symptoms: <br>";

	     Iterator<Symptom> i = p.getSymptoms().iterator();
	     while (i.hasNext()) {
	    	 Symptom sym = i.next();
	         s += " - " + sym.toString() + ", " + p.getWeight(sym) + "<br>";
	     }
	       s += "</html>";

	       symptomLabel.setText(s);
	    }

}
