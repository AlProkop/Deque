/*
 Aliaksei Prakapenka
 student number 1701212
 */
package deque2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alexeyprokopenko
 */

class MyStack<E>{
    //MyStack is using deque methods
    private Deque<E> deque = new LinkedList<>();
    public E pop(){
        return deque.pop();
    }
    public void push(E e){
        deque.push(e);
    }
    public boolean isEmpty(){
        return deque.isEmpty();
    }

    @Override
    public String toString() {
        System.out.println();
       deque.forEach(el->{System.out.println(el.toString());});
       return "_______";
    }  
}

class MyQueue<E>{
        //MyQueue is using deque methods
    private Deque<E> deque = new LinkedList<>();
    public void add(E e){
        deque.add(e);
    }
    public E remove(){
        return deque.remove();
    }
    @Override
    public String toString() {
       System.out.println();
       deque.forEach(el->{System.out.println(el.toString());});
       return "_______";
    } 
}

class MyList<E>{
    private Deque<E> deque = new LinkedList<>();
    
    public void add(E e, int index){

        Object[] arr = deque.toArray();  //  working with array
        Object[] newArr = new Object[arr.length+1]; // a new array after an element is addded

        if(index >= 0 && index <= arr.length){ //if index is not out of range
            
            //filling new array using 3 phases:
            
            //1. filling array till reaching index=index
            for (int i = 0; i < index; i++){
                newArr[i] = arr[i];
            }
            
            //2. add new element to the spot with index = index
            newArr[index] = e;
            
            //3. keep filling rest of the elements
            for (int i = index; i < arr.length; i++){
                newArr[i+1] = arr[i];
            }
        
            //clearing deque and fill it using elements from newArray
            deque.clear();
            
            for(int i = 0; i<newArr.length; i++){
                deque.add((E)newArr[i]);
            }
        } else System.out.println("Err: Can't add element using index " + index);
        
    }
    
    public E get(int index){
        
        // the method is using Iterator
        Iterator iteratorList = deque.iterator();
        int i = -1;
        while(iteratorList.hasNext()){
            i++;
            if(i==index){
                return (E)iteratorList.next();  
            }
            else 
                iteratorList.next();           
        }
        return null;
    }
    public E remove(int index){
        //almost the same process as in the method add()
        Object[] arr = deque.toArray();
        Object[] newArr = new Object[arr.length-1];
        E remEl = null;

        if(index >= 0 && index < arr.length){
            if(index == 0){
                remEl = (E)arr[0];
                for (int i = 1; i < arr.length; i++){
                    newArr[i-1] = arr[i];
                }           
            }
            else{
                for (int i = 0; i < index; i++){
                    newArr[i] = arr[i];
                }
                remEl = (E)arr[index];
                for (int i = index+1; i < arr.length; i++){
                    newArr[i-1] = arr[i];
                }
            }    
            deque.clear();
            for(int i = 0; i<newArr.length; i++){
                deque.add((E)newArr[i]);
            }
        } else System.out.println("Err: Can't remove element using index " + index);
        return remEl;
    
    }
    
    
    @Override
    public String toString() {
       System.out.println();
       deque.forEach(el->{System.out.println(el.toString());});
       return "_______";
    } 
}

public class Deque2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyStack<String> ms = new MyStack<>();
        System.out.println(ms.isEmpty());
        ms.push("test-1");
        ms.push("test-2");
        ms.push("test-3");

        System.out.println(ms);
        ms.pop();
        System.out.println(ms);
        
        
        MyQueue<Integer> mq = new MyQueue<>();
        mq.add(1);
        mq.add(2);
        mq.add(3);
        mq.add(4);
        System.out.println(mq);
        mq.remove();       
        System.out.println(mq);
        
        
        MyList<String> ml = new MyList<>();
        ml.add("10", 0);
        ml.add("20", 1);
        ml.add("00", 0);
        ml.add("22", 2);
        ml.add("54", 4);
        ml.add("err", -10);
        System.out.println(ml); 
        
        System.out.println("\nGet operation........ index 2: " + ml.get(2));
        System.out.println("\nRemove opration...... index 4: " + ml.remove(4)); 
        System.out.println("\nRemove opration...... index 0: " + ml.remove(0)); 
        System.out.println(ml); 

        
    }
    
}
