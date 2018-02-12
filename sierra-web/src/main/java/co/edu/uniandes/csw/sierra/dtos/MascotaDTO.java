/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.sierra.dtos;

/**
 *
 * @author jc.sanchez12
 */
public class MascotaDTO 
{
     /**
    * Id
    */
    private Long id;
    
    private String nombre;
    
    private String apellido;
    
    private int edad;
    
    private String color;
    
    private boolean esteril;
    
    private boolean adquirida;
    
    private String  imagen;
    
    private String tamano;
    
    private String nacimiento;
    
    private String muerte;
    
           
    /**
   *Constructor por defecto
   */
   public MascotaDTO()
   {
        //Constructor por defecto
   }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the esteril
     */
    public boolean isEsteril() {
        return esteril;
    }

    /**
     * @param esteril the esteril to set
     */
    public void setEsteril(boolean esteril) {
        this.esteril = esteril;
    }

    /**
     * @return the adquirida
     */
    public boolean isAdquirida() {
        return adquirida;
    }

    /**
     * @param adquirida the adquirida to set
     */
    public void setAdquirida(boolean adquirida) {
        this.adquirida = adquirida;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the tamano
     */
    public String getTamano() {
        return tamano;
    }

    /**
     * @param tamano the tamano to set
     */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    /**
     * @return the nacimiento
     */
    public String getNacimiento() {
        return nacimiento;
    }

    /**
     * @param nacimiento the nacimiento to set
     */
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * @return the muerte
     */
    public String getMuerte() {
        return muerte;
    }

    /**
     * @param muerte the muerte to set
     */
    public void setMuerte(String muerte) {
        this.muerte = muerte;
    }
   
 
   
}
