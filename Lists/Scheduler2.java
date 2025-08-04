package Lists;

import java.util.*;
import java.util.Scanner;

public class Scheduler2 {
    public static boolean solve(String[] nurses, boolean[][] Nurses) {
      int nursesCovered = keepTrack(nurses);
      //System.out.println(nursesCovered);
      // Base case:
      if (nursesCovered == -1) {
          return true;
      }

      // General:
      else {
 //       int index = 0;
  //      for (int i = 0; i < nurses.length; i++) {
  //        if (nurses[i] != "") {
 //           index += i;
          
            
  //          int nurseTaken = checkShift(index, Nurses, nurses);
            if (checkShift(nursesCovered, Nurses, nurses) == true) {
              
              if (solve(nurses, Nurses)) {
                return true;
              }
            
            
            solve(nurses, Nurses);
            }

            
          
          
        }
        

      return false;
        
      }
      
        
    
    
    
  public static int keepTrack(String[]n) {
    for (int i = 0; i < n.length; i++) {
      if (n[i] == "") {
        return i;
      }
    }
    return -1;
  }
  
    public static boolean checkShift(int n, boolean[][]Nurses, String[]nurses) {
      int counter = 0;
      String name = "";
      int index = 0;
  
      for (int i = 0; i < nurses.length; i++) {
        if (Nurses[n][i] == true && nurses[n] != "") {
          counter += 1;
          index += i;
        }
      }  
      if (counter == 1) {  
        System.out.println(nurses[n] + " " + index);
        nurses[n] = "";
        for (int i = 0; i < nurses.length; i++) {
          System.out.println(nurses[i]);
        }
        return true;
      }
      
      return false;
    }
    
    
      
      

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Number of nurses and shifts
        int N = myScanner.nextInt();
///      System.out.println(N);

        // Tracking hospital schedule
        boolean[] schedule = new boolean[N];

        for (int i = 0; i < N; i++) {
            schedule[i] = false;
//        System.out.print(schedule[i]);
        }
        
        // Making separate arrays for each nurse
        String[] nurses = new String[N];
        boolean[][] Nurses = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            System.out.print(" ");
            String nurseName = myScanner.next();
            nurses[i] = nurseName;
            int K = myScanner.nextInt();
            System.out.println("\n" + nurseName + " " + K);

            int[] shifts = new int[K];
            for (int j = 0; j < K; j++) {
                shifts[j] = myScanner.nextInt();
                System.out.println(shifts[j]);
            }

            Nurse nurseShifts = new Nurse(N, nurseName, K);
            
            Nurses[i] = nurseShifts.indivShifts(shifts);
        }
        
        
        
        
            
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
              System.out.println(Nurses[i][j]);
            }
        }    
        
        solve(nurses, Nurses);
        
    }
}



class Nurse {
  private int number;
  private String name;
  private int availableShifts;
  private boolean[]hospitalShifts;
  
  Nurse (int num, String n, int s) {
    number = num;
    name = n;
    availableShifts = s;
    hospitalShifts = new boolean[number];
  }
  
  public boolean[] indivShifts (int avail[]) { // [0, 2] and there are 3 shifts
    for (int i = 0; i < availableShifts; i++) {
      hospitalShifts[avail[i]] = true;
    }
    return hospitalShifts;
  }
  
  public String toString() {
        String shiftsString = "";
        for (int i = 0; i < number; i++) {
            shiftsString += hospitalShifts[i] + " ";
        }
        return shiftsString;
    }
  
  
}


