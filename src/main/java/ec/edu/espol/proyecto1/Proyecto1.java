/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.proyecto1;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Cristina Triviño
 */
public class Proyecto1 {
    
    public static void JugadorvsMaquina(Jugador jg1,Jugador jg2,Juego jg)
    {
        Random r= new Random();
        Scanner sc= new Scanner(System.in);
        
        //Maquina primer elemento
        System.out.print("Jugador "+jg1.getNombre()+" Mano -> ");
        jg1.imprimirMano();
        System.out.print("Linea de juego -> ");
        jg.mostrarLinea();
        System.out.println("Indice de ficha para jugar (0 es el primero  ): 0");
        jg.agregarFichaLinea(jg1.getFicha(0), jg1);
        jg1.removerFicha(jg1.getFicha(0));
        System.out.print("Nueva línea de juego -> ");
        jg.mostrarLinea();
        
        //Jugador
        System.out.print("\nJugador "+jg2.getNombre()+" Mano -> ");
        jg2.imprimirMano();
        System.out.print("Linea de juego -> ");
        jg.mostrarLinea();
        System.out.println("Indice de ficha para jugar (0 es el primero  ): ");
        int indice= sc.nextInt();
        while(indice>jg1.getMano().size())//Esta condición evita el error de colocar un indice fuera de rango
         {
             System.out.println("Ubicación no disponible, intente con otra: ");
             int indN=sc.nextInt();
             indice=indN;
         }
        //Evalua si la ficha puede ser ubicada en la linea de juego
        while(jg2.getFicha(indice).getLado1()!=jg.lineaDejuego.get(jg.lineaDejuego.size()-1).getLado2()&&jg2.getFicha(indice).getLado2()!=jg.lineaDejuego.get(0).getLado1()&&!(jg2.getFicha(indice)instanceof FichaComodin))
        {
            System.out.println("La ficha tiene "+jg2.getFicha(indice).toString()+" Intente con otro indice: ");
            int newIndice=sc.nextInt();
            indice=newIndice;
        }
        //Una vez la ficha pueda ubicarse en la línea de juego se procede a agregar y se remueve de la mano del jugador
        jg.agregarFichaLinea(jg2.getFicha(indice), jg2);
        jg2.removerFicha(jg2.getFicha(indice));
        System.out.print("Nueva línea de juego -> ");
        jg.mostrarLinea();
        
       //Maquina comodín: La maquina está obligada a usar su ficha comodín en su segundo turno
        System.out.print("\nJugador "+jg1.getNombre()+" Mano -> ");
        jg1.imprimirMano();
        System.out.print("Linea de juego -> ");
        jg.mostrarLinea();
        System.out.println("Indice de ficha para jugar (0 es el primero  ): 3");
        if(jg1.getFicha(3)instanceof FichaComodin)//Ubicacion de la ficha comodin;
        {
        FichaComodin fichaC=(FichaComodin)jg1.getFicha(3);//Se aplica cast para trabajar la ficha obtenida como una ficha comodin
        System.out.println("Seleccione ubicación de la ficha: "+"\n1)Inicio"+"\n2)Fin");
        int opcion= r.nextInt(1, 3);//Escoge un numero automático para elegir la forma de jugar la  ficha comodin
        //Ubica la ficha comodin al inicio de la cadena
        if(opcion==1){
            System.out.print("Seleccione nuevo inicio: ");
            int x=r.nextInt(1, 7);
            System.out.println(x);
            fichaC.setLado1(x);
            jg.lineaDejuego.add(0, fichaC);
        }
        else if(opcion==2)//Ubica la ficha comodin al final de la cadena
        {
            System.out.println("Seleccione nuevo fin: ");
            int x=r.nextInt(1, 7);
            fichaC.setLado2(x);
            jg.lineaDejuego.add(fichaC);        
        }
                
        jg1.removerFicha(jg1.getFicha(3));
        System.out.print("Nueva línea de juego -> ");
        jg.mostrarLinea();
        }
        
        //Ciclar turnos 
        int z1=jg1.getMano().size();
        int z2=jg2.getMano().size();
        while(z1!=0&&z2!=0)
        {
         boolean ev1=jg.evaluar(jg2);
         //Turno de jugador 
         if(ev1){
         System.out.print("\nJugador "+jg2.getNombre()+" Mano -> ");
         jg2.imprimirMano();
         System.out.print("Linea de juego -> ");
         jg.mostrarLinea();
         System.out.println("Indice de ficha para jugar (0 es el primero  ): ");
         int ind= sc.nextInt();
         while(ind>jg1.getMano().size())
         {
             System.out.println("Ubicación no disponible, intente con otra: ");
             int indN=sc.nextInt();
             ind=indN;
         }
         while(jg2.getFicha(ind).getLado1()!=jg.lineaDejuego.get(jg.lineaDejuego.size()-1).getLado2()&&jg2.getFicha(ind).getLado2()!=jg.lineaDejuego.get(0).getLado1()&&!(jg2.getFicha(ind)instanceof FichaComodin))
         {
            System.out.println("La ficha tiene "+jg2.getFicha(ind).toString()+" Intente con otro indice: ");
            int newIndice=sc.nextInt();
            ind=newIndice;           
         }
         jg.agregarFichaLinea(jg2.getFicha(ind), jg2);
         jg2.removerFicha(jg2.getFicha(ind));
         System.out.print("Nueva línea de juego -> ");
         jg.mostrarLinea();
         z2-=1;
         
         }
         else
            {
             z1=0;
            }
         //Turno de maquina
         boolean ev2=jg.evaluar(jg1);
         if(ev2)
         {
             System.out.print("\nJugador"+jg1.getNombre()+"Mano -> ");
             jg1.imprimirMano();
             System.out.print("Linea de juego");
             jg.mostrarLinea();
             System.out.println("Indice de ficha para jugar (0  es el primero): ");
             int ind=r.nextInt(jg1.getMano().size());
             while(jg1.getFicha(ind).getLado1()!=jg.lineaDejuego.get(jg.lineaDejuego.size()-1).getLado2()&&jg1.getFicha(ind).getLado2()!=jg.lineaDejuego.get(0).getLado1()&&!(jg1.getFicha(ind)instanceof FichaComodin))
             {
                 int newInd=r.nextInt(jg1.getMano().size());
                 ind=newInd;
             }
             System.out.println(ind);
             jg.agregarFichaLinea(jg1.getFicha(ind), jg1);
             jg1.removerFicha(jg1.getFicha(ind));
             System.out.println("Nueva linea de juego ->");
             jg.mostrarLinea();
             z1-=1;
         }
         else
         {
             z2=0;
         }
         }
        if(z1==0){System.out.println("Has perdidio :c");}
        else if(z2==0){System.out.println("Felicidades ha ganado c:");}
        
    }

    public static void main(String[] args) {
        Juego j= new Juego();
        j.agregarJugador("Maquina");
        j.agregarJugador("Usuario");
        Jugador j1=j.jugadores.get(0);
        Jugador j2=j.jugadores.get(1);
        Proyecto1.JugadorvsMaquina(j1, j2, j);
        
    }
}
