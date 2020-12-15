/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorjuego;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GestoraSatelites {

    private ArrayList<Satelite> colSatelites;
    private ArrayList<Satelite> colaSatelites;
    private static GestoraSatelites instancia = null;

    private GestoraSatelites() {
        colSatelites = new ArrayList<>();
        
    }

    public static GestoraSatelites getInstance() {
        if (instancia == null) {
            instancia = new GestoraSatelites();
        }
        return instancia;
    }

    public void agregarSatelite(Satelite s) {
        colSatelites.add(s);
    }

    public void agregarSateliteCola() {
        colaSatelites = new ArrayList<>();
        for (int y = colSatelites.size(); y > 0; y--) {
            Satelite sa=colSatelites.get(y-1);
            colaSatelites.add(sa);
          
        }
    }

    public void listarSatelitesTipo(String tipo) {
        for (int i = 0; i < colaSatelites.size(); i++) {
           String t=colaSatelites.get(i).getTipo_orbita().name();
            if(t.equals(tipo))
            System.out.print(colaSatelites.get(i).toString());
        }

    }

    public void listarSatelites() {
        for (int i = 0; i < colSatelites.size(); i++) {
            System.out.print(colSatelites.get(i).toString());
        }
    }

    public ArrayList<Satelite> obtenerSatelites() {
        return new ArrayList<>(colSatelites);
    }

    public Satelite obtenerSatelites(int Codigo) {
        for (Satelite s : colSatelites) {
            if (Codigo == s.getCodigo()) {
                return s;
            }
        }
        return null;
    }

    public boolean borrarSatelite(int Codigo) {
        Satelite satelite = obtenerSatelites(Codigo);
        if (colSatelites.remove(satelite)) {
            return true;
        }
        return false;
    }

}
