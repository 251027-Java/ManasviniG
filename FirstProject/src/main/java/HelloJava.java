import java.util.Scanner;

public class HelloJava
{
    public static void main(String[] args)
    {
        IO.println(makeDrawing(7));
        IO.println(makeDrawing(6));
        IO.println(makeDrawing(5));
        IO.println(makeDrawing(4));
        IO.println(makeDrawing(3));
        IO.println(makeDrawing(2));
        IO.println(makeDrawing(1));
        IO.println(makeDrawing(0));
    }

    public static String makeDrawing(int version)
    {
        String drawing = "";
        switch (version) {
            case 7:
                drawing = "";
                break;
            case 6:
                drawing = " _____\n|     |\n|\n|\n|\n|\n|\n|\n|\n==========";
                break;
            case 5:
                drawing = " _____\n|     |\n|    ( )\n|\n|\n|\n|\n|\n|\n==========";
                break;
            case 4:
                drawing = " _____\n|     |\n|    ( )\n|     |\n|     |\n|     |\n|\n|\n|\n==========";
                break;
            case 3:
                drawing = " _____\n|     |\n|    ( )\n|     |\n|    /|\n|     |\n|\n|\n|\n==========";
                break;
            case 2:
                drawing = " _____\n|     |\n|    ( )\n|     |\n|    /|\\ \n|     |\n|\n|\n|\n==========";
                break;
            case 1:
                drawing = " _____\n|     |\n|    ( )\n|     |\n|    /|\\ \n|     |\n|    /\n|\n==========";
                break;
            case 0:
                drawing = " _____\n|     |\n|    ( )\n|     |\n|    /|\\ \n|     |\n|    / \\ \n|\n==========";
                break;
        }
        return drawing;
    }
}