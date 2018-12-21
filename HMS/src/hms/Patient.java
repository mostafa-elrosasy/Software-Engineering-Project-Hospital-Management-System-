/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

class Date {

    private int day, month, year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return "" + day + "/" + month + "/" + year;
    }

}

class Patient {

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
    DataBaseController DBC;

    public Patient(int ID, String Name, String Address, String Email, int Age, String Diagnosis, String Treatment, Date DOBirth, Date DOEntry, Date DOExit) {
        this.DBC = HMS.getDBC();
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
        this.Email = Email;
        this.Age = Age;
        this.Diagnosis = Diagnosis;
        this.Treatment = Treatment;
        this.DOBirth = DOBirth;
        this.DOEntry = DOEntry;
        this.DOExit = DOExit;
        this.Save_Patients_info();
    }

    public void Remove_Patient() {
        DBC.Remove_Patient(this);
    }

    public void Save_Patients_info() {
        DBC.Send_Patients_Data(this);
    }

    @Override
    public String toString() {
        String str = "the paatient's ID: " + ID + "\n the patient's Address: " + Address + "\n the patien'st Email: " + Email + "\n the patient's Age: " + Age
                + "\n the patients's Diagnosis: " + Diagnosis + "\n the treatment is: " + Treatment + "\n date of birth: " + DOBirth.toString() + "\n the date of entry: "
                + DOEntry.toString() + "\n the date of exit: " + DOExit.toString();
        return str;
    }
}
