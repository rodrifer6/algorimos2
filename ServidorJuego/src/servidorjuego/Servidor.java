/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorjuego;

import java.rmi.server.UnicastRemoteObject;
import EnComun.*;
import encomun.IFachadaRemota;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, IOException {
        Servidor.iniciar();
    }

    public static void iniciar() throws IOException { 
       
        FachadaRemota fr = FachadaRemota.getInstance();
        fr.agregarSatelite("one", 111, 13123);
        fr.agregarSateliteCola();
        fr.agregarSatelite("two", 222, 231);
        fr.agregarSateliteCola();
        fr.agregarSatelite("four", 333, 3123);
        fr.agregarSateliteCola();
        fr.agregarSatelite("five", 444, 431243);
        fr.agregarSateliteCola();
        System.out.println("Dijite un comando: salir, agregar, borrar, ver, listar o tipo");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sTexto = br.readLine();
        do {
            if (sTexto.equals("agregar")) {////////////////////////////AGREGAR///////////////////////////////////////////////////////

                System.out.println("Dijite un codigo");
                BufferedReader co = new BufferedReader(new InputStreamReader(System.in));
                int codigoTexto = Integer.parseInt(co.readLine());
                System.out.println("Dijite un nombre");
                BufferedReader no = new BufferedReader(new InputStreamReader(System.in));
                String nombreTexto = no.readLine();
                System.out.println("Dijite una altitud: mayor a 200");
                BufferedReader al = new BufferedReader(new InputStreamReader(System.in));
                int alturaTexto = Integer.parseInt(al.readLine());
                fr.agregarSatelite(nombreTexto, codigoTexto, alturaTexto);
                fr.agregarSateliteCola();

                System.out.println("Dijite un comando: salir, agregar, borrar, ver, listar o tipo");
                sTexto = br.readLine();
            } else if (sTexto.equals("borrar")) {////////////////////////////////BORRAR/////////////////////////////////////////////
                System.out.println("Dijite un codigo de satelite");
                BufferedReader cod = new BufferedReader(new InputStreamReader(System.in));
                int codigoTexto = Integer.parseInt(cod.readLine());
                System.out.println("Esta seguro que desea eliminar al satelite" + codigoTexto + "?    Ingrese 'si' o 'no'");
                sTexto = br.readLine();
                if (sTexto.equals("si")) {
                    boolean confirm = GestoraSatelites.getInstance().borrarSatelite(codigoTexto);
                    if (confirm == true) {
                        System.out.println("Satelite Eliminado");
                    } else {
                        System.out.println("Error al Eliminar");
                    }
                } else {
                    System.out.println("Satelite NO Elimindo");
                }
                System.out.println("Dijite un comando: salir, agregar, borrar, ver, listar o tipo");
                sTexto = br.readLine();
            } else if (sTexto.equals("ver")) {//////////////////////////////////////////VER////////////////////////////////////////////
                System.out.println("Dijite un codigo de satelite");
                BufferedReader cod = new BufferedReader(new InputStreamReader(System.in));
                int codigoTexto = Integer.parseInt(cod.readLine());
                System.out.println("satelite: " + GestoraSatelites.getInstance().obtenerSatelites(codigoTexto).toString());

                System.out.println("Dijite un comando: salir, agregar, borrar, ver, listar o tipo");
                sTexto = br.readLine();

            } else if (sTexto.equals("listar")) {/////////////////////////////////////////////////LISTA///////////////////////////////
                fr.listarSatelites();

                System.out.println("Dijite un comando: salir, agregar, borrar, ver, listar o tipo");
                sTexto = br.readLine();
            } else if (sTexto.equals("tipo")) {//////////////////////////////////////TIPO///////////////////////////////
                System.out.println("Dijite una orbita: 'baja','media','alta','noAsignado'");
                sTexto = br.readLine();
                fr.listarSatelitesTipo(sTexto);

                System.out.println("Dijite un comando: salir, agregar, borrar, ver, listar o tipo");
                sTexto = br.readLine();
            } else {
                System.out.println(sTexto + ":no es un comando correcto");

                System.out.println("Dijite un comando: salir, agregar, borrar, ver, listar o tipo");
                sTexto = br.readLine();

            }
        } while (!sTexto.equals(
                "salir"));

    }
}
