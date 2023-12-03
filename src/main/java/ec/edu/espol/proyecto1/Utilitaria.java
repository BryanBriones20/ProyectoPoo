/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Cristina Triviño
 */
public class Utilitaria {
    public static ArrayList<Ficha> crearManoJugador(){
        ArrayList<Ficha> lista= new ArrayList<>();
        Random r= new Random();
        FichaComodin nuevo= new FichaComodin(-1,-1);
        Ficha ficha1= new Ficha(r.nextInt(1, 7),r.nextInt(1, 7));
        Ficha ficha2= new Ficha(r.nextInt(1, 7),r.nextInt(1, 7));
        Ficha ficha3= new Ficha(r.nextInt(1, 7),r.nextInt(1, 7));
        Ficha ficha4= new Ficha(r.nextInt(1, 7),r.nextInt(1, 7));
        lista.add(ficha1);
        lista.add(ficha2);
        lista.add(ficha3);
        lista.add(ficha4);
        lista.add(nuevo);
        return lista;
    }
}