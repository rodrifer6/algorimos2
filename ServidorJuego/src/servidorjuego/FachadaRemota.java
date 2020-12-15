/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorjuego;

import encomun.IFachadaRemota;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public class FachadaRemota implements IFachadaRemota {

    private static FachadaRemota fachadaRemota = null;

    public FachadaRemota() {
    }

    public static FachadaRemota getInstance() {
        if (fachadaRemota == null) {
            fachadaRemota = new FachadaRemota();
        }
        return fachadaRemota;
    }

    @Override
    public void agregarSatelite(String nombre, int Codigo, int Altura) throws RemoteException {
        GestoraSatelites.getInstance().agregarSatelite(new Satelite(nombre, Codigo, Altura));

        System.out.println("Satelite " + nombre + " agregado");
    }

    @Override
    public boolean borrarSatelite(int codigo) throws RemoteException {
        return GestoraSatelites.getInstance().borrarSatelite(codigo);

    }

    @Override
    public void listarSatelites() throws RemoteException {
        GestoraSatelites.getInstance().listarSatelites();
    }

    @Override
    public void listarSatelitesTipo(String tipo) throws RemoteException {
        GestoraSatelites.getInstance().listarSatelitesTipo(tipo);
    }

    @Override
    public void agregarSateliteCola() throws RemoteException {
        GestoraSatelites.getInstance().agregarSateliteCola();
    }

}
