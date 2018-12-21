/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import javax.swing.JOptionPane;

/**
 *
 * @author mosta
 */
public class EditPatientController {

    DataBaseController DBC = HMS.getDBC();

    public Patient Edit_Patient(int n) {
        if (n < 0 || n > DBC.Get_Size()) {
            //patientinfo.setText("Wrong ID");
            JOptionPane.showMessageDialog(null, "Wrong ID");
            return null;
        }else
            return DBC.Get_Patient(n);
    }
}
