/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import java.util.List;

/**
 *
 * @author Juan David Zambrano
 */
public class MascotaVentaDetailDTO extends MascotaVentaDTO {
    
//TODO: Hacer las referencias a madre y padre y sus respectivos Getters & Setters
    
    private List<CertificadoDTO> certificados;

    
    public MascotaVentaDetailDTO(){
        super();
    }
    
    /**
     * @return the certificados
     */
    public List<CertificadoDTO> getCertificados() {
        return certificados;
    }

    /**
     * @param certificados the certificados to set
     */
    public void setCertificados(List<CertificadoDTO> certificados) {
        this.certificados = certificados;
    }
    
    
}
