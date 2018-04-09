
package software;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import javax.swing.*;
/**
 *
 * @author mostafa
 */
public class AdminPage extends JFrame {
    private JLabel removelbl =new JLabel("ID");
    private JLabel IDlbl =new JLabel("ID");
    private JLabel passwordlbl =new JLabel("Password");
    
    private JTextField removetxt =new JTextField(64);
    private JTextField IDtxt =new JTextField(64);
    private JTextField passwordtxt =new JTextField(64);
    
    private JButton Remove = new JButton("Remove the user");
    private JButton Add = new JButton("Search");
    
    public AdminPage(){
        init();
    }
    private void init(){
        this.setSize(350,300);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setTitle("Admin Window");
/////////////////////////////////////////////////////Labels        
        removelbl.setBounds(10,10 ,50, 20);
        this.add(removelbl);
        
        IDlbl.setBounds(10,100 ,50, 20);
        this.add(IDlbl);
        
        passwordlbl.setBounds(10,150 ,60, 20);
        this.add(passwordlbl);
////////////////////////////////////////////////////TextFields
        removetxt.setBounds(80, 10, 200, 20);
        this.add(removetxt);
        
        IDtxt.setBounds(80, 100, 200, 20);
        this.add(IDtxt);
        
        passwordtxt.setBounds(80, 150, 200, 20);
        this.add(passwordtxt);
///////////////////////////////////////////////////Buttons
        Remove.setBounds(80,60,200,20);
        this.add(Remove);
        
        Add.setBounds(80,200,200,20);
        this.add(Add);
    }
}
