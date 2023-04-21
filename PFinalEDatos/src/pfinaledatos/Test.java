/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfinaledatos;

import java.util.Random;

/**
 *
 * @author charl
 */
public class Test {
    private MyPriorityQueue<Integer> pq;
    private PriorityQueueUsingArrayList<Integer> pqar;
    public Test(MyPriorityQueue pq, PriorityQueueUsingArrayList pqar)
    {
        this.pq=pq;
        this.pqar=pqar;
    }
    public Test()
    {
        this.pq=new MyPriorityQueue<Integer>();
        this.pqar=new PriorityQueueUsingArrayList<Integer>();
    }
    /*Falta estopublic int generateRandomnum(int seed)
    {
       Random rand=new Random(seed);
       return Math.abs(rand.nextInt());
    }*/
    public long getPQEnqueuePerformance()
    {
       long t1=System.currentTimeMillis();
       for(int i=5000000;i>0;i--)//Aqui tiene que ser los mismos numeros generados al azar
       {
           pq.enqueue(i);
       }
       long t2=System.currentTimeMillis();
       return (t2-t1);
    }
        public long getPQAREnqueuePerformance()
    {
       long t1=System.currentTimeMillis();
       for(int i=0;i<5000;i++)//Aqui tiene que ser los mismos numeros generados al azar
       {
           pqar.enqueue(i);
       }
       long t2=System.currentTimeMillis();
       return (t2-t1);
    }
            public long getPQDequeuePerformance()
    {
       long t1=System.currentTimeMillis();
       while(pq.getSize()!=0)//Dequeueing
       {
           pq.dequeue();
       }
       long t2=System.currentTimeMillis();
       return (t2-t1);
    }
        public long getPQARDequeuePerformance()
    {
       long t1=System.currentTimeMillis();
       while(pqar.getSize()!=0)//Dequeueing
       {
           pqar.dequeue();
       }
       long t2=System.nanoTime();
       return (t2-t1);
    }
      public long getPQPerformance()
      {
          return this.getPQDequeuePerformance()+this.getPQEnqueuePerformance();
      }
        public long getPQARPerformance()
      {
          return this.getPQARDequeuePerformance()+this.getPQAREnqueuePerformance();
      }    
}
