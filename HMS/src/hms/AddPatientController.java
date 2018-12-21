/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

public class AddPatientController {
    public void Create_Patient(int ID, String Name, String Address, String Email, int Age, String Diagnosis, String Treatment, Date DOBirth, Date DOEntry, Date DOExit){
        Patient P = new Patient(ID,Name,Address,Email,Age,Diagnosis,Treatment,DOBirth,DOEntry,DOExit);
    }
}
