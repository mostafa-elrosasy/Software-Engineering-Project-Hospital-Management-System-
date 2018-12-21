package hms;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import javax.swing.*;

/**
 *
 * @author mostafa
 */
public class AdminPage extends JFrame {

    private JLabel removelbl = new JLabel("ID");
    private JLabel IDlbl = new JLabel("ID");
    private JLabel passwordlbl = new JLabel("Password");

    private JTextField removetxt = new JTextField(64);
    private JTextField IDtxt = new JTextField(64);
    private JPasswordField passwordtxt = new JPasswordField(64);

    private JButton Remove = new JButton("Remove the admin");
    private JButton Add = new JButton("Add the admin");
    private JButton back = new JButton("Back to the main menu");

    public AdminPage() {
        init();
    }

    private void init() {
        this.setSize(350, 300);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setTitle("Admin Window");
/////////////////////////////////////////////////////Labels        
        removelbl.setBounds(10, 10, 50, 20);
        this.add(removelbl);

        IDlbl.setBounds(10, 100, 50, 20);
        this.add(IDlbl);

        passwordlbl.setBounds(10, 150, 60, 20);
        this.add(passwordlbl);
////////////////////////////////////////////////////TextFields
        removetxt.setBounds(80, 10, 200, 20);
        this.add(removetxt);

        IDtxt.setBounds(80, 100, 200, 20);
        this.add(IDtxt);

        passwordtxt.setBounds(80, 150, 200, 20);
        this.add(passwordtxt);
///////////////////////////////////////////////////Buttons
        Remove.setBounds(80, 60, 200, 20);
        this.add(Remove);
        Remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoveUserController RemoveUC = new RemoveUserController();
                String username = removetxt.getText();
                RemoveUC.RemoveUser(username);
            }
        });

        Add.setBounds(80, 200, 200, 20);
        this.add(Add);
        Add.addActionListener(new ActionListener() {
            String username;
            String password;

            public void actionPerformed(ActionEvent e) {
                AddUserController AddUC = new AddUserController();
                username = IDtxt.getText();
                password = passwordtxt.getText();
                AddUC.Create_User(username, password);
            }
        });

        back.setBounds(80, 240, 200, 20);
        this.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPage P = new mainPage();
                close();
                P.setVisible(true);
            }
        });
    }

    public void close() {
        this.dispose();
    }
}
