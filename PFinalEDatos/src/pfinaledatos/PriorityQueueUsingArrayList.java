/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfinaledatos;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class PriorityQueueUsingArrayList<E extends Comparable<E>> {//Tiene que usar comparable con el fin de poder ordenar segun prioridad
    private ArrayList<E> array;
    public PriorityQueueUsingArrayList()//Constructor por default
    {
        array=new ArrayList <E>();
    }

    public void enqueue(E objeto)
    {
      //Uso de algoritmo de insercion
      if(array.size()==0)//Si esta vacio
      {
          array.add(objeto);//Se anade el objeto
      }
      else
      {
      int inversiones=0;
        for(int i=0;i<array.size();i++)
        {
            E ob2=(E)array.get(i);
            if(objeto.compareTo(ob2)==1)//Si el objeto es mayor
            {
                inversiones++;
            }
        }
        array.add(inversiones,objeto);
      }
    }
    public E dequeue()
    {
        E objeto=(E)array.get(array.size()-1);
        array.remove(array.get(array.size()-1));
        return objeto;
    }
    public int getSize() {
    return array.size();
  }

    
}
