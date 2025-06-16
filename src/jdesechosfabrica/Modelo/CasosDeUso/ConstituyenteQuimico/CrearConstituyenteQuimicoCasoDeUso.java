/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.CasosDeUso.ConstituyenteQuimico;

import java.util.ArrayList;
import java.util.List;
import jdesechosfabrica.Modelo.Dao.ConstituyenteQuimicoDao;
import jdesechosfabrica.Modelo.Dto.ConstituyenteQuimico.CrearConstituyenteQuimicPeticionDto;
import jdesechosfabrica.Modelo.Dto.ConstituyenteQuimico.CrearConstituyenteQuimicoRespuestaDto;
import jdesechosfabrica.Modelo.Entidades.ConstituyenteQuimico;

/**
 *
 * @author HP
 */
public class CrearConstituyenteQuimicoCasoDeUso {

    private final ConstituyenteQuimicoDao constituyenteDao;

    public CrearConstituyenteQuimicoCasoDeUso(ConstituyenteQuimicoDao constituyenteDao) {
        this.constituyenteDao = constituyenteDao;
    }

    public CrearConstituyenteQuimicoRespuestaDto procesar(CrearConstituyenteQuimicPeticionDto peticion) throws Exception {
        ConstituyenteQuimico constituyente = new ConstituyenteQuimico(peticion.getTipoConstituyente(), peticion.getNombre());
        try {

            constituyenteDao.guardar(constituyente);
            List<Integer> residuosIds = new ArrayList<>();
            if (constituyente.getResiduos() != null) {
                for (var residuo : constituyente.getResiduos()) {
                    residuosIds.add(residuo.getId());
                }
            }

            return new CrearConstituyenteQuimicoRespuestaDto(
                    constituyente.getId(),
                    constituyente.getTipoConstituyente(),
                    constituyente.getNombre(),
                    residuosIds
            );
        } catch (Exception error) {
            var mensaje = "Error al crear el constituyente \n" + error.getMessage();
            throw new Exception(mensaje);
        }
    }
}
