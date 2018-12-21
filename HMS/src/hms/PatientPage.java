package hms;

//import au.com.bytecode.opencsv.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author mostafa
 */
public class PatientPage extends JFrame {

    int ID;
    String Name;
    String Address;
    String Email;
    int Age;
    String Diagnosis;
    String Treatment;
    Date DOBirth;
    Date DOEntry;
    Date DOExit;
    AddPatientController AddPC = new AddPatientController();
    SearchPatientController SearchPC = new SearchPatientController();
    EditPatientController EditPC = new EditPatientController();

    private JLabel namelbl = new JLabel("Name");
    private JLabel IDlbl = new JLabel("ID");
    private JLabel addresslbl = new JLabel("Address");
    private JLabel emaillbl = new JLabel("Email");
    private JLabel agelbl = new JLabel("Age");
    private JLabel searchlbl = new JLabel("Enter the patient's ID:");
    private JLabel datelbl = new JLabel("Date");
    private JLabel diagnosislbl = new JLabel("Diagnosis");
    private JLabel treatmentlbl = new JLabel("Treatment");
    private JLabel birthlbl = new JLabel("Date of Birth");
    private JLabel entrylbl = new JLabel("Date of Entry");
    private JLabel exitlbl = new JLabel("Date of Exit");

    private JTextField nametxt = new JTextField(64);
    private JTextField IDtxt = new JTextField(64);
    private JTextField addresstxt = new JTextField(64);
    private JTextField emailtxt = new JTextField(64);
    private JTextField agetxt = new JTextField(64);
    private JTextField IDsearchtxt = new JTextField(64);
    private JTextField diagnosistxt = new JTextField(64);
    private JTextField treatmenttxt = new JTextField(64);

    private JComboBox[] day = new JComboBox[3];
    private JComboBox[] month = new JComboBox[3];
    private JComboBox[] year = new JComboBox[3];

    private JTextArea patientinfo = new JTextArea();

    private JButton insert = new JButton("insert a patient");
    private JButton search = new JButton("Search");
    private JButton edit = new JButton("Edit");
    private JButton remove = new JButton("Remove");
    private JButton show = new JButton("Show All Data");
    private JButton back = new JButton("Back to the main menu");

    public PatientPage() {
        init();
    }

