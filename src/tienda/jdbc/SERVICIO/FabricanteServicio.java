/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.jdbc.SERVICIO;

import tienda.jdbc.ENTIDAD.Fabricante;
import tienda.jdbc.PERSISTENCIA.FabricanteDAO;

/**
 *
 * @author Fabi
 */
public class FabricanteServicio {
    
private final FabricanteDAO dao2;

    public FabricanteServicio() {
        this.dao2 = new FabricanteDAO();
    }

    
public void crarProducto(int codigo,String nombre) throws Exception {

        try {
            //Validamos
            if (codigo == 0 ) {
                throw new Exception("Debe indicar el codigo del fabricante");
            }
            
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }
            

            //Creamos el fabricante
            Fabricante f = new Fabricante();
           
            f.setCodigo(codigo);
            f.setNombre(nombre);
           
            dao2.guardarProducto(f);
        } catch (Exception e) {
            throw e;
        }
    
}
}
