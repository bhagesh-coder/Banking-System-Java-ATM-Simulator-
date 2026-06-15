package bank;
import java.sql.*;

public class conn {

    Connection c;
    static Statement s;

   public conn()
    {
        try {
            c=DriverManager.getConnection("jdbc:mysql:///bankingsystem","root","root");
            s=c.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
