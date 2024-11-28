package com.mycompany.tiendaonline;

public class SesionIniciada {
    
    private static SesionIniciada instancia;
    private static String email;
    

    private boolean iniciado = false;
    

    private SesionIniciada() {}
    

    public static SesionIniciada getInstance() {
        if (instancia == null) {
            instancia = new SesionIniciada();
        }
        return instancia;
    }

    public boolean isIniciado() {
        return iniciado;
    }

    public void setIniciado(boolean iniciado) {
        this.iniciado = iniciado;
    }
    
    public static void setEmail(String email){
        SesionIniciada.email=email;
    }
    
    public static String getEmail(){
        return SesionIniciada.email;
    }
}
