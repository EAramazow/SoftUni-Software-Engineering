package objectsAndClasses.Lab.DiceExample;

import java.util.Random;

public class Dice {
   private int sides; // скриваме страните

   public int getSides(){    // докопваме private страните
       return sides;
   }

   public void setSides(int number){  // за да придадем нова стойност
       // (Ако искаме само да се вижда стойността изтриваме setSides метода)
       if (number < 0) {
           sides = 1;
       }
       sides = number;
   }
    int roll(){
        Random random = new Random();
        int number = random.nextInt(sides) + 1;
       return number;
    }
}
