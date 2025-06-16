/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdesechosfabrica.Modelo.Dto.Productor;

import java.util.List;

/**
 *
 * @author HP
 */
public class ListarProductorResponseDto {
    private final List<ProductorDto> productores;

    public ListarProductorResponseDto(List<ProductorDto> productores) {
        this.productores = productores;
    }

    public List<ProductorDto> getProductores() {
        return productores;
    }
}
