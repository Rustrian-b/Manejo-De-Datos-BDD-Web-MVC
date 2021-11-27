
package Modelo;


import java.util.Date;

/**
 *
 * @author Ericksson Morales
 */
public class ClsEstudiante {

    public ClsEstudiante() {
    }
    
    public ClsEstudiante(String vCarnet, String vNombre, java.sql.Date FechaREG) {
        this.vCarnet = vCarnet;
        this.vNombre = vNombre;
        this.FechaREG = FechaREG;
    }
    
    Date FechaRegistro = new Date();
    String vCarnet, vNombre;
    java.sql.Date FechaREG;

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public String getvCarnet() {
        return vCarnet;
    }

    public void setvCarnet(String vCarnet) {
        this.vCarnet = vCarnet;
    }

    public String getvNombre() {
        return vNombre;
    }

    public void setvNombre(String vNombre) {
        this.vNombre = vNombre;
    }

    public java.sql.Date getFechaREG() {
        return FechaREG;
    }

    public void setFechaREG(java.sql.Date FechaREG) {
        this.FechaREG = FechaREG;
    }

    
    
    
}
