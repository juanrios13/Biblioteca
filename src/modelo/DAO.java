package modelo;

import utilidades.*;
import java.sql.*;

public class DAO {
    ConexionBD con=new ConexionBD();
    SQLHelper sql=new SQLHelper();
    
    //Realizar metodos pertinentes y borrar lo que no sirve
    public String addBoleta(Boleta b) {
    	try {
            
            PreparedStatement stm= con.getCon().prepareStatement(sql.addBoleta(b));
            
            
            
       } catch (Exception e) {
           System.err.println("Error al guardar registro: "+e.getMessage());
       }finally{
           try {
               con.cerrarBD();
           } catch (Exception e) {
           }
       }
       return "Hubo un error, intente mas tarde";
   }//cerrar guardar
   
   
    }
    
    public String buscarLibro(String isbn) {
    	 try {
             
             PreparedStatement stm= con.getCon().prepareStatement(sql.buscarLibro(isbn));
             ResultSet rs=stm.executeQuery();
             
            
             
         } catch (Exception e) {
             System.err.println("Error al buscar registro: "+e.getMessage());
         }finally{
             try {
                 con.cerrarBD();
             } catch (Exception e) {
             }
         }
         return null;
     	}//cierro buscar 1 persona
    }
    
    public boolean prestarLibro(String isbn,String cedula) {
    	try {
            
            PreparedStatement stm= con.getCon().prepareStatement(sql.prestarLibro(isbn,cedula));
            ResultSet rs=stm.executeQuery();
            
           
            
        } catch (Exception e) {
            System.err.println("Error al prestar registro: "+e.getMessage());
        }finally{
            try {
                con.cerrarBD();
            } catch (Exception e) {
            }
        }
        return null;
    	}//cierro prestar
    }
    
    public boolean devolverLibro(String isbn,String cedula) {
try {
            
            PreparedStatement stm= con.getCon().prepareStatement(sql.devolverLibro(isbn,cedula));
            ResultSet rs=stm.executeQuery();
            
           
            
        } catch (Exception e) {
            System.err.println("Error al devolver registro: "+e.getMessage());
        }finally{
            try {
                con.cerrarBD();
            } catch (Exception e) {
            }
        }
        return null;
    	}//cierro prestar
    }

    
}
