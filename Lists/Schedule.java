package Lists;



import java.util.Scanner;

class Scheduler {
  class nurse {
    private String name;
    private boolean[] nurseShifts;
    public nurse(String n, int s){
      name = n;
      nurseShifts = new boolean[s];
    }
    public void setShift(int n){
      nurseShifts[n] = true;
    }
    public boolean[] getShifts(){
      return nurseShifts;
    }
    public String getName(){
      return name;
    }
  }
  
  private nurse[] nurseList;
  private String[] filledShifts;
  private int count;
  private int nurseCounter = 0;
  private boolean shiftsFull;
  
  public Scheduler(int s){
    count = s;
    filledShifts = new String[s];
    nurseList = new nurse[s];
  }
  
  public void createNurse(String na, int sh){// create a nurse with name and shift count in the nurse list
    nurseList[nurseCounter] = new nurse(na, sh);
    nurseCounter = nurseCounter + 1;
  }
  
  public void setNurseAvailability(int i, int n){// sets true for the index n on the nurses' specific nurseShift list
    nurseList[i].setShift(n);
  }
  
  public void output(){
    for(int i = 0; i < count; i++){
      for(int j = 0; j < count; j++){
        if (nurseList[i].getName() == filledShifts[j]){
          System.out.println(nurseList[i].getName()+" "+j);
        }
      }
    }
  }
  
  public boolean solve(int nurseNumber){

    //basecase start
    shiftsFull = true;
    
    for (int i = 0; i < count; i++){//if there is an empty shift, then solve() contines
      if (filledShifts[i] == null){
        shiftsFull = false;
        }
    }
    if (shiftsFull == true){
      return true;
      }
    //basecaseend
    
    for (int s = 0; s < count; s++){
      if (filledShifts[s] == null && nurseList[nurseNumber].getShifts()[s] == true){
      filledShifts[s] = nurseList[nurseNumber].getName();
        if (solve(nurseNumber + 1)){ //recursive step, looks at the next nurse
          return true;
          
        }else{
          filledShifts[s] = null;//remove shift if the branch doesnt work out
          }
      }
    }
    return false;//if solve() cannot make a schedule
  }//end solve()

    public static void main(String[] args) {
    	System.out.println("kendall");
    
      java.util.Scanner myScanner = new java.util.Scanner(System.in);
      int nurseAndShiftCount = myScanner.nextInt();//first number
      
      Scheduler mySchedule = new Scheduler(nurseAndShiftCount);//make a schedule
      
      for (int i = 0; i < nurseAndShiftCount; i++){
        mySchedule.createNurse(myScanner.next(), nurseAndShiftCount); //give nurse a name and give them the number of shifts total to make shift array
        
        int NumberOfNurseShifts = myScanner.nextInt();//number of shifts that nurse has
        
        for (int j = 0; j < NumberOfNurseShifts; j++){// for each of the nurse's shifts...
          mySchedule.setNurseAvailability(i,myScanner.nextInt());//add to their schedule
        }
      }
      if(mySchedule.solve(0)){
        mySchedule.output();
      }else{
        System.out.println("impossible");
      }
      
  }//end main
}

//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Schedule {
//    public static boolean solve(Nurse[] nurses, int index, int[] assignments) {
//        // All the shifts have been assigned
//    	System.out.println(Arrays.toString(assignments) + "kkkkk;lad;ljfkadj;lk");
//        if (index >= nurses.length) {
//            return true;
//        }
//        Nurse nurse = nurses[index];
//        for(int shift : nurse.getAvailable()){
//            // Check whether this shift has been selected
//        	System.out.println(shift + "l " + index);
//            boolean flag = false;
//            for(int i=0;i<index;i++){
//            	System.out.println('k');
//                int selected = assignments[i];
//                if(shift == selected){
//                    flag = true;
//                    break;
//                }
//            }
//            System.out.println('w');
//            // If selected, skip
//            if(flag){
//                continue;
//            }
//            // assign this shift
//            assignments[index] = shift;
//            System.out.println(assignments[index]+" index  "+ index);
//            
//            // do it recursively
//            if(solve(nurses, index + 1, assignments)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        java.util.Scanner scanner = new java.util.Scanner(System.in);
//        // read the number of nurses
//        int numberOfNurses = scanner.nextInt();
//        Nurse[] nurses = new Nurse[numberOfNurses];
//        // read the available shift of every nurse
//        for (int i = 0; i < numberOfNurses; i++) {
//            String name = scanner.next();
//            int n = scanner.nextInt();
//            nurses[i] = new Nurse(name, n);
//            for (int j = 0; j < n; j++) {
//                int shift = scanner.nextInt();
//                nurses[i].addShift(shift);
//            }
//        }
//        // assign all shifts
//        int[] assignments = new int[numberOfNurses];
//        if(solve(nurses, 0, assignments)){
//            for(int i=0;i<numberOfNurses;i++){
//                System.out.println(nurses[i].getName() + " " + assignments[i]);
//            }
//        }else{
//            System.out.println("impossible");
//        }
//    }
//
//}
//
//class Nurse {
//    private String name;
//    private Integer[] available;
//    private int l;
//
//    public Nurse(String name, int n) {
//        this.name = name;
//        available = new Integer[n];
//        this.l = 0;
//    }
//
//    public void addShift(Integer x){
//        available[l++] = x;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Integer[] getAvailable() {
//        return available;
//    }
//
//    public int getL() {
//        return l;
//    }
//}
//







////
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.ArrayList;
//
//public class Schedule {
//	
//	public static ArrayList<Integer> assignments;
//	
//	
//    public static boolean solve(Nurse[] nurses, int index, String [] finals) {
//        
//        if (index >= nurses.length) {
//        	
//            return true;
//        }
//        Nurse nurse = nurses[index];
//   
//        for(int shift : nurse.getAvailable()){
//        	
//        	for (int i = 0; i<assignments.size(); i++)
//        	{
//        		if(shift==assignments.get(i)) {
//        			//String name = nurses[index].getName();
//        			finals[index] = (nurses[index].getName() + String.valueOf(shift));
//        			assignments.remove(assignments.get(i));
//        		}
//        	}
//        	
//        	
//        }
//        if(solve(nurses, index + 1, finals)) {
//        	return true;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        java.util.Scanner scanner = new java.util.Scanner(System.in);
//        // read the number of nurses
//        int numberOfNurses = scanner.nextInt();
//        Nurse[] nurses = new Nurse[numberOfNurses];
//        // read the available shift of every nurse
//        for (int i = 0; i < numberOfNurses; i++) {
//            String name = scanner.next();
//            int n = scanner.nextInt();
//            nurses[i] = new Nurse(name, n);
//            for (int j = 0; j < n; j++) {
//                int shift = scanner.nextInt();
//                nurses[i].addShift(shift);
//            }
//        }
//        
//        assignments = new ArrayList<Integer>();
//        for (int i = 0; i<numberOfNurses; i++) {
//        	assignments .add(i);
//
//        }
//       
//        String [] finals = new String[numberOfNurses];
//        
//        if(solve(nurses, 0, finals)){
//            for(int i=0;i<numberOfNurses;i++){
//            	System.out.println(finals[i]);
//            }
//        }else{
//            System.out.println("impossible");
//        }
//    }
//
//
//}
//
//class Nurse {
//    private String name;
//    private Integer[] available;
//    private int l;
//
//    public Nurse(String name, int n) {
//        this.name = name;
//        available = new Integer[n];
//        this.l = 0;
//    }
//
//    public void addShift(Integer x){
//        available[l++] = x;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Integer[] getAvailable() {
//        return available;
//    }
//
//   
//}
//
//
