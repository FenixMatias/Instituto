/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Alumno;

/**
 *
 * @author Matio_000
 */
public class AlumnoDAO {
    public boolean ingresaralumno(Alumno alu)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="insert into ALUMNO (rut, nombre, notapresentacion) values (?, ?, ?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, alu.getRut());
            ps.setString(2, alu.getNombre());
            ps.setDouble(3, alu.getNotapresentacion());
            resultado=ps.executeUpdate()==1;
            ps.close();  
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public Alumno buscaralumno(String rut)
    {
        Alumno alu=null;
        try {
            Connection con = Conexion.getConexion();
            String query="select * from ALUMNO where rut=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, rut);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                alu=new Alumno(rs.getString(1), rs.getString(2), rs.getDouble(3));
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alu;
    }
    
    public ArrayList<Alumno> mostrartodos()
    {
        ArrayList <Alumno> alumnos=new ArrayList<Alumno>();
        try {
            Connection con=Conexion.getConexion();
            String query="select * from ALUMNO";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            Alumno alu;
            while(rs.next())
            {
                alu=new Alumno(rs.getString(1), rs.getString(2), rs.getDouble(3));
                alumnos.add(alu);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }
    
    public boolean eliminarAlumno(String rut)
    {
        boolean resultado=false;
        
        try {
            Connection con=Conexion.getConexion();
            String query="delete from alumno where rut=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, rut);
            resultado=ps.executeUpdate()==1;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public boolean modificaralumno(Alumno alu)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="update alumno set nombre=?,notapresentacion=? where rut=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, alu.getNombre());
            ps.setDouble(2, alu.getNotapresentacion());
            ps.setString(3, alu.getRut());
            resultado=ps.executeUpdate()==1;
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
