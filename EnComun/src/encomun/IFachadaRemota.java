/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encomun;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 *
 * @author Usuario
 */
public interface IFachadaRemota extends Remote{
    public void agregarSatelite(String nombre, int Codigo, int Altura)throws RemoteException;
    ///public ArrayList<Jugador> obtenerJugadores()throws RemoteException;
    public boolean borrarSatelite(int codigo)throws RemoteException;
    public void listarSatelites()throws RemoteException;
    public void listarSatelitesTipo(String tipo)throws RemoteException;
    public void agregarSateliteCola()throws RemoteException;
}
