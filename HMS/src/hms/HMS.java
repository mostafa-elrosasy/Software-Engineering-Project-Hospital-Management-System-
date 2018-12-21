package hms;

/**
 *
 * @author mostafa
 */
public class HMS {

    private static DataBaseController DBC = new DataBaseController();
    
    public static void main(String[] args) {
        

        mainPage P = new mainPage();
        P.setVisible(true);
    }
    
    public static DataBaseController getDBC(){
        return DBC;
    }
    
}


