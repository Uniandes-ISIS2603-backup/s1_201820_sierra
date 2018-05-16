/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.ejb;


import co.edu.uniandes.csw.sierra.entities.EspecieEntity;
import co.edu.uniandes.csw.sierra.entities.MascotaEntity;
import co.edu.uniandes.csw.sierra.entities.RazaEntity;
import co.edu.uniandes.csw.sierra.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.sierra.persistence.EspeciePersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que representa una especie en la capa logica.
 * @author jc.sanchez12
 */
@Stateless
public class EspecieLogic
{
    private static final Logger LOGGER = Logger.getLogger( SierraLogic.class.getName( ) );

	@Inject
	private EspeciePersistence persistence;
        
        @Inject
        private RazaLogic razaLogic;
    
        /**
         * Crea una  entity en la  base de datos  de tipo especie
         * No existe  alguna  regla que  repercuta en la creacion de una especie mientras no exista ya en la base de datos.
         * @param entity Bojeto con los datos  de la nueva  EspecieEntity 
         * @return Objeto de  tipo EspecieEntity con los  datos nuevos  
         * @throws BusinessLogicException 
         */
     public EspecieEntity createEspecie(EspecieEntity entity) throws BusinessLogicException
     {
         LOGGER.info( "Inicia proceso de creación de una entidad de Especie" );
         if (persistence.findByName(entity.getNombre())!=null)
         {
             throw new BusinessLogicException( "Ya existe una entidad de Especie con el nombre \"" + entity.getNombre() + "\"" );
         }
             persistence.create(entity);
             LOGGER.info( "Termina proceso de creación de una entidad de Especie" );
             return entity;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
     }
     
     
    /**
     * Obtiene la lista de los registros de Especies.
     * No existe  alguna  regla que  repercuta en la obtencion de todas las especies en la base de datos.
     * @return Colección de objetos de EspecieEntity.
     */
     public List<EspecieEntity> getAllEspecies()
     {
                LOGGER.info( "Inicia proceso de consultar todas las entidades de Especie" );
		List<EspecieEntity> entities = persistence.findAll( );
                LOGGER.info( "Termina proceso de consultar todas las entidades de Especie" );
		return entities;
     }
     
     
     /**
     * Obtiene los datos de una instancia de Especie a partir de su ID.
     * @param id Identificador de la instancia a consultar
     * @return Instancia de EsoeciEntity con los datos de la especie consultada.
     */
     public EspecieEntity getEspecieById( Long id )
     {
	return persistence.findById(id );
     }
     
     /**
     * Obtiene los datos de una instancia de Especie a partir de su nombre.
     * @param nombre nombre  de la instancia a consultar
     * @return Instancia de EspecieEntity con los datos de la especie consultada.
     */
     public EspecieEntity getEspecieByName( String nombre )
     {
	return persistence.findByName(nombre );
     }
     
     /**
     * Actualiza la información de una instancia de Especie.
     * @param entity Instancia de EspecieEntity con los nuevos datos.
     * @return Instancia de EspecieEntity con los datos actualizados.
     */
    public EspecieEntity updateEspecie(EspecieEntity entity)
    {
        EspecieEntity ent= persistence.findById(entity.getId());
        if (ent!=null) {
            if (("").equals(entity.getNombre()) || ("").equals(entity.getClasificacion())) {
                return null;
            }
            else{
                return  persistence.update(entity);
            }
        }  
        return null;
    }
    
    /**
     * Elimina una instancia de Especie de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteEspecie(Long id) {
        EspecieEntity ent= persistence.findById(id);
        if (ent!=null) {
             persistence.delete(id);
        }  
    }

    public EspecieEntity addMascota(Long especieId, Long razaId) throws BusinessLogicException {
        
        //Busca la especie y revisa que exista
        EspecieEntity espEnt = getEspecieById(especieId);
        if(espEnt == null){
            throw new BusinessLogicException("No existe una especie con el id: " + especieId);
        }
        
        //revisa que exista la raza
        RazaEntity razaEnt = razaLogic.getById(razaId);
        if(razaEnt == null){
            throw new BusinessLogicException("No existe una raza con el id: " + razaId);
        }
        
        //asocia la raza con especie y lo mismo en sentido contrario
        if(espEnt.getRazas() == null){
            espEnt.setRazas(new ArrayList<>());
        }
        espEnt.getRazas().add(razaEnt);
        razaEnt.setEspecie(espEnt);
        return espEnt;
        
        
        
    }
    
    
    public List<MascotaEntity> getMascotasList(Long especieId) throws BusinessLogicException
    {
        EspecieEntity especieEnt = getEspecieById(especieId);
        if(especieEnt == null){
            throw new BusinessLogicException("No existe una especie con el Id: " + especieId);
        }
        List<MascotaEntity> lista = new ArrayList<>();
        List<RazaEntity> listaRazas = especieEnt.getRazas();
        if(listaRazas != null){
            for(RazaEntity raza: listaRazas){
                List<MascotaEntity> listaMascotas = raza.getMascotas();
                if(listaMascotas != null){
                    for(MascotaEntity mascota: listaMascotas){
                        lista.add(mascota);
                    }
                }
            }
        }
        
        
        
        return lista;
    }

}
