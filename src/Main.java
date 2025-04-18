import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        List<Perro> perrosDisponibles = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("___MENÚ DE ADOPCIÓN DE PERROS:___");
            System.out.println("1. Registrar persona");
            System.out.println("2. Registrar perro");
            System.out.println("3. Ver personas registradas");
            System.out.println("4. Ver perros disponibles");
            System.out.println("5. Adoptar perro");
            System.out.println("6. Consultar perro más viejo adoptado");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Documento: ");
                    String documento = scanner.nextLine();

                    personas.add(new Persona(nombre, apellido, edad, documento));
                    System.out.println("Persona registrada exitosamente.");
                }
                case 2 -> {
                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Nombre del perro: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Raza: ");
                    String raza = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tamaño: ");
                    String tamaño = scanner.nextLine();

                    perrosDisponibles.add(new Perro(placa, nombre, raza, edad, tamaño));
                    System.out.println("Perro registrado exitosamente.");
                }
                case 3 -> {
                    if (personas.isEmpty()) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        System.out.println("Personas registradas:");
                        personas.forEach(System.out::println);
                    }
                }
                case 4 -> {
                    if (perrosDisponibles.isEmpty()) {
                        System.out.println("No hay perros disponibles.");
                    } else {
                        System.out.println("Perros disponibles:");
                        perrosDisponibles.forEach(System.out::println);
                    }
                }
                case 5 -> {
                    System.out.print("Documento de la persona: ");
                    String doc = scanner.nextLine();
                    Persona persona = buscarPersona(doc, personas);

                    if (persona == null) {
                        System.out.println("Persona no encontrada.");
                        break;
                    }

                    System.out.print("Placa del perro a adoptar: ");
                    String placa = scanner.nextLine();
                    Perro perro = buscarPerro(placa, perrosDisponibles);

                    if (perro == null) {
                        System.out.println("Perro no disponible.");
                        break;
                    }

                    if (persona.adoptarPerro(perro)) {
                        perrosDisponibles.remove(perro);
                        System.out.println("Perro adoptado exitosamente.");
                    } else {
                        System.out.println("Esta persona ya ha adoptado 3 perros.");
                    }
                }
                case 6 -> {
                    System.out.print("Documento de la persona: ");
                    String doc = scanner.nextLine();
                    Persona persona = buscarPersona(doc, personas);

                    if (persona == null) {
                        System.out.println("Persona no encontrada.");
                        break;
                    }

                    Perro perroViejo = persona.perromasgrande();
                    if (perroViejo == null) {
                        System.out.println("Esta persona no ha adoptado ningún perro.");
                    } else {
                        System.out.println("El perro más viejo adoptado: " + perroViejo);
                    }
                }
                case 7 -> {
                    System.out.println("¡Gracias por usar el sistema de adopción!");
                    continuar = false;
                }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }


    public static Persona buscarPersona(String documento, List<Persona> personas) {
        for (Persona p : personas) {
            if (p.getDocumento().equalsIgnoreCase(documento)) {
                return p;
            }
        }
        return null;
    }


        public static Perro buscarPerro(String placa, List<Perro> perros) {
            for (Perro p : perros) {
                if (p.getPlaca().equalsIgnoreCase(placa)) {
                    return p;
                }
            }
            return null;
    }
}