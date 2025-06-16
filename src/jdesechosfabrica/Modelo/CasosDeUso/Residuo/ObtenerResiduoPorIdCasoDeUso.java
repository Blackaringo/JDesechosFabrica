/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.CasosDeUso.Residuo;

import java.util.ArrayList;
import java.util.List;
import jdesechosfabrica.Modelo.Dao.ResiduoDao;
import jdesechosfabrica.Modelo.Dto.Residuo.ObtenerResiduoPorIdPeticionDto;
import jdesechosfabrica.Modelo.Dto.Residuo.ObtenerResiduoPorIdRespuestaDto;
import jdesechosfabrica.Modelo.Entidades.Residuo;

/**
 *
 * @author HP
 */
public class ObtenerResiduoPorIdCasoDeUso {
    private final ResiduoDao residuoDao;

    public ObtenerResiduoPorIdCasoDeUso(ResiduoDao residuoDao) {
        this.residuoDao = residuoDao;
    }
    
    public ObtenerResiduoPorIdRespuestaDto procesar(ObtenerResiduoPorIdPeticionDto peticion) throws Exception{
        try {
            Residuo residuo = residuoDao.buscarPorId(peticion.getId());
            
            
            List<Integer> constituyentesIds = new ArrayList<>();
            for(var constituyente :  residuo.getConstituyentes()){
                constituyentesIds.add(constituyente.getId());
            }
            List<Integer> trasladosIds = new ArrayList<>();
            if(residuo.getTraslados()!=null){
                for(var traslado : residuo.getTraslados()){
                    trasladosIds.add(traslado.getId());
                }
            }
            
            
            int envaseId = (residuo.getEnvase()!=null)?residuo.getEnvase().getId():null;
            int tratamientoPosteriorId = (residuo.getTratamientoPosterior()!=null)?residuo.getTratamientoPosterior().getId():null;
            
            
            return new ObtenerResiduoPorIdRespuestaDto(
                    residuo.getId(),
                    residuo.getCodigo(),
                    residuo.getTipoResiduo(),
                    residuo.getFechaGeneracion(),
                    residuo.getCantidadTotalKilos(),
                    constituyentesIds,
                    residuo.getProductor().getId(),
                    envaseId,
                    trasladosIds,
                    tratamientoPosteriorId,
                    residuo.isHuboIncidenteSeguridad());
        } catch (Exception error) {
            var mensaje = "Hubo un error al obtener el residuo por id\\n"+error.getMessage();
            throw new Exception(mensaje);
        }
    }
}
