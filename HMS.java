package software;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author mostafa
 */

public class HMS extends JFrame{
        
        private String ID;
        private String Name;
        private String Address;
        private String Email;
        private String Age;
        private String IDS;
        private String Disease;
        private String Treatment;
        private String DOBirth;
        private String DOEntry;
        private String DOExit;
        private int [] intdays=new int[3];
        private int [] intmonths=new int [3];
        private int [] intyears=new int[3];
    
        private JLabel namelbl =new JLabel("Name");
        private JLabel IDlbl =new JLabel("ID");
        private JLabel addresslbl =new JLabel("Address");
        private JLabel emaillbl =new JLabel("Email");
        private JLabel agelbl =new JLabel("Age");
        private JLabel searchlbl =new JLabel("Enter the patient's ID:");
        private JLabel datelbl =new JLabel("Date");
        private JLabel diseaselbl =new JLabel("Disease");
        private JLabel treatmentlbl =new JLabel("Treatment");
        private JLabel birthlbl =new JLabel("Date of Birth");
        private JLabel entrylbl =new JLabel("Date of Entry");
        private JLabel exitlbl =new JLabel("Date of Exit");
        
        private JTextField nametxt =new JTextField(64);
        private JTextField IDtxt =new JTextField(64);
        private JTextField addresstxt =new JTextField(64);
        private JTextField emailtxt =new JTextField(64);
        private JTextField agetxt =new JTextField(64);
        private JTextField IDsearchtxt = new JTextField(64);
        private JTextField diseasetxt = new JTextField(64);
        private JTextField treatmenttxt =new JTextField(64);
        private JTextField DOBirthtxt = new JTextField(64);
        private JTextField DOEntrytxt = new JTextField(64);
        private JTextField DOExittxt =new JTextField(64);
        
        private JComboBox[] day = new JComboBox[3];
        private JComboBox[]  month = new JComboBox[3];
        private JComboBox[]  year = new JComboBox[3];
        
        private JTextArea patientinfo = new JTextArea();
        
        private JButton insert = new JButton("insert a patient");
        private JButton search = new JButton("Search");
        private JButton edit = new JButton("Edit");
        private JButton remove = new JButton("Remove");
        private JButton show =new JButton("Show All Data");
        
        private patient[] p = new patient[1000];
        

    public HMS(){
        init();
    }

