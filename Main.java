import java.util.*;

class Main {

  public static void main(String[] args) {
    vchange(100000);
    //System.out.println(((int) (Math.random()*3) + 1));
  }
  
  private static void vchange(int times) {
    int success = 0;
    int fail = 0;
    for(int i = 0; i < times; i++ ) {
      ArrayList<String> vals = new ArrayList<String>();
      vals.add("");
      vals.add("");
      vals.add("");


      int cup = (int) (Math.random()*3) + 1;

      int num = (int) (Math.random()*3) + 1;
      if(cup == num) {
        vals.set(cup-1, "pickball");
      } else {
        vals.set(cup-1, "pick");
        vals.set(num-1, "ball");
      }
      
      if(vals.get(0).equals("")) {
        vals.remove(0);
      } else if(vals.get(1).equals("")) {
        vals.remove(1);
      } else if(vals.get(2).equals("")) {
        vals.remove(2);
      }
      System.out.println(vals.get(0) + ", " + vals.get(1));

      if(vals.get(0).contains("pick") ) {
        
        if(vals.get(0).contains("ball")) {
          vals.set(1, "pick");
          vals.set(0, "ball");
        } else {
          vals.set(1, "pickball");
        }
      } else {
        if(vals.get(1).contains("ball")) {
          vals.set(0, "pick");
          vals.set(1, "ball");

        } else {
          vals.set(0, "pickball");
        }
      }

      if(vals.get(0).equals("pickball") || vals.get(1).equals("pickball")) {
        System.out.println("pickball");
        success++;
      } else {
        System.out.println("fail");
        fail++;
      }
    }
    double percent = success/ ((double) times);
    System.out.println(times + " simulations, " + fail + " fails, " + success + " successes, " + percent*100 + "%");
  }
}