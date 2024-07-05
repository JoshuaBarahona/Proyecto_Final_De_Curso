import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;

public class App {
    public static Scanner leer = new Scanner(System.in);

    public static ArrayList<MiembroConContacto> contacto = new ArrayList<MiembroConContacto>();

    public static void main(String[] args) {
        CargarDatos();
        boolean salir = true;

        do {
            System.out.println("Elija una opción:");
        System.out.println("1. Agregar.");
        System.out.println("2. Mostrar información de los miembros.");
        System.out.println("3. Buscar.");
        System.out.println("4. Modificar.");
        System.out.println("5. Eliminar.");
        System.out.println("6. Guardar");
        System.out.println("7. Salir.");
        int opcion = leer.nextInt();
        leer.nextLine();

        switch (opcion) {
            case 1:
                AddMiembro();
                
                break;

                case 2:
                MostrarInfo();
                break;

                case 3:
                System.out.println("Ingrese el Id del miembro: ");
                String IdBuscar = leer.nextLine();
                System.out.println();
                BuscarMiembro(IdBuscar);
                
                break;

                case 4:
                System.out.println("Ingrese el Id del miembro a modificar: ");
                    String IdModificar = leer.nextLine();
                    System.out.println();
                    ModificarMiembro(IdModificar);
                break;

                case 5:
                System.out.println("Ingrese el Id del miembro a eliminar: ");
                    String IdEliminar = leer.nextLine();
                    System.out.println();
                    EliminarMiembro(IdEliminar);
                break;

                case 6:
                GuardarDatos();
                break;

                case 7:

                salir = false;
                System.out.println("Salió con éxito.");
                System.out.println();

                break;

                default:
                System.out.println("Opción no válida.");
                System.out.println();
        break;
        
    }

            
        } while (salir);
        
    }

    public static void AddMiembro(){
    System.out.println("Ingrese el ID del miembro: ");
    String Id = leer.nextLine();
    System.out.println("Ingrese el nombre del miembro: ");
    String nombre = leer.nextLine();
    System.out.println("Ingrese la edad del miembro: ");
    int edad = leer.nextInt();
    leer.nextLine(); // Limpiar el buffer del scanner
    System.out.println("Ingrese la dirección del miembro: ");
    String direccion = leer.nextLine();
    System.out.println("Ingrese el numero de contacto: ");
    String numeroTelefonico = leer.nextLine();
    System.out.println("Ingrese el Email del miembro: ");
    String email = leer.nextLine();
    System.out.println();

        MiembroConContacto nuevoMiembro = new MiembroConContacto(nombre, edad, direccion, Id, numeroTelefonico, email);
    contacto.add(nuevoMiembro);

    System.out.println("Datos agregados correctamente.");
    System.out.println();
    }

    

    public static void MostrarInfo(){
        System.out.println("Lista de miembros:");
        System.out.println();
        for (MiembroConContacto contactos : contacto) {
            System.out.println("Id: " + (contactos.getId()));
            System.out.println("Nombre: " + (contactos.getNombre()));
            System.out.println("Edad: " + (contactos.getEdad()));
            System.out.println("Dirección: " + (contactos.getDireccion()));
            System.out.println("Teléfono: " + (contactos.getNumeroTelefonico()));
            System.out.println("Email: " + (contactos.getEmail()));
            System.out.println();
        }

        
    }

