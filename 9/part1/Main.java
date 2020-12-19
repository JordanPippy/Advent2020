import java.math.BigInteger;
import java.util.Scanner;

public class Main
{
    public static final int SIZE = 25;
    public static BigInteger[] arr = new BigInteger[SIZE];

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String tempString = "";
        BigInteger tempInt;
        boolean foundIt = false;

        for (int i = 0; i < SIZE; i++)
        {
            tempString = scan.nextLine();
            arr[i] = new BigInteger(tempString);
        }

        while (true)
        {
            tempString = scan.nextLine();

            for (int i = 0; i < SIZE - 1; i++)
            {
                for (int j = i + 1; j < SIZE; j++)
                {
                    if (i == j)
                        continue;

                    tempInt = arr[i].add(arr[j]);
                    //System.out.println("tempString: " + tempString);
                    //System.out.println("tempInt: " + tempInt);

                    if (tempInt.toString().equals(tempString))
                    {
                        shiftLeft(tempString);
                        foundIt = true;
                        break;
                    }
                }
                if (foundIt)
                    break;
            }
            if (!foundIt)
            {
                System.out.println(tempString);
                System.exit(1);
            }
            foundIt = false;
        }
    }

    public static void shiftLeft(String tempString)
    {
        for (int i = 1; i < SIZE; i++)
            arr[i - 1] = arr[i];

        arr[SIZE - 1] = new BigInteger(tempString);
    }
}