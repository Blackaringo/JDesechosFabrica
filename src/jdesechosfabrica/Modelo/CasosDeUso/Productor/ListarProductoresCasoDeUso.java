/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.CasosDeUso.Productor;

import java.util.ArrayList;
import java.util.List;
import jdesechosfabrica.Modelo.Dao.ProductorDao;
import jdesechosfabrica.Modelo.Dto.Productor.ListarProductorResponseDto;
import jdesechosfabrica.Modelo.Dto.Productor.ProductorDto;
import jdesechosfabrica.Modelo.Entidades.Productor;

/**
 *
 * @author HP
 */
public class ListarProductoresCasoDeUso {

    private final ProductorDao productorDao;

    public ListarProductoresCasoDeUso(ProductorDao productorDao) {
        this.productorDao = productorDao;
    }

    public ListarProductorResponseDto procesar() {
        List<Productor> productores = productorDao.obtenerTodos();
        List<ProductorDto> productoresDto = new ArrayList<>();
        for (var productor : productores) {
            List<Integer> residuosIds = new ArrayList<>();
            if (productor.getResiduos() != null) {
                for (var residuo : productor.getResiduos()) {
                    residuosIds.add(residuo.getId());
                }
            }
            productoresDto.add(new ProductorDto(
                    productor.getId(),
                    productor.getNombre(),
                    productor.getTipoActividad(),
                    productor.getDireccion().getPais(),
                    productor.getDireccion().getCiudad(),
                    productor.getDireccion().getBarrio(),
                    productor.getDireccion().getCalle(),
                    productor.getDireccion().getNumero(),
                    residuosIds
            ));
        }
        return new ListarProductorResponseDto(productoresDto);
    }
}
