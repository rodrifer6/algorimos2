/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorjuego;

/**
 *
 * @author Usuario
 */
public class Satelite {
    private String Nombre;
    private int Codigo;
    private int Altura;
    private tipo_orbita tipoOrbita = calcularTipoOrbita();
    

    public Satelite(String Nombre,int Codigo, int Altura) {
        this.Nombre = Nombre;
        this.Codigo = Codigo;
        this.Altura = Altura;
    }

    public Satelite() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo= Codigo;
    }

    public int getAltura() {
        return Altura;
    }

    public void setAltura() {
        this.Altura=Altura;
    }
      public tipo_orbita getTipo_orbita() {
        return calcularTipoOrbita();
    }

    private tipo_orbita calcularTipoOrbita() {
        if (Altura > 35000) {
            tipoOrbita = tipo_orbita.alta;
        } else if (Altura >= 2000) {
            tipoOrbita = tipo_orbita.media;
        } else if (Altura >= 200) {
            tipoOrbita = tipo_orbita.baja;
        } else {
            tipoOrbita = tipo_orbita.noAsingado;
        }
        return tipoOrbita;
         }
    @Override
    public String toString() {
        return "Satelite{Nombre:" + getNombre() + "-Codigo:" + getCodigo() + "-Altura:" + getAltura() +"-Tipo de Orbita:" + getTipo_orbita()+ "}\n";
    }
    
}
