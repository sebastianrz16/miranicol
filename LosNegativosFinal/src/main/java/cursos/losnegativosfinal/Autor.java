/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cursos.losnegativosfinal;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;

public class Autor {
        @Expose
    public String nombre;
        @Expose
    public String nacionslidad;
        @Expose
    public String fechaNacimiento;
        @Expose
     public ArrayList<Libro> libros; 

    public Autor(String nombre, String nacionslidad, String fechaNacimiento) {
        this.nombre = nombre;
        this.nacionslidad = nacionslidad;
        this.fechaNacimiento = fechaNacimiento;
        this.libros = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Autor{" + "nombre=" + nombre + ", nacionslidad=" + nacionslidad + ", fechaNacimiento=" + fechaNacimiento + ", libros=" + libros + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionslidad() {
        return nacionslidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionslidad(String nacionslidad) {
        this.nacionslidad = nacionslidad;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    
    
          
}
