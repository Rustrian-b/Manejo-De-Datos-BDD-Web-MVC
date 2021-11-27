package Modelo;

import java.util.Date;

public class registroDeUsuarios 
{
    public int registro(String vUser, String vPassword)
    {     
        int vResult = 0;
        String vInstruccion="";
        vInstruccion = "insert into usuarios (usuario, pass) values ('"+ vUser + "','" + vPassword + "')";
        //ManejoBDD.Insertar(vInstruccion);
        ManejoBDD m = new ManejoBDD();
        
        int vResultado = m.Insertar(vInstruccion);
        if(vResultado == 1)
        {
            vResult = 1;
        }else
        {
            vResult = 0;
        }
           
        return vResult;
    }
    
    public int Estudiante(String vCarnet, String vNombre, String FechaNacimiento){
        
        int vResult = 0;
        String vQuery;
        
        vQuery = "INSERT INTO ESTUDIANTES (CARNET, NOMBRE, FECHA_NAC, COLA) VALUES ('" + vCarnet + "', '" + vNombre + "', to_date ('" + FechaNacimiento + "','dd,mm,yyyy'), 'N')";
        
        ManejoBDD manejo = new ManejoBDD();
        
        int vResultado = manejo.Insertar(vQuery);
        if(vResultado == 1)
        {
            vResult = 1;
        }else
        {
            vResult = 0;
        }
           
        return vResult;
        
    }
    
    public int Cola(String vCarnet)
    {
        int vResult = 0;
        String vQuery;
        
        vQuery = "INSERT INTO COLA_ESTUDIANTES (CARNET, ESTATUS) VALUES ('"+ vCarnet + "', 'NO INSCRITO')";
        
        ManejoBDD manejo = new ManejoBDD();
        
        int vResultado = manejo.Insertar(vQuery);
        if(vResultado == 1)
        {
            vResult = 1;
        }else
        {
            vResult = 0;
        }
        
        vQuery = "UPDATE ESTUDIANTES SET COLA = 'Y' WHERE CARNET = '" + vCarnet + "' ";
        
        manejo.update(vQuery);
        
        return vResult;
    }
    
        public int Inscripcion(String vCarnet)
    {
        int vResult = 0;
        String vQuery;
        
        vQuery = "INSERT INTO INSCRIPCION_ESTUDIANTES (CARNET) VALUES ('"+ vCarnet + "')";
        
        ManejoBDD manejo = new ManejoBDD();
        
        int vResultado = manejo.Insertar(vQuery);
        if(vResultado == 1)
        {
            vResult = 1;
        }else
        {
            vResult = 0;
        }
        
        vQuery = "UPDATE COLA_ESTUDIANTES SET ESTATUS = 'INSCRITO' WHERE CARNET = '" + vCarnet + "' ";
        
        manejo.update(vQuery);
        
        return vResult;
    }
}
