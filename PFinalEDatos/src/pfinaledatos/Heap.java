package pfinaledatos;

public class Heap<E> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<>();
  private java.util.Comparator<? super E> c;
  
  //Creacion de un Heap usando comparable
  public Heap() {
    this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
  }

  //Crecion de Heap usando comparator
  public Heap(java.util.Comparator<E> c) {
    this.c = c;
  }
  
  //Creacion de heap con arreglo de objetos
  public Heap(E[] objects) {
    this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
  }

  //Insertar objeto a heap
  public void add(E newObject) {
    list.add(newObject); // Se anade al arraylist
    int currentIndex = list.size() - 1; //Indice es la ultima posicion

    while (currentIndex > 0) {//Lazo se da hasta que percole a la raiz, caso final.
      int parentIndex = (currentIndex - 1) / 2;//Formula para obtener el indice del padre
      // Percolacion si es mayor al padre
      if (c.compare(list.get(currentIndex),
          list.get(parentIndex)) > 0) {
        E temp = list.get(currentIndex);
        list.set(currentIndex, list.get(parentIndex));
        list.set(parentIndex, temp);
      }
      else
        break; // the tree is a heap now

      currentIndex = parentIndex;
    }
  }

  //Remover la raiz del Heap
  public E remove() {
    if (list.size() == 0) return null;//Heap vacio

    E removedObject = list.get(0);//Raiz se va a remover
    list.set(0, list.get(list.size() - 1));//Se cambia la raiz por la ultima hoja
    list.remove(list.size() - 1);//Se remueve la hoja

    int currentIndex = 0;//Se empieza desde la raiz
    while (currentIndex < list.size()) {//Hasta que no vaya hacia la raiz
      int leftChildIndex = 2 * currentIndex + 1;//Se obtiene hijo izquierdo de raiz nueva
      int rightChildIndex = 2 * currentIndex + 2;//Se obtiene hijo derecho de raiz nueva

      //Encontrar maximo de los dos hijos
      if (leftChildIndex >= list.size()) break; //Si ya no hay hijo izquierdo hay un break
      int maxIndex = leftChildIndex;//Indice maximo
      if (rightChildIndex < list.size()) {
        if (c.compare(list.get(maxIndex),
            list.get(rightChildIndex)) < 0) {
          maxIndex = rightChildIndex;
        }
      }

      // Cambio si el nodo actual es mayor que el maximo
      if (c.compare(list.get(currentIndex), 
      		list.get(maxIndex)) < 0) {
        E temp = list.get(maxIndex);
        list.set(maxIndex, list.get(currentIndex));
        list.set(currentIndex, temp);
        currentIndex = maxIndex;
      }
      else
        break; //Fin de lazo
    }

    return removedObject;
  }

  //Tamano de nodos del arbol
  public int getSize() {
    return list.size();
  }
  
  //Retornar true si Heap esta vacio
  public boolean isEmpty() {
    return list.size() == 0;
  }
}
