import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import bby.algorithms.dynamic.programming.Fibonacci;

public class Main {
    public static void main(String[] args) {
//        LinkedList<String> list = new LinkedList<>();
//        list.append("A");
//        list.append("B");
//        list.append("C");
//        list.append("D");
//        list.printList();
//        if (
//        list.contains("C")){
//            System.out.println("List contains ");
//        }
//        else {
//            System.out.println("List does not contain ");
//        }
//
//        list.recursionReverse();
//        list.printList();

//        Queue<String> queue = new Queue<>();
//        queue.enqueue("A");
//        queue.enqueue("B");
//        queue.enqueue("C");
//        queue.enqueue("D");
//        queue.enqueue("E");
//
//        System.out.println("Size: " + queue.size);
//        System.out.println("Front: " + queue.front.data);
//        System.out.println("Back: " + queue.back.data);
//
//        String deq = queue.dequeue();
//        System.out.println("Dequeue: " + deq);
//        System.out.println("Dequeue: " + queue.dequeue());
//        System.out.println("Dequeue: " + queue.dequeue());
//        System.out.println("Dequeue: " + queue.dequeue());
//
//        System.out.println("Size after dequeue: " + queue.size);
//        System.out.println("Back after dequeue: " + queue.back.data);

//        Stack<String> stack = new Stack<>();
//        stack.push("A");
//        stack.push("B");
//        stack.push("C");
//
//        System.out.println("Top: " + stack.top.data);
//
//        String popped = stack.pop();
//        System.out.println("Popped: " + popped);
//        System.out.println("New Top: " + stack.top.data);
//        System.out.println("Size: " + stack.size);
//
//        popped = stack.pop();
//        System.out.println("Popped: " + popped);
//        System.out.println("New Top: " + stack.top.data);
//        System.out.println("Size: " + stack.size);
//
//        popped = stack.pop();
//        System.out.println("Popped: " + popped);
//        System.out.println("New Top: " + (stack.top != null ? stack.top.data : "null"));
//        System.out.println("Size: " + stack.size);

//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("A");
//        arrayList.add("B");
//        arrayList.add("C");
//
//
//        System.out.println(arrayList.get(0).hashCode());
//        System.out.println(arrayList.get(1).hashCode());
//        System.out.println(arrayList.get(2).hashCode());
//
//
//
//        HashSet<String> hashSet = new HashSet<>();
//        hashSet.add("A");
//        hashSet.add("B");
//        hashSet.add("C");
//
//        System.out.println(hashSet);
//
//        HashMap<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("A", 1);
//        hashMap.put("B", 2);

        int result = Fibonacci.fib(6);
        int result2 = Fibonacci.fib(7);
        int result3 = Fibonacci.fib(8);
        int result4 = Fibonacci.fib(9);
        int result5 = Fibonacci.fib(50);


        System.out.println("Fibonacci of 6 is: " + result);
        System.out.println("Fibonacci of 7 is: " + result2);
        System.out.println("Fibonacci of 8 is: " + result3);
        System.out.println("Fibonacci of 9 is: " + result4);
        System.out.println("Fibonacci of 9 is: " + result5);

    }
}