    public static void BuscarMiembro(String identificacion){
        MiembroConContacto miembroSearch = null;
            for (MiembroConContacto miembro : contacto) {
                if (miembro.getId().equals(identificacion)) {
                    miembroSearch = miembro;
                    break;
                }
    }
    if (miembroSearch != null) {
        System.out.println("Miembro encontrado:");
        System.out.println();
        System.out.println("Id: " + (miembroSearch.getId()));
        System.out.println("Nombre: " + (miembroSearch.getNombre()));
        System.out.println("Edad: " + (miembroSearch.getEdad()));
        System.out.println("Dirección: " + (miembroSearch.getDireccion()));
        System.out.println("Telefono: " + (miembroSearch.getNumeroTelefonico()));
        System.out.println("Email: " + (miembroSearch.getEmail()));
        System.out.println();
    } else {
        System.out.println("Miembro no encontrado.");
        System.out.println();
    }
    
}

public static void ModificarMiembro(String identificacion) {
    MiembroConContacto miembroSearch = null;
    for (MiembroConContacto miembro : contacto) {
        if (miembro.getId().equals(identificacion)) {
            miembroSearch = miembro;
            break;
        }
    }
    if (miembroSearch != null) {
        System.out.println("Ingrese el nuevo nombre del miembro: ");
        String nuevoNombre = leer.nextLine();
        System.out.println("Ingrese la nueva edad del miembro: ");
        int nuevaEdad = leer.nextInt();
        leer.nextLine(); // Limpiar el buffer del scanner
        System.out.println("Ingrese la nueva dirección del miembro: ");
        String nuevaDireccion = leer.nextLine();
        System.out.println("Ingrese el nuevo numero de contacto: ");
        String nuevoNumeroTelefonico = leer.nextLine();
        System.out.println("Ingrese el nuevo Email del miembro: ");
        String nuevoEmail = leer.nextLine();
        System.out.println();

        miembroSearch.setNombre(nuevoNombre);
        miembroSearch.setEdad(nuevaEdad);
        miembroSearch.setDireccion(nuevaDireccion);
        miembroSearch.setNumeroTelefonico(nuevoNumeroTelefonico);
        miembroSearch.setEmail(nuevoEmail);

        System.out.println("Datos actualizados correctamente.");
        System.out.println();
    } else {
        System.out.println("Miembro no encontrado.");
        System.out.println();
    }
}

public static void EliminarMiembro(String identificacion) {
    MiembroConContacto miembroEliminar = null;
    for (MiembroConContacto miembro : contacto) {
        if (miembro.getId().equals(identificacion)) {
            miembroEliminar = miembro;
            break;
        }
    }
    if (miembroEliminar != null) {
        contacto.remove(miembroEliminar);
        System.out.println("Miembro eliminado correctamente.");
        System.out.println();
    } else {
        System.out.println("Miembro no encontrado.");
        System.out.println();
    }
}

public static void GuardarDatos() {
    try (RandomAccessFile raf = new RandomAccessFile("miembros.dat", "rw")) {
        // Primero, limpiamos el archivo
        raf.setLength(0);

        // Guardar la cantidad de miembros
        raf.writeInt(contacto.size());

        // Guardar cada miembro
        for (MiembroConContacto miembro : contacto) {
            raf.writeUTF(miembro.getId());
            raf.writeUTF(miembro.getNombre());
            raf.writeInt(miembro.getEdad());
            raf.writeUTF(miembro.getDireccion());
            raf.writeUTF(miembro.getNumeroTelefonico());
            raf.writeUTF(miembro.getEmail());
        }

        System.out.println("Datos guardados correctamente.");
        System.out.println();
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error al guardar los datos.");
        System.out.println();
    }
}

public static void CargarDatos() {
    try (RandomAccessFile raf = new RandomAccessFile("miembros.dat", "r")) {
        contacto.clear(); //evitar duplicados de datos antiguos

        /*Leer la cantidad de miembros, para saber cuantas veces iterar
        sobre el archivo y leer los datos correspondientes de cada miembro*/
        int cantidadMiembros = raf.readInt();

        // Leer cada miembro
        for (int i = 0; i < cantidadMiembros; i++) {
            String id = raf.readUTF();
            String nombre = raf.readUTF();
            int edad = raf.readInt();
            String direccion = raf.readUTF();
            String numeroTelefonico = raf.readUTF();
            String email = raf.readUTF();

            MiembroConContacto miembro = new MiembroConContacto(nombre, edad, direccion, id, numeroTelefonico, email);
            contacto.add(miembro);
        }

        System.out.println("Datos cargados correctamente.");
        System.out.println();
    } catch (FileNotFoundException e) {
        // Si el archivo no existe, simplemente no se hace nada
        System.out.println("No se encontró el archivo de datos. Se creará uno nuevo al guardar.");
        System.out.println();
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error al cargar los datos."); //si ocurre un problema al momento de leer el archivo
        System.out.println();
    }
}



}