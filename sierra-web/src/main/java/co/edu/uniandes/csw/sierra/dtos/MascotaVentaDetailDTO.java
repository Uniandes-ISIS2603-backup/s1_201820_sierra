/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

import co.edu.uniandes.csw.sierra.entities.CertificadoEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaVentaEntity;
import co.edu.uniandes.csw.sierra.entities.PublicacionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan David Zambrano
 */
public class MascotaVentaDetailDTO extends MascotaVentaDTO {

    /**
     * certificados de la mascota en venta
     */
    private List<CertificadoDTO> certificados;

    /**
     * Especie de la mascota
     */
    private EspecieDTO especie;

    /**
     * Raza de la mascota
     */
    private RazaDTO raza;

    /**
     * Publicaciones de la mascota
     */
    private List<PublicacionDTO> publicaciones;

    /**
     * Adquisicion de a mascota
     */
    private AdquisicionDTO adquisicion;

    /**
     * Constructor por defecto
     */

    /**
     * COnstructor vacio por defecto
     */
    public MascotaVentaDetailDTO() {
        super();
    }

    /**
     * Constructor que convierte una entidad a un DetailDTO
     *
     * @param ent la entidad que se quiere voncertir
     */
    public MascotaVentaDetailDTO(MascotaVentaEntity ent) {
        super(ent);
        if (ent != null) {
            
            this.certificados= new ArrayList<>();
            if (ent.getCertificados() != null) {
                for (CertificadoEntity entCertificado : ent.getCertificados()) {
                    //this.publicaciones.add(new PublicacionDTO(entPublicacion));
                }
            }
            
            this.publicaciones = new ArrayList<>();
            if (ent.getPublicaciones() != null) {
                for (PublicacionEntity entPublicacion : ent.getPublicaciones()) {
                    //this.publicaciones.add(new PublicacionDTO(entPublicacion));
                }
            }
            
            if(ent.getAdquisicion() != null)
                this.adquisicion = new AdquisicionDTO(ent.getAdquisicion());
            
            if(ent.getEspecie() != null)
                this.especie = new EspecieDTO(ent.getEspecie());
            
            if(ent.getRaza() != null){
                //this.raza = new RazaDTO(ent.getRaza());
            }   
        }
    }

    /**
     * Convierte un DetailDTO en una entidad
     *
     * @return la entidad
     */
    @Override
    public MascotaVentaEntity toEntity() {
        MascotaVentaEntity ent = new MascotaVentaEntity();
        super.toEntity(ent);
        if (this.certificados != null) {
            List<CertificadoEntity> listCertificados = new ArrayList<>();
            for (CertificadoDTO cert : certificados) {
                //listCertificados.add(cert.toEnity());
            }
            ent.setCertificados(listCertificados);
        }
        if(adquisicion != null)
            ent.setAdquisicion(adquisicion.toEntity());
        if(especie != null)
            ent.setEspecie(especie.toEntity());
        if(publicaciones != null){
            List<PublicacionEntity> listPublicacion= new ArrayList<>();
            for (PublicacionDTO publica : publicaciones){
                //listPublicacion.add(publica.toEntity());
            }
            ent.setPublicaciones(listPublicacion);
        }
        if(raza != null){
            //ent.setRaza(raza.toEntity());
        }   
        return ent;
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

    /**
     * @return the especie
     */
    public EspecieDTO getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(EspecieDTO especie) {
        this.especie = especie;
    }

    /**
     * @return the raza
     */
    public RazaDTO getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(RazaDTO raza) {
        this.raza = raza;
    }

    /**
     * @return the publicaciones
     */
    public List<PublicacionDTO> getPublicaciones() {
        return publicaciones;
    }

    /**
     * @param publicaciones the publicaciones to set
     */
    public void setPublicaciones(List<PublicacionDTO> publicaciones) {
        this.publicaciones = publicaciones;
    }

    /**
     * @return the adquisicion
     */
    public AdquisicionDTO getAdquisicion() {
        return adquisicion;
    }

    /**
     * @param adquisicion the adquisicion to set
     */
    public void setAdquisicion(AdquisicionDTO adquisicion) {
        this.adquisicion = adquisicion;
    }

}
