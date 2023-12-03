/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Cristina Triviño
 */
public class Juego {
    public ArrayList<Jugador> jugadores;
    public ArrayList<Ficha>  lineaDejuego;

    public Juego() {
        this.jugadores = new ArrayList<>();
        this.lineaDejuego = new ArrayList<>();
    }
    
    public void agregarJugador(String n)
    {
    Jugador j1= new Jugador(n,Utilitaria.crearManoJugador());
    this.jugadores.add(j1);
    }
    public int obtenerValorInicioLinea()
    {
    return this.lineaDejuego.get(0).getLado1();
    }
    public int obtenerValorFinLinea()
    {
    return this.lineaDejuego.get(this.lineaDejuego.size()-1).getLado1();
    }
    
    public void mostrarLinea()
    {
    String caracter="-";
    String fichas="";
    for(int i=0;i<this.lineaDejuego.size();i++){
     fichas+=this.lineaDejuego.get(i).toString()+"-";
     
    }
    
    System.out.println(fichas);
    }
    
    public boolean evaluar(Jugador j)//Esta funcion permite evaluar si aun puedes continuar jugando
    {
    int contador=0;
    for(int i=0;i<j.getMano().size();i++)
    {
      if(j.getFicha(i).getLado1()==this.lineaDejuego.get(this.lineaDejuego.size()-1).getLado2()||j.getFicha(i).getLado2()==this.lineaDejuego.get(0).getLado1()||j.getFicha(i)instanceof FichaComodin)
      {
          contador+=1;
      }
      else
          contador+=0;
      
    }
     if(contador>0){
     return true;
     }
     else
     return false;
    }
    
    public boolean agregarFichaLinea(Ficha f, Jugador j)
    {
    Scanner sc= new Scanner(System.in);
    if(!(f instanceof FichaComodin))
    {
     if(this.lineaDejuego.size()==0)
     {
     System.out.println("Movimiento válido");
     this.lineaDejuego.add(f);
     }
     else
     {
     if(f.getLado1()==this.lineaDejuego.get(this.lineaDejuego.size()-1).getLado2())
     {   
         System.out.println("Movimiento válido");
         this.lineaDejuego.add(f);
         return true;
     }
     else if(f.getLado2()==this.lineaDejuego.get(0).getLado1())
     {
         System.out.println("Movimiento válido");
         this.lineaDejuego.add(0, f);
         return true;
     }
     else
         System.out.println("Movimiento no valido");
         return false;
     }
    }
    else{ 
        FichaComodin comodin= (FichaComodin)f;
        if(this.lineaDejuego.size()==0)
        {
            System.out.println("Elija lado1: ");
            int l1= sc.nextInt();
            System.out.println("Elija lado2: ");
            int l2= sc.nextInt();
            while((l1>6||l2>6)||(l1<1||l2<1))
            {
                System.out.println("Elija lado1: ");
                int l11=sc.nextInt();
                System.out.println("Elija lado2: ");
                int l22= sc.nextInt();
                l1=l11;
                l2=l22;
            }
            comodin.setLado1(l1);
            comodin.setLado2(l2);
            this.lineaDejuego.add(comodin);
            
        }
        else
            System.out.println("En que posicion desea colocar la ficha: "+"\nA)Inicio"+"\nB)fin");
            String opcion= sc.nextLine();
            if("A".equals(opcion))
            {
                System.out.println("Selecciones nuevo inicio: ");
                int inicio=sc.nextInt();
                while(inicio>6||inicio<1)
                {
                System.out.println("Selecciones nuevo inicio: ");
                int ni=sc.nextInt();
                inicio=ni;
                }
                comodin.setLado1(inicio);
                this.lineaDejuego.add(0, comodin);
            }
            else if("B".equals(opcion))
            {
                System.out.println("Selecciones nuevo fin: ");
                int fin= sc.nextInt();
                while(fin>6||fin<1)//Este bucle limita a que el usuario simplemente escoja digitos de 1 a 6
                {
                 System.out.println("Selecciones nuevo inicio: ");
                 int fn=sc.nextInt();
                 fin=fn;
                }
                comodin.setLado2(fin);
                this.lineaDejuego.add(comodin);
            }
    
    }
    return true;}
}
    
