
package codes;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Dbconnect {
    public static Connection connect(){
        Connection conn=null;
        
        try{
            //Class.forName(com.mysql.jdbc.Driver);
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/tile","root","");
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Run xampp and active sql and apache before Run the programme");
        }
        return conn;
    }
        
}
