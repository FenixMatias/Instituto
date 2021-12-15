
package modelo;

public class Alumno {
    
    private String rut;
    private String nombre;
    private double notapresentacion;

    public Alumno(String rut, String nombre, double notapresentacion) {
        this.rut = rut;
        this.nombre = nombre;
        this.notapresentacion = notapresentacion;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotapresentacion() {
        return notapresentacion;
    }

    public void setNotapresentacion(double notapresentacion) {
        this.notapresentacion = notapresentacion;
    }
    
    public double notafinal(double notaexamen)
    {
        return (int)(notapresentacion*0.6+notaexamen*0.4);
    }
    
    
    public String situacion(double notaexamen)
    {
        if(notafinal(notaexamen)>=3.95)
            return "Aprobado";
        else
            return "Reprobado";
    } 
    
    public String toString()
    {
        return "\n|Rut: "+rut+" Nombre: "+nombre+" Nota presentación: "+notapresentacion+"|"; 
    }
    
    
}
