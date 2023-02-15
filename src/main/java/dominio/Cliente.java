/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Cliente {
    
    private Integer id;
    private String nombre;
    private String apellidoPaterno;
    private String apelldioMaterno;
    private String fechaNacimiento;
    private Integer edad;
    private Integer idDireccion;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidoPaterno, String apelldioMaterno, Integer idDireccion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apelldioMaterno = apelldioMaterno;
        this.idDireccion = idDireccion;
    }

    public Cliente(Integer id, String nombre, String apellidoPaterno, String apelldioMaterno, Integer idDireccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apelldioMaterno = apelldioMaterno;
        this.idDireccion = idDireccion;
    }

    public Cliente(Integer id, String nombre, String apellidoPaterno, String apelldioMaterno, String fechaNacimiento, Integer edad, Integer idDireccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apelldioMaterno = apelldioMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.idDireccion = idDireccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApelldioMaterno() {
        return apelldioMaterno;
    }

    public void setApelldioMaterno(String apelldioMaterno) {
        this.apelldioMaterno = apelldioMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apelldioMaterno=" + apelldioMaterno + ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad + ", idDireccion=" + idDireccion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) {
            return false;
        }
        if (!Objects.equals(this.apelldioMaterno, other.apelldioMaterno)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.edad, other.edad)) {
            return false;
        }
        return Objects.equals(this.idDireccion, other.idDireccion);
    }
    
}
