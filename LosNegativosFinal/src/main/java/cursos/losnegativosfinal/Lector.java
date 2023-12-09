package cursos.losnegativosfinal;


import java.util.ArrayList;
import java.time.LocalDate;
public class Lector {
    // Atributos
    private int numSocio;
    private String nombre;
    private String apellido;
    private String direccion;
    private ArrayList<Copia> copiasPrestadas; // Lista de copias prestadas al lector
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;

    // Constructor
    public Lector(int numSocio, String nombre, String apellido, String direccion) {
        this.numSocio = numSocio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.copiasPrestadas = new ArrayList<>();
    }

    // Métodos
    public int getNumSocio() {
        return numSocio;
    }

    public void agregarCopia(Copia copia) {
        copiasPrestadas.add(copia);
    }
    // Getters y Setters

   
    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Copia> getCopiasPrestadas() {
        return copiasPrestadas;
    }

    public void setCopiasPrestadas(ArrayList<Copia> copiasPrestadas) {
        this.copiasPrestadas = copiasPrestadas;
    }

    // Método para prestar una copia al lector
    public void prestarCopia(Copia copia) {
        copiasPrestadas.add(copia);
    }
    public void iniciarPrestamo(LocalDate fechaInicial, LocalDate fechaFinal) {
        // Verificar si las fechas son nulas antes de asignarlas
        if (fechaInicial != null && fechaFinal != null) {
            this.fechaInicial = fechaInicial;
            this.fechaFinal = fechaFinal;
            System.out.println("Préstamo iniciado. Fecha Inicial: " + fechaInicial + ", Fecha Final: " + fechaFinal);
        } else {
            System.out.println("Error: Las fechas inicial y final no pueden ser nulas.");
        }
    }
}
