/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jc.sanchez12
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class MascotaAdoptadaEntity extends MascotaEntity
{
    
    private static final long serialVersionUID = 1L;
    
    //----------------Relaciones--------------//
    @PodamExclude
    @OneToMany(mappedBy = "mascotaAdopcion", cascade = CascadeType.PERSIST)
    private List<AcontecimientoEntity> acontecimientos;
    //---------------METODOS---------------//

    /**
     * @return the acontecimientos
     */
    public List<AcontecimientoEntity> getAcontecimientos() {
        return acontecimientos;
    }

    /**
     * @param acontecimientos the acontecimientos to set
     */
    public void setAcontecimientos(List<AcontecimientoEntity> acontecimientos) {
        this.acontecimientos = acontecimientos;
    }
    
    
}
