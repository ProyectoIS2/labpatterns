package observer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Symptom;

public class PacientSymptomGUI extends JFrame {
    private JPanel contentPane;
    private JTextField weightField;
    private JComboBox<Symptom> symptomComboBox;
    private JLabel errorLabel;
    private JLabel lblPacient;
    private JLabel labelPacient;

    public PacientSymptomGUI(Covid19PacientObserver p) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSelectSymptom = new JLabel("Select Symptom");
        lblSelectSymptom.setBounds(32, 68, 100, 16);
        contentPane.add(lblSelectSymptom);

        symptomComboBox = new JComboBox<Symptom>();
        symptomComboBox.setBounds(195, 57, 192, 27);

        symptomComboBox.addItem(new Symptom("fiebre", 100, 5));
        symptomComboBox.addItem(new Symptom("tos seca", 100, 5));
        symptomComboBox.addItem(new Symptom("astenia", 100, 5));
        symptomComboBox.addItem(new Symptom("expectoracion", 100, 5));
        symptomComboBox.addItem(new Symptom("disnea", 100, 3));
        symptomComboBox.addItem(new Symptom("dolor de garganta", 100, 3));
        symptomComboBox.addItem(new Symptom("cefalea", 100, 3));
        symptomComboBox.addItem(new Symptom("mialgia", 100, 3));
        symptomComboBox.addItem(new Symptom("escalofríos", 100, 3));
        symptomComboBox.addItem(new Symptom("náuseas o vómitos", 100, 1));
        symptomComboBox.addItem(new Symptom("congestión nasal", 100, 1));
        symptomComboBox.addItem(new Symptom("diarrea", 100, 1));
        symptomComboBox.addItem(new Symptom("hemoptisis", 100, 1));
        symptomComboBox.addItem(new Symptom("congestión conjuntival", 100, 1));

        contentPane.add(symptomComboBox);

        JLabel lblSymptomWeight = new JLabel("Symptom weight");
        lblSymptomWeight.setBounds(32, 96, 125, 16);
        contentPane.add(lblSymptomWeight);

        weightField = new JTextField();
        weightField.setBounds(195, 91, 130, 26);
        contentPane.add(weightField);
        weightField.setColumns(10);

        JButton btnAddSymptom = new JButton("Add Symptom");
        btnAddSymptom.setBounds(88, 202, 117, 29);
        btnAddSymptom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText(" ");
                try {
                    int weight = Integer.parseInt(weightField.getText());
                    if (weight >= 1 && weight <= 3) {
                        Symptom selected = (Symptom) symptomComboBox.getSelectedItem();
                        if (selected != null) {
                            p.addSymptomByName(selected.getName(), weight);
                            System.out.println("Symptom added: " + selected.getName());
                        }
                    } else {
                        errorLabel.setText("ERROR: Weight must be between [1..3]");
                    }
                } catch (NumberFormatException ex) {
                    errorLabel.setText("ERROR: Weight must be a number");
                }
            }
        });
        contentPane.add(btnAddSymptom);

        JButton btnRemoveSymptom = new JButton("Remove Symptom");
        btnRemoveSymptom.setBounds(255, 202, 147, 29);
        btnRemoveSymptom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText(" ");
                Symptom selected = (Symptom) symptomComboBox.getSelectedItem();
                if (selected != null) {
                    p.removeSymptomByName(selected.getName());
                    System.out.println("Symptom removed: " + selected.getName());
                }
            }
        });
        contentPane.add(btnRemoveSymptom);

        errorLabel = new JLabel("");
        errorLabel.setBounds(117, 146, 238, 16);
        contentPane.add(errorLabel);

        lblPacient = new JLabel("Pacient:");
        lblPacient.setBounds(210, 17, 61, 16);
        contentPane.add(lblPacient);

        labelPacient = new JLabel();
        labelPacient.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        labelPacient.setBounds(271, 17, 131, 16);
        labelPacient.setText(p.getName());
        contentPane.add(labelPacient);

        this.setVisible(true);
    }
}
