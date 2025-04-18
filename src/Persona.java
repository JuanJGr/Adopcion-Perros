import java.util.*;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String documento;
    protected List<Perro> perrosAdoptados;

    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perrosAdoptados = new ArrayList<>();
    }

    public String getDocumento() {
        return documento;
    }

    public boolean adoptarPerro(Perro perro) {
        if (perrosAdoptados.size() < 3) {
            perrosAdoptados.add(perro);
            return true;
        }
        return false;
    }

    public Perro perromasgrande() {
        if (perrosAdoptados.isEmpty()) return null;

        Perro mayor = perrosAdoptados.get(0);
        for (Perro p : perrosAdoptados) {
            if (p.getEdad() > mayor.getEdad()) {
                mayor = p;
            }
        }
        return mayor;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", documento='" + documento + '\'' +
                ", perrosAdoptados=" + perrosAdoptados +
                '}';
    }
}