    private void init() {
        this.setLayout(null);
        this.setSize(600,600);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setTitle("Patients Window");


        patientinfo.setLocation(350,310);
        patientinfo.setSize(200,200);
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
        
        diseaselbl.setLocation(10,260);
        diseaselbl.setSize(50,20);
        this.add(diseaselbl);
        
        treatmentlbl.setLocation(10,310);
        treatmentlbl.setSize(60,20);
        this.add(treatmentlbl);
        
        birthlbl.setLocation(10,360);
        birthlbl.setSize(100,20);
        this.add(birthlbl);
        
        entrylbl.setLocation(10,410);
        entrylbl.setSize(100,20);
        this.add(entrylbl);
        
        exitlbl.setLocation(10,460);
        exitlbl.setSize(100,20);
        this.add(exitlbl);
        
        searchlbl.setLocation(350, 10);
        searchlbl.setSize(200, 20);
        this.add(searchlbl);
       
//////////////////////////////////////////////////////////////////////// TextFields     
        nametxt.setLocation(90,10);
        nametxt.setSize(200,20);
        this.add(nametxt);
        
        IDtxt.setLocation(90,60);
        IDtxt.setSize(200,20);
        this.add(IDtxt);
        
        addresstxt.setLocation(90,110);
        addresstxt.setSize(200,20);
        this.add(addresstxt);
        
        agetxt.setLocation(90,160);
        agetxt.setSize(200,20);
        this.add(agetxt);
        
        emailtxt.setLocation(90,210);
        emailtxt.setSize(200,20);
        this.add(emailtxt);
        
        diseasetxt.setLocation(90,260);
        diseasetxt.setSize(200,20);
        this.add(diseasetxt);
        
        treatmenttxt.setLocation(90,310);
        treatmenttxt.setSize(200,20);
        this.add(treatmenttxt);
        
        IDsearchtxt.setLocation(350,60);
        IDsearchtxt.setSize(200,20);
        this.add(IDsearchtxt);
        
        DOBirthtxt.setLocation(90,360);
        DOBirthtxt.setSize(200,20);
        this.add(DOBirthtxt);
        
        DOEntrytxt.setLocation(90,410);
        DOEntrytxt.setSize(200,20);
        this.add(DOEntrytxt);
        
        DOExittxt.setLocation(90,460);
        DOExittxt.setSize(200,20);
        this.add(DOExittxt);
////////////////////////////////////////////////////////////////////// Buttons
        insert.setLocation(90,510);
        insert.setSize(200,20);
        this.add(insert);
        insert.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ID= IDtxt.getText();
                 try{
                 int id =Integer.parseInt(IDtxt.getText());
                 
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Please enter a number in ID");
                }
                Age=agetxt.getText();
                Name=nametxt.getText();
                Address=addresstxt.getText();
                Email=emailtxt.getText();
                Disease = diseasetxt.getText();
                Treatment=treatmenttxt.getText();
                DOBirth=DOBirthtxt.getText();
                DOEntry=DOEntrytxt.getText();
                DOExit=DOExittxt.getText();
                String [] patient ={ID,Age,Name,Address,Email,Disease,Treatment,DOBirth,DOEntry,DOExit};
                try {
                    Write(patient);
                } catch (IOException ex) {
                    Logger.getLogger(System.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        search.setLocation(350,110);
        search.setSize(200,20);
        this.add(search);
        
        edit.setLocation(350,160);
        edit.setSize(200,20);
        this.add(edit);
        
        remove.setLocation(350,210);
        remove.setSize(200,20);
        this.add(remove);
        
        show.setLocation(350,260);
        show.setSize(200,20);
        this.add(show);
/////////////////////////////////////////////////////////////////////  Combo Boxes
  /*      String[] days= new String[30];
            for(int j =0;j<30;j++){
                days[j]=""+(j+1);
            }
        for (int i = 0; i < 3; i++) {
            day[i] = new JComboBox(days);
            day[i].setBounds(100, 360 + 50 * i, 50, 20);
            day[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    intdays[i]=(int)day[i].getSelectedItem();
                }
            });
            this.add(day[i]);
        }
        String[] months= new String[12];
            for(int j =0;j<12;j++){
                months[j]=""+(j+1);
            }
        for(int i=0;i<3;i++){
            month[i]=new JComboBox(months);
            month[i].setBounds(150,360+50*i,50,20);
            this.add(month[i]);
        }
        String[] years= new String[250];
            for(int j =1900;j<2090;j++){
                years[j-1900]=""+(j+1);
            }
        for(int i=0;i<3;i++){
            year[i]=new JComboBox(years);
            year[i].setBounds(200,360+50*i,100,20);
            this.add(year[i]);
        }*/
    }
    public void Write(String [] patient) throws IOException{
        String csv = "C:\\Users\\mosta\\Desktop\\software\\patients.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv,true));
        writer.writeNext(patient);
        writer.close();
    }
    public void Read() throws FileNotFoundException, IOException {
        String csvFilename = "C:\\Users\\mosta\\Desktop\\software\\patients.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        String[] row = null;
        while ((row = csvReader.readNext()) != null) {
            System.out.println(row[0]
                    + " , " + row[1]
                    + " ,  " + row[2]);
        }
//...
        csvReader.close();
    }
    
}

/*class Date{
       private int day,month,year;
       public Date(int day,int month,int year){
           this.day=day;
           this.month=month;
           this.year=year;
       }
   }
class patient{
       private String name;
       private int zipCode;
       private String address;
       private int ID;
       private int phoneNumber;
       private String email;
       private Date DOB;
       private Date Entry;
       private Date Exit;
       public patient(String name,int zipcode,String address,int ID,int phonenumber,String email,Date DOB,Date Entry,Date Exit){
           
           this.ID=ID;
           this.address=address;
           this.email=email;
           this.name=name;
           this.zipCode=zipcode;
           this.phoneNumber=phonenumber;
           this.DOB=DOB;
       }
       public String toString(){
           return "name: "+this.name+"\n+"+"ID: "+this.ID+"\n"+"address: "+this.address+"\n"+"email: "+this.email+"\n"+"ZipCode: "+this.zipCode+"\n"+
                   "PhoneNumber: "+this.phoneNumber+"\n";
       }
       public String getname(){
           return this.name;
       }
       
   }*/
