
import java.util.Scanner;

public class Numberguessing {
   public Numberguessing() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      int var2 = 0;
      byte var3 = 3;
      byte var4 = 5;
      System.out.println("Welcome to the Guess the Number Game!");
      System.out.println("You have " + var3 + " rounds to play.");
      System.out.println("Each round, you get " + var4 + " attempts to guess the number.");

      for(int var5 = 1; var5 <= var3; ++var5) {
         System.out.println("\n--- Round " + var5 + " ---");
         int var6 = (int)(Math.random() * 100.0) + 1;
         int var7 = 0;
         boolean var8 = false;
         System.out.println("I have chosen a number between 1 and 100. Can you guess it?");

         while(var7 < var4) {
            ++var7;
            System.out.print("Attempt " + var7 + ": Enter your guess: ");
            int var9 = var1.nextInt();
            if (var9 == var6) {
               System.out.println("Congratulations! You guessed the correct number!");
               var8 = true;
               var2 += (var4 - var7 + 1) * 10;
               break;
            }

            if (var9 < var6) {
               System.out.println("Too low! Try again.");
            } else {
               System.out.println("Too high! Try again.");
            }
         }

         if (!var8) {
            System.out.println("Sorry, you've used all your attempts. The number was: " + var6);
         }

         System.out.println("Your current score: " + var2);
      }

      System.out.println("\nGame Over! Your total score: " + var2);
      System.out.println("Thanks for playing!");
      var1.close();
   }
}

