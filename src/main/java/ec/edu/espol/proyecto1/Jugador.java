/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Cristina Triviño
 */
public class Jugador {
    private String nombre;
    private ArrayList<Ficha>mano;

    public ArrayList<Ficha> getMano() {
        return mano;
    }

    public Jugador(String nombre, ArrayList<Ficha> mano) {
        this.nombre = nombre;
        this.mano = mano;
    }

    public String getNombre() {
        return nombre;
    }

    public Ficha getFicha(int i){
        
        if(i<this.mano.size())
           return this.mano.get(i);
        else
           return null;
         }

    public void removerFicha(Ficha f){
       this.mano.remove(f);
}
    
    public void imprimirMano(){
        String fichas="";
        for(int i=0;i<this.mano.size()-1;i++)
            fichas+=this.mano.get(i).toString()+"-";
        fichas+=this.mano.get(this.mano.size()-1).toString();
        System.out.println(fichas);
        
    }
                }
    
    
    
    

