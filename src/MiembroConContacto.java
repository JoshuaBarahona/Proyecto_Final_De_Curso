public class MiembroConContacto extends Miembro {

    private String numeroTelefonico;
    private String email;

    public MiembroConContacto(String nombre, int edad, String direccion, String Id, String numeroTelefonico, String email){
        super(nombre, edad, direccion, Id);
        this.numeroTelefonico = numeroTelefonico;
        this.email = email;

    }

    public String getNumeroTelefonico(){
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico){
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

}
