/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.CasosDeUso.Productor;

import jdesechosfabrica.Modelo.Dao.ProductorDao;
import jdesechosfabrica.Modelo.Dto.Productor.CrearProductorPeticionDto;
import jdesechosfabrica.Modelo.Dto.Productor.CrearProductorRespuestaDto;
import jdesechosfabrica.Modelo.Entidades.Direccion;
import jdesechosfabrica.Modelo.Entidades.Productor;

/**
 *
 * @author HP
 */
public class CrearProductorCasoDeUso {

    private final ProductorDao productorDao;

    public CrearProductorCasoDeUso(ProductorDao productorDao) {
        this.productorDao = productorDao;
    }

    public CrearProductorRespuestaDto procesar(CrearProductorPeticionDto peticion) throws Exception {
        try {
            Direccion direccionProductor = new Direccion(
                    peticion.getPais(),
                    peticion.getCiudad(),
                    peticion.getBarrio(),
                    peticion.getCalle(),
                    peticion.getNumero()
            );
            Productor productor = new Productor(
                    peticion.getNombre(),
                    direccionProductor,
                    peticion.getTipoActividad()
            );

            productorDao.guardar(productor);

            return new CrearProductorRespuestaDto(
                    productor.getId(),
                    productor.getNombre(),
                    productor.getTipoActividad(),
                    productor.getDireccion().getPais(),
                    productor.getDireccion().getCiudad(),
                    productor.getDireccion().getBarrio(),
                    productor.getDireccion().getCalle(),
                    productor.getDireccion().getNumero()
            );
        } catch (Exception error) {
            var mensaje = "hubo un error al crear el productor\n" + error.getMessage();
            throw new Exception(mensaje);
        }
    }
}
