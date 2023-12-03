/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1;

/**
 *
 * @author Cristina Triviño
 */
public class FichaComodin extends Ficha{

    @Override
    public int getLado1() {
        return lado1;
    }

    @Override
    public int getLado2() {
        return lado2;
    }

    public FichaComodin(int lado1, int lado2) {
        super(-1, -1);
    }

    @Override
    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    @Override
    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }
    
    @Override
    public String toString(){
        return "*"+super.toString()+"*";
    }  
}
