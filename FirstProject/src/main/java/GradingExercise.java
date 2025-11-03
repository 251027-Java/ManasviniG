import java.util.InputMismatchException;
import java.util.Scanner;

public class GradingExercise
{
    public static void myGrading()
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

    //addresses edge cases too
    public static void classGrading()
    {
        Scanner sc = new Scanner(System.in);
        double grade = -1;
        boolean invalidInput = true;

        while(invalidInput){
            try{
                IO.print("Please enter a grade (0-100): ");
                grade = sc.nextDouble();
                if(grade >= 0 && grade <= 100) {
                    invalidInput = false;
                } else {
                    IO.println("Value was out of range.");
                }
            } catch(Exception e) {
                IO.println("That wasn't a number!");
                sc.nextLine();
            }
        }
        sc.close();

        if(grade < 60.0) {
            IO.println("You got a F.");
        }
        else if(grade < 70.0) {
            IO.println("You got a D.");
        }
        else if(grade < 80.0) {
            IO.println("You got a C.");
        }
        else if(grade < 90.0) {
            IO.println("You got a B.");
        }
        else {
            IO.println("You got an A.");
        }
    }

    public static void main(String[] args)
    {
        //myGrading();
        classGrading();
    }
}
