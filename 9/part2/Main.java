import java.math.BigInteger;
import java.util.Scanner;

public class Main
{
    public static final int SIZE = 1000;
    public static BigInteger goal = new BigInteger("1398413738");
    public static BigInteger[] arr = new BigInteger[SIZE];

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        BigInteger tempInt;
        String tempString;

        for (int i = 0; i < SIZE; i++)
        {
            tempString = scan.nextLine();
            arr[i] = new BigInteger(tempString);
        }

        for (int i = 0; i < SIZE - 1; i++)
        {
            tempInt = new BigInteger(arr[i].toString());
            for (int j = i + 1; j < SIZE; j++)
            {
                tempInt = tempInt.add(arr[j]);
                if (tempInt.toString().equals(goal.toString()))
                {
                    findMinMax(i, j);
                }
            }
        }
    }

    public static void findMinMax(int i, int j)
    {
        String min = arr[i].toString();
        String max = arr[i].toString();
        for (int k = i; k <= j; k++)
        {
            if (!min.equals(arr[k].min((new BigInteger(min))).toString()))
            {
                min = arr[k].toString();
            }

            if (!max.equals(arr[k].max((new BigInteger(max))).toString()))
            {
                max = arr[k].toString();
            }
        }
        System.out.println("Goal: " + goal.toString());
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Added: " + (new BigInteger(min).add(new BigInteger(max)).toString()));
    }
}