public class Miembro {
    private String nombre;
    private int edad;
    private String direccion;
    private String Id;
    
    // Constructor
    public Miembro(String nombre, int edad, String direccion, String Id) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.Id = Id;
    }
    
    // Métodos para acceder y actualizar atributos
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getId(){
        return Id;
    }

    public void setId(String Id){
        this.Id = Id;
    }
}