package cursos.losnegativosfinal;
import java.time.LocalDate;
import java.util.ArrayList;
import static spark.Spark.get;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static Libro buscarLibroPorNombre(String nombre) {
    ArrayList<Libro> libros = new ArrayList<>();
    for (Libro libro : libros) {
        if (libro.nombre.equalsIgnoreCase(nombre)) {
            return libro;
        }
    }
    return null;
}
    public static void main(String[] args) {
        LocalDate fechaInicial = LocalDate.now();
        // Creación de instancias
        Autor autor = new Autor("Daniel", "Venezolano", "1856");
        Libro libro = new Libro("Hambre", "Panamericana", "Terror", "1802");
        Copia copia = new Copia("V564", "Disponible", libro);
        Lector lector = new Lector(1, "Nicolle", "Montaño", "Mi Casa");

        // Listas
        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Lector> lectores = new ArrayList<>();
        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Copia> copias = new ArrayList<>();

        // Añadir instancias a las listas
        autores.add(autor);
        libros.add(libro);
        lectores.add(lector);
        copias.add(copia);

        autor.getLibros().add(libro);
        libro.getAutores().add(autor);
        libro.getCopias().add(copia);
        lector.agregarCopia(copia);

        // Configuración de Gson
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        // Endpoint para obtener la lista de libros
        get("/copias",(req, res)->{
            res.type("application/json");
            return gson.toJson(copias);
        });
        get("/libros", (req, res) -> {
            res.type("application/json");
            return gson.toJson(libros);
        });

        // Endpoint para obtener la lista de lectores
        get("/lectores", (req, res) -> {
            res.type("application/json");
            return gson.toJson(lectores);
        });

        // Endpoint para obtener la lista de autores
        get("/autores", (req, res) -> {
            res.type("application/json");
            return gson.toJson(autores);
        });

        // Endpoint para agregar lectores
        get("/agregarLectores/:numSocio/:nombre/:apellido/:direccion", (req, res) -> {
            // Obtener parámetros de la ruta
            int numSocio = Integer.parseInt(req.params("numSocio"));
            String nombre = req.params("nombre");
            String apellido = req.params("apellido");
            String direccion = req.params("direccion");

            // Crear nuevo lector
            Lector nuevoLector = new Lector(numSocio, nombre, apellido, direccion);

            // Agregar el nuevo lector a la lista
            lectores.add(nuevoLector);

            // Devolver una respuesta
            res.type("application/json");
            return gson.toJson(nuevoLector);
        });
    
        
        
        // Endpoint para prestar una copia
 get("/prestar/:numSocio/:copiaId", (req, res) -> {
            res.type("application/json");

            // Obtener parámetros de la ruta
            int numSocio = Integer.parseInt(req.params(":numSocio"));
            String copiaId = req.params(":copiaId");

            // Buscar el lector por numSocio
            Lector lectorPrestamo = lectores.stream()
                    .filter(lect -> lect.getNumSocio() == numSocio)
                    .findFirst()
                    .orElse(null);

            // Buscar la copia por copiaId
            Copia copiaPrestamo = copias.stream()
                    .filter(cop -> cop.getIdentificador().equals(copiaId))
                    .findFirst()
                    .orElse(null);

            // Prestar la copia al lector si ambos existen
            if (lectorPrestamo != null && copiaPrestamo != null) {
                copiaPrestamo.prestar();
                lectorPrestamo.agregarCopia(copiaPrestamo);
                LocalDate fechaFinal;

                // Iniciar el préstamo con las fechas inicial y final
              lectorPrestamo.iniciarPrestamo(fechaInicial, null);

                return gson.toJson(lectorPrestamo);
            } else {
                // Devolver un mensaje de error si no se encuentran
                res.status(404);
                return gson.toJson("Lector o copia no encontrado");
            }
        });
   
    }
    
    
}
