package mysql_estetica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MySQL {
    static Connection Conexion;
 
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
 
    public void closeConnection() {
        try {
            Conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void createDB(String name) {
        try {
            String Query = "CREATE DATABASE " + name;
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            MySQLConnection("root", "", name);
            JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void createTable(String name, String campos) {
        try {
            String Query = "CREATE TABLE " + name + campos;
            JOptionPane.showMessageDialog(null, "Se ha creado la base de tabla " + name + " de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
public void insertDataClientes(String table_name,String ID_Clientes, String Nombre_CL, String Domicilio_CL,
            String Colonia_CL, String CodigoPostal_CL,String Telefono_CL,String Email) {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
                    + "\"" + ID_Clientes + "\", "
                    + "\"" + Nombre_CL + "\", "
                    + "\"" + Domicilio_CL + "\", "
                    + "\"" + Colonia_CL + "\", "
                    + "\"" + CodigoPostal_CL + "\", "
                    + "\"" + Telefono_CL + "\", "             
                    + "\"" + Email + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }     
    }

    public void insertDataEmpleados(String table_name, String ID_Empleado, String Nombre_Emp, String Apellido_Emp,
            String Domicilio_Emp, String Telefono_Emp, String Email_Emp) {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
                    + "\"" + ID_Empleado + "\", "
                    + "\"" + Nombre_Emp + "\", "
                    + "\"" + Apellido_Emp + "\", "
                    + "\"" + Domicilio_Emp + "\", "
                    + "\"" + Telefono_Emp + "\")"
                    + "\"" + Email_Emp + "\", ";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
            JOptionPane.showMessageDialog(null, ex);
        }
     
    }
        
    public void insertDatapedidos(String table_name,String ID_Pedidos , String ID_Clientes, String ID_Productos2, String ID_Empleados2, String Fecha2, String Piezas,
            String Total,String Precio_Total, String jComboBox1) {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
                    + "\"" + ID_Pedidos + "\", "
                    + "\"" + ID_Clientes + "\", "
                    + "\"" + ID_Productos2 + "\", "
                    + "\"" + ID_Empleados2 + "\", "
                    + "\"" + Fecha2 + "\", "
                    + "\"" + Piezas + "\", "
                    + "\"" + Total + "\", "
                    + "\"" + Precio_Total + "\", "
                    + "\"" + jComboBox1 + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }      
    }
    public void insertDataproductos(String table_name, String ID_Productos, String Nombre_Prod,String Existencia_prod,String FechaCaducidad_Prod,
            String Descripcion_Prod,String Precio_Prod,String Precio_Producto,String ID_Provedores) {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
                    + "\"" + ID_Productos + "\", "
                    + "\"" + Nombre_Prod + "\", "
                    + "\"" + Precio_Prod + "\", "
                    + "\"" + Existencia_prod + "\", "
                    + "\"" + FechaCaducidad_Prod + "\", "
                    + "\"" + Descripcion_Prod + "\", "
                    + "\"" + Precio_Producto + "\", "
                    + "\"" + ID_Provedores + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }      
    }
    public void insertDataProvedores(String table_name, String ID_Provedores, String Domicilio_Prov, String Telefono_Prov,
            String Email_Prov) {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
                    + "\"" + ID_Provedores + "\", "
                    + "\"" + Domicilio_Prov + "\", "
                    + "\"" + Telefono_Prov + "\", "
                    + "\"" + Email_Prov + "\", ";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }      
    }
 
 public void getValuesClientes(String table_name) {
        try {
            String Query = "SELECT * FROM " + table_name;
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("idClientes") + " "
                        + "Nombre: " + resultSet.getString("nomcl") + " " 
                        + "Domicilio: " + resultSet.getString("domicl") + " "
                        + "Colonia: " + resultSet.getString("colocl") + " "
                        + "CP: " + resultSet.getString("codposcl") + " "
                        + "Telefono: " + resultSet.getString("telcl") + " "
                        + "email: " + resultSet.getString("email"));
            }
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }
 public void getValuesEmpleados(String table_name) {
        try {
            String Query = "SELECT * FROM " + table_name;
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("idEmpleados") + " "
                        + "Nombre: " + resultSet.getString("nomemp") + " " 
                        + "Apellidos: " + resultSet.getString("apelliemp") + " "
                        + "Domicilio: " + resultSet.getString("domemp") + " "
                        + "Telefono: " + resultSet.getString("telemp") + " "
                        + "Email: " + resultSet.getString("email"));
            }
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }
 public void getValuesPedidos(String table_name) {
        try {
            String Query = "SELECT * FROM " + table_name;
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("idPedidos") + " "
                        + "ID de Clientes: " + resultSet.getString("idClientes") + " " 
                        + "ID de Productos: " + resultSet.getString("idProductos-Tratamientos") + " "
                        + "ID de Empleados: " + resultSet.getString("idEmpleados") + " "
                        + "Fecha: " + resultSet.getString("fecha") + " "
                        + "Piezas: " + resultSet.getString("piezas") + " "
                        + "Total: " + resultSet.getString("total") + " "
                        + "Forma de Pago: " + resultSet.getString("formapag") + " "
                        + "Precio: " + resultSet.getString("precio"));
            }
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }
 public void getValuesProductos(String table_name) {
        try {
            String Query = "SELECT * FROM " + table_name;
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("idProductos-Tratamientos") + " "
                        + "Nombre: " + resultSet.getString("nomprod") + " " 
                        + "Precio: " + resultSet.getString("precioprod") + " "
                        + "Existencia: " + resultSet.getString("exisprod") + " "
                        + "Fecha: " + resultSet.getString("fechacad") + " "
                        + "Descripcion: " + resultSet.getString("descripcion") + " "
                        + "Precio: " + resultSet.getString("precio") + " "
                        + "ID de Provedores: " + resultSet.getString("idProvedores"));
            }
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }
 public void getValuesProvedores(String table_name) {
        try {
            String Query = "SELECT * FROM " + table_name;
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("idProvedores") + " "
                        + "Domicilio: " + resultSet.getString("domicilio") + " " 
                        + "Telefono: " + resultSet.getString("tel") + " "
                        + "Email: " + resultSet.getString("email"));
            }
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }
    public void deleteRecord(String table_name, String campo, String id) {
        try {
            String Query = "DELETE FROM " + table_name + " WHERE "+campo+" = \"" + id + "\"";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");            
        }
    }
}
