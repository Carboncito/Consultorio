package menu.proyecto;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/";

    public Conectar() {
        conn = null;
        try{
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url,user, password);
            if (conn != null) {
                System.out.println("Conección correcta");
                
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar" + e);
        }
    }
    /*
    public void MySQLConnection(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    //Nos conectamos a la base
    public Connection getConnection(){
        return conn;
    }
    //Desconectar de la base de datos
    public void desconectar(){
        conn = null;
        if (conn == null) {
            System.out.println("Conección terminada");
        }
    }
}