    private void init() {
        this.setLayout(null);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setTitle("Patients Window");

        patientinfo.setLocation(350, 310);
        patientinfo.setSize(200, 200);
        this.add(patientinfo);
//////////////////////////////////////////////////////////////////////// Labels        
        namelbl.setLocation(10, 10);
        namelbl.setSize(50, 20);
        this.add(namelbl);

        IDlbl.setLocation(10, 60);
        IDlbl.setSize(50, 20);
        this.add(IDlbl);

        agelbl.setLocation(10, 110);
        agelbl.setSize(50, 20);
        this.add(agelbl);

        addresslbl.setLocation(10, 160);
        addresslbl.setSize(50, 20);
        this.add(addresslbl);

        emaillbl.setLocation(10, 210);
        emaillbl.setSize(50, 20);
        this.add(emaillbl);

        diagnosislbl.setLocation(10, 260);
        diagnosislbl.setSize(60, 20);
        this.add(diagnosislbl);

        treatmentlbl.setLocation(10, 310);
        treatmentlbl.setSize(60, 20);
        this.add(treatmentlbl);

        birthlbl.setLocation(10, 360);
        birthlbl.setSize(100, 20);
        this.add(birthlbl);

        entrylbl.setLocation(10, 410);
        entrylbl.setSize(100, 20);
        this.add(entrylbl);

        exitlbl.setLocation(10, 460);
        exitlbl.setSize(100, 20);
        this.add(exitlbl);

        searchlbl.setLocation(350, 10);
        searchlbl.setSize(200, 20);
        this.add(searchlbl);

//////////////////////////////////////////////////////////////////////// TextFields     
        nametxt.setLocation(90, 10);
        nametxt.setSize(200, 20);
        this.add(nametxt);

        IDtxt.setLocation(90, 60);
        IDtxt.setSize(200, 20);
        this.add(IDtxt);

        addresstxt.setLocation(90, 160);
        addresstxt.setSize(200, 20);
        this.add(addresstxt);

        agetxt.setLocation(90, 110);
        agetxt.setSize(200, 20);
        this.add(agetxt);

        emailtxt.setLocation(90, 210);
        emailtxt.setSize(200, 20);
        this.add(emailtxt);

        diagnosistxt.setLocation(90, 260);
        diagnosistxt.setSize(200, 20);
        this.add(diagnosistxt);

        treatmenttxt.setLocation(90, 310);
        treatmenttxt.setSize(200, 20);
        this.add(treatmenttxt);

        IDsearchtxt.setLocation(350, 60);
        IDsearchtxt.setSize(200, 20);
        this.add(IDsearchtxt);

////////////////////////////////////////////////////////////////////// Buttons
        insert.setLocation(90, 510);
        insert.setSize(200, 20);
        this.add(insert);
        insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ID = Integer.parseInt(IDtxt.getText());
                    Name = nametxt.getText();
                    Address = addresstxt.getText();
                    Email = emailtxt.getText();
                    Age = Integer.parseInt(agetxt.getText());
                    Diagnosis = diagnosistxt.getText();
                    Treatment = treatmenttxt.getText();
                    DOBirth = new Date(Integer.parseInt(day[0].getSelectedItem().toString()), Integer.parseInt(month[0].getSelectedItem().toString()), Integer.parseInt(year[0].getSelectedItem().toString()));
                    DOEntry = new Date(Integer.parseInt(day[1].getSelectedItem().toString()), Integer.parseInt(month[1].getSelectedItem().toString()), Integer.parseInt(year[1].getSelectedItem().toString()));
                    DOExit = new Date(Integer.parseInt(day[2].getSelectedItem().toString()), Integer.parseInt(month[2].getSelectedItem().toString()), Integer.parseInt(year[2].getSelectedItem().toString()));

                    AddPC.Create_Patient(ID, Name, Address, Email, Age, Diagnosis, Treatment, DOBirth, DOEntry, DOExit);
                } catch (NumberFormatException n) {
                    //patientinfo.setText("The value of the age or the ID \n is wrong");
                    JOptionPane.showMessageDialog(null, "The value of the age or the ID \n is wrong");
                }
            }
        });

        search.setLocation(350, 135);
        search.setSize(200, 20);
        this.add(search);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(IDsearchtxt.getText());
                    patientinfo.setText(SearchPC.Search_Patient(n));

                } catch (NumberFormatException a) {
                    //patientinfo.setText("The ID value should be an integer");
                    JOptionPane.showMessageDialog(null, "The ID value should be an integer");
                }
            }
        });

        edit.setLocation(350, 190);
        edit.setSize(200, 20);
        this.add(edit);
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(IDsearchtxt.getText());
                    Patient P = EditPC.Edit_Patient(n);
                    IDtxt.setText(Integer.toString(P.ID));
                    nametxt.setText(P.Name);
                    addresstxt.setText(P.Address);
                    emailtxt.setText(P.Email);
                    agetxt.setText(Integer.toString(P.Age));
                    diagnosistxt.setText(P.Diagnosis);
                    treatmenttxt.setText(P.Treatment);
                } catch (NumberFormatException n) {
                    //patientinfo.setText("The ID value should be an integer");
                    JOptionPane.showMessageDialog(null, "The ID value should be an integer");

                }
            }
        });

        remove.setLocation(350, 245);
        remove.setSize(200, 20);
        this.add(remove);
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemovePatientController RemovePC = new RemovePatientController();
                try {
                    int n = Integer.parseInt(IDsearchtxt.getText());
                    RemovePC.Remove_Patient(n);

                } catch (NumberFormatException n) {
                    //patientinfo.setText("The ID value should be an integer");
                    JOptionPane.showMessageDialog(null, "The ID value should be an integer");

                }
            }
        });

        /*show.setLocation(350,260);
         show.setSize(200,20);
         this.add(show);
         show.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         String str = "";
         for (int i = 0; i < Software.patientsData.size(); i++) {
         str+=Software.patientsData.get(i).toString();
         }
         patientinfo.setText(str);
         }
         });*/
        back.setLocation(350, 540);
        back.setSize(200, 20);
        this.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPage P = new mainPage();
                close();
                P.setVisible(true);
            }
        });
/////////////////////////////////////////////////////////////////////  Combo Boxes
        String[] days = new String[30];
        for (int j = 0; j < 30; j++) {
            days[j] = "" + (j + 1);
        }
        for (int i = 0; i < 3; i++) {
            day[i] = new JComboBox(days);
            day[i].setBounds(100, 360 + 50 * i, 50, 20);

            this.add(day[i]);
        }
        String[] months = new String[12];
        for (int j = 0; j < 12; j++) {
            months[j] = "" + (j + 1);
        }
        for (int i = 0; i < 3; i++) {
            month[i] = new JComboBox(months);
            month[i].setBounds(150, 360 + 50 * i, 50, 20);
            this.add(month[i]);
        }
        String[] years = new String[250];
        for (int j = 1900; j < 2090; j++) {
            years[j - 1900] = "" + (j + 1);
        }
        for (int i = 0; i < 3; i++) {
            year[i] = new JComboBox(years);
            year[i].setBounds(200, 360 + 50 * i, 100, 20);
            this.add(year[i]);
        }
    }

    public void Write(String[] patient) throws IOException {
        String csv = "C:\\Users\\mosta\\Desktop\\software\\patients.csv";
        //CSVWriter writer = new CSVWriter(new FileWriter(csv,true));
        // writer.writeNext(patient);
        // writer.close();
    }

    public void Read() throws FileNotFoundException, IOException {
        String csvFilename = "C:\\Users\\mosta\\Desktop\\software\\patients.csv";
        // CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        String[] row = null;
        /* while ((row = csvReader.readNext()) != null) {
         System.out.println(row[0]
         + " , " + row[1]
         + " ,  " + row[2]);
         }
         //...
         csvReader.close();*/
    }

    public void close() {
        this.dispose();
    }

}
