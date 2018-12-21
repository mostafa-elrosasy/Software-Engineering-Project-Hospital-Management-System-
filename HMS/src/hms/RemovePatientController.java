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
public class RemovePatientController {
    DataBaseController DBC = HMS.getDBC();
    public void Remove_Patient(int n) {
        if (n < 0 || n > DBC.Get_Size()) {
            //patientinfo.setText("Wrong ID");
            JOptionPane.showMessageDialog(null, "Wrong ID");
        } else {
            DBC.Get_Patient(n).Remove_Patient();
        }
    }
}
