package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejoBDD 
{
    static Connection c;
    static Statement s;
    static ResultSet r;
    
    public static void conectar()
    {
        String user = "PROGRA2";
        String password = "umg123";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c = DriverManager.getConnection(url, user, password);
            s = c.createStatement();
        }catch(SQLException e)
        {
            System.out.println("Error al conectar a la BD");
        }catch(ClassNotFoundException ex)
        {
            Logger.getLogger(ManejoBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cerrar()
    {
        try
        {
            s.close();
            c.close();
        }catch(SQLException e)
        {
            System.out.println("Error al cerrar Base de Datos");
        }
    }
    
    public static void update(String pInstruccion)
    {
        try
        {
            conectar();
            s.executeQuery(pInstruccion);            
        }catch(SQLException e)
        {
            System.out.println("Error al Actualizar BDD");            
        }
    }
    
    public int Insertar(String pInstruccion)
    {        
        int vResult = 0;
        try
        {
            conectar();
            s.executeQuery(pInstruccion);
            vResult = 1;
        }catch(SQLException e)
        {
            System.out.println("Error al realizar inseción en la BD");
            vResult = 0;
        }
        
        return vResult;
    }
    
    public int loggin(String vUsuario, String vPassword)
    {
        int result = 0;
            
        try
        {
            conectar();
            String Query = "SELECT Usuario FROM USUARIOS WHERE USUARIO = '" + vUsuario + "' AND PASS = '" + vPassword + "'";
            System.out.println(Query);
            ResultSet resultado = s.executeQuery(Query);
            if(resultado!=null && resultado.next())
            {
                result = 1;
                System.out.println("Loggin exitoso");
            }else
            {
                System.out.println("Loggin fallido");
            }                                
            }catch(SQLException Ex)
            {
                System.out.println(Ex.getMessage());
            }                        
        return result;
    }
    
    public static ArrayList usuariosRegistrados()
    {
        ArrayList<ClsUsuarios> lista = new ArrayList();
        String vSQL = "select usuario from usuarios";
        conectar();
        
        try
        {
            s = c.prepareStatement(vSQL);
            r = s.executeQuery(vSQL);
            
            while(r.next())
            {
                ClsUsuarios u = new ClsUsuarios();
                u.setvUsuario(r.getString(1));
                lista.add(u);
            }
        } catch(SQLException ex)
        {
            Logger.getLogger(ManejoBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
            
    
    public static ArrayList estudiantesRegistrados()
    {
        ArrayList<ClsEstudiante> ListaE = new ArrayList();
        String Query = "select Carnet, Nombre from Estudiantes order by Fecha_Ing";
        conectar();
        
        try
        {
            s = c.prepareStatement(Query);
            r = s.executeQuery(Query);
            
            while(r.next())
            {
                ClsEstudiante e = new ClsEstudiante();
                e.setvCarnet(r.getString(1));
                e.setvNombre(r.getString(2));
                ListaE.add(e);
            }
        } catch(SQLException ex)
        {
            Logger.getLogger(ManejoBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListaE;
    }
           
    public static ArrayList proximoCola()
    {
        ArrayList<ClsEstudiante> Lista = new ArrayList();
        String Query = "select Carnet, Nombre, Fecha_ing from Estudiantes where Rownum = 1 and Cola = 'N' order by Fecha_Ing";
        conectar();
            
        try
        {
            s = c.prepareStatement(Query);
            r = s.executeQuery(Query);
                
            while(r.next())
            {
                ClsEstudiante e = new ClsEstudiante();
                e.setvCarnet(r.getString(1));
                e.setvNombre(r.getString(2));
                Lista.add(e);
            }
        } catch(SQLException ex)
        {
            Logger.getLogger(ManejoBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return Lista;
    }        
    
    public static ArrayList colasRegistradas()
    {
        ArrayList<ClsCola> lista = new ArrayList();
        String Query = "select Carnet from cola_Estudiantes where ESTATUS = 'NO INSCRITO' order by Fecha_adicion";
        conectar();
            
        try
        {
            s = c.prepareStatement(Query);
            r = s.executeQuery(Query);
                
            while(r.next())
            {
                ClsCola e = new ClsCola();
                e.setvCarnet(r.getString(1));
                lista.add(e);
            }
        } catch(SQLException ex)
        {
            Logger.getLogger(ManejoBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public static ArrayList inscripciones()
    {
        ArrayList<ClsInscrito> lista = new ArrayList();
        String Query = "select Carnet from Inscripcion_estudiantes order by FECHA_ADICION";
        conectar();
        
        try
        {
            s = c.prepareStatement(Query);
            r = s.executeQuery(Query);
            
            while(r.next())
            {
                ClsInscrito e = new ClsInscrito();
                e.setCarnet(r.getString(1));                
                lista.add(e);
            }
        } catch(SQLException ex)
        {
            Logger.getLogger(ManejoBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
