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
public class SearchPatientController {

    DataBaseController DBC = HMS.getDBC();

    public String Search_Patient(int n) {
        if (n < 0 || n > DBC.Get_Size()) {
            //patientinfo.setText("Wrong ID");
            JOptionPane.showMessageDialog(null, "Wrong ID");
        }
        if (DBC.Get_Size() == 0) {
            //patientinfo.setText("There are no patients");
            JOptionPane.showMessageDialog(null, "There are no patients");
        } else {
            return DBC.Get_Patient(n).toString();
        }

        return "error";
    }
}
