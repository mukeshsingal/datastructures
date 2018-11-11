package ds.Queue;

//https://www.callicoder.com/java-priority-queue/

import java.util.PriorityQueue;

public class PriorityQueueInJava {
    public static void main(String[] args) {

        /* Integer Priority Queue */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));

        priorityQueue.add(500);
        priorityQueue.add(200);
        priorityQueue.add(300);
        priorityQueue.add(100);
        priorityQueue.add(400);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }

        /* String Priority Queue */
        PriorityQueue<String> priorityQueue1 = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        priorityQueue1.add("Mukesh");
        priorityQueue1.add("Apple");
        priorityQueue1.add("Vegita");
        priorityQueue1.add("Wonder Women");
        priorityQueue1.add("Splice");

        while (!priorityQueue1.isEmpty()) {
            System.out.println(priorityQueue1.remove());
        }

        /* Priority Queue for User defined objects */
        class Employee implements Comparable<Employee> {
            int id;
            Employee(int id) {
                this.id = id;
            }

            @Override
            public int compareTo(Employee o) {
                return o.id - this.id;
            }
        }

        Employee emp1 = new Employee(1);
        Employee emp2 = new Employee(4);
        Employee emp3 = new Employee(12);

        PriorityQueue<Employee> priorityQueue2 = new PriorityQueue<>();
        priorityQueue2.add(emp3);
        priorityQueue2.add(emp1);
        priorityQueue2.add(emp2);

        while (!priorityQueue2.isEmpty()) {
            System.out.println("EMP " + priorityQueue2.remove().id);
        }
    }
}
