/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import java.util.List;

/**
 *
 * @author jd.zambrano
 */
public class MascotaAdopcionDetailDTO extends MascotaAdopcionDTO{
    
    private List<AcontecimientoDTO> acontecimientos;
    
    public MascotaAdopcionDetailDTO(){
        super();
    }
    
}
