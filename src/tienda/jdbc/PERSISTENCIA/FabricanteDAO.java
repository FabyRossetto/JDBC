/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.jdbc.PERSISTENCIA;

import tienda.jdbc.ENTIDAD.Fabricante;

/**
 *
 * @author Fabi
 */
public class FabricanteDAO extends DAO{
    public void guardarProducto(Fabricante f) throws Exception {
        try {
            if (f == null) {
                throw new Exception("Debe indicar un fabricante");
            }

            String sql = "INSERT INTO FABRICANTE (codigo,nombre)"
                    + "VALUES ( '" + f.getCodigo() + "' , '" + f.getNombre() + "' );";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
}
