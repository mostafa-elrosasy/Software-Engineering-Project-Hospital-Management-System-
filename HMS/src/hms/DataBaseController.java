package hms;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DataBaseController {

    private ArrayList<Patient> patientsData = new ArrayList<Patient>();
    private ArrayList<User> usersData = new ArrayList<User>();
    private DataBaseBoundary DBB = new DataBaseBoundary();

    public void Remove_Patient(Patient P) {
        this.patientsData.remove(P);
    }

    public void Remove_User(String username) {
        for (User user : this.usersData) {
            if (user.getName() == username) {
                this.usersData.remove(user);
            }
        }
        this.DBB.Update_Users(usersData);
    }

    public void Send_Patients_Data(Patient p) {
        patientsData.add(p.ID, p);
        this.DBB.Update_Patients(patientsData);
    }

    public void Send_Users_Data(User U) {
        this.usersData.add(U);
        System.out.print(this.usersData.size());
        this.DBB.Update_Users(usersData);

    }

    public int Get_Size() {
        return patientsData.size();
    }

    public Patient Get_Patient(int n) {
        return patientsData.get(n);
    }

    public boolean Login(String username, String password) {
        System.out.print(this.usersData.size());
        for (User user : this.usersData) {
            if (user.getName().equals(username)&& user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
