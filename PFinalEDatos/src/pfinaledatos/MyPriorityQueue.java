/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfinaledatos;

/**
 *
 * @author charl
 */
public class MyPriorityQueue<E> {
  private Heap<E> heap; 
  
  public MyPriorityQueue() {
    heap = new Heap<E>();
  }
  
  public MyPriorityQueue(java.util.Comparator<E> c) {
    heap = new Heap<E>(c);
  }
  
  public void enqueue(E newObject) {
    heap.add(newObject);
  }

  public E dequeue() {
    return heap.remove();
  }

  public int getSize() {
    return heap.getSize();
  }
}

