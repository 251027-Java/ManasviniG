import java.util.InputMismatchException;
import java.util.Scanner;

public class GradingExercise
{
    public static void main(String[] args)
    {
        boolean keepLooping = true;
        do
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                IO.println("Input your grade:");
                float grade = sc.nextFloat();
                IO.print("You got ");

                /*if(grade <= 100 && grade >= 90.0)
                    IO.println("an A.");
                else if (grade >= 80.0)
                    IO.println("a B.");
                else if (grade >= 70.0)
                    IO.println("a C.");
                else if (grade >= 60.0)
                    IO.println("a D.");
                else
                    IO.println("a F.");

                 */

                if(grade < 60.0)
                    IO.println("a F.");
                else if(grade < 70.0)
                    IO.println("a D.");
                else if(grade < 80.0)
                    IO.println("a C.");
                else if(grade < 90.0)
                    IO.println("a B.");
                else if(grade < 100.0)
                    IO.println("an A.");

                keepLooping = false;

            }
            catch(InputMismatchException e) {
                IO.println("You didn't input a number. Try again!");
            }
        } while(keepLooping);
    }
}
