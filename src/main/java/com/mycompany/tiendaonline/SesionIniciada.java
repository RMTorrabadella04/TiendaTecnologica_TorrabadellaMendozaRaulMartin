package com.mycompany.tiendaonline;

public class SesionIniciada {
    // La única instancia de la clase
    private static SesionIniciada instancia;
    
    // Variable que indica si la sesión está iniciada
    private boolean iniciado = false;
    
    // Constructor privado para evitar la creación directa de objetos
    private SesionIniciada() {}
    
    // Método para obtener la instancia única de la clase
    public static SesionIniciada getInstance() {
        if (instancia == null) {
            instancia = new SesionIniciada();
        }
        return instancia;
    }

    // Getter y Setter para la variable 'iniciado'
    public boolean isIniciado() {
        return iniciado;
    }

    public void setIniciado(boolean iniciado) {
        this.iniciado = iniciado;
    }
}
