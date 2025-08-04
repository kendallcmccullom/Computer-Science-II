package Lists;

import java.util.Scanner;

interface List<E> {
    void add(int index, E item);
    E get(int index);
    int indexOf(E item);
    E removeAt(int index);
    void output();
}

class BCArrayList implements List<E>{
  private Object[] ArrayList = new Object[10];
  private int length = 0;
  private Object previous;
  private Object next;
  private Object returnvalue;
  private Object[] newArrayList;
  
  
  public void add(int index, E item){
    
    //update length, and if it is too large, make the array bigger
    length = length + 1;
    if (ArrayList.length == length){
      newArrayList = new Object[(ArrayList.length * 2)];
      for (int i = 0; i < length-1; i++){
        newArrayList[i] = ArrayList[i];
      }
      ArrayList = newArrayList;
    }
    
    //add if spot is empty
    if (ArrayList[index] == null){
      ArrayList[index] = item;
    }
    //if spot is full, add ans shift all other values right
    else{
      previous = ArrayList[index];
      ArrayList[index] = item;
      
      for (int i = index; ArrayList[i] != null; i++){
        next = ArrayList[i+1];
        ArrayList[i+1] = previous;
        previous = next;
        }
      }
    }
    
  public E get(int index){
    return (E) ArrayList[index];
  }
  
  public int indexOf(E item){
    //loop through list
    for (int i = 0; i < length; i++){
      //if the list item equals return item, return it
      if (ArrayList[i] == item){
        return (i);
      }
    }
    //if nothing is found, return -1
    return(-1);
  }
  
  public E removeAt(int index){
    
    length = length - 1; // update length
    returnvalue = ArrayList[index]; // set return value
    
    //remove value and shift all to left 
    for (int i = index; i < (length); i++){
      ArrayList[i] = ArrayList[i+1];
    }
    ArrayList[length] = null;
    return (E) returnvalue;
  }

  public void output(){
    for (int i = 0; i < length; i++){
    System.out.print(ArrayList[i]+ " ");
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
        java.util.Scanner myScanner = new java.util.Scanner(System.in);
        List<Integer> myList = new BCArrayList<>();
        boolean done = false;
        while (!done) {
            String operation = myScanner.next();
            if (operation.equals("add")) {
                myList.add(myScanner.nextInt(), myScanner.nextInt());
            }
            else if (operation.equals("get")) {
                System.out.println(myList.get(myScanner.nextInt()));
            }
            else if (operation.equals("removeAt")) {
                System.out.println(myList.removeAt(myScanner.nextInt()));
            }
            else if (operation.equals("indexOf")) {
                System.out.println(myList.indexOf(myScanner.nextInt()));
            }
            else if (operation.equals("output")) {
                myList.output();
            }
            else {
                done = true;
            }
        }
    }
}