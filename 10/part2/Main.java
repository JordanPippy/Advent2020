import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    public static final int NUMS = 31;
    public static int[] arr;
    public static int[] original;
    public static int numCombos = 0;
    public static int deviceJoltage;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        arr = new int[NUMS];
        original = new int[NUMS];

        for (int i = 0; i < NUMS; i++)
        {
            arr[i] = scan.nextInt();
            original[i] = arr[i];
        }

        Arrays.sort(arr);
        Arrays.sort(original);
        for (int i = 0; i < NUMS; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        deviceJoltage = arr[NUMS - 1] + 3;
        check(NUMS);

        int index = 0;
        for (int i = 0; i < NUMS; i++)
        {
            arr = new int[NUMS - 1];
            index = 0;
            for (int q = 0; q < NUMS; q++)
            {
                if (q == i)
                    continue;
                arr[index] = original[q];
                index++;
            }
            check(NUMS - 1);
            reset();
        }


        while (1)
        {
            if (first)
            {
                //1 for loop
            }
            if (second)
            {
                // 2 for loop
            }
            if (third)
            {
                // 3 for loop
            }
        }
        System.out.println("Combos: " + numCombos);
    }

    public static void reset()
    {
        arr = new int[NUMS];
        for (int i = 0; i < NUMS; i++)
        {
            arr[i] = original[i];
        }
    }

    public static void check(int size)
    {
        int currentJoltage = 0;
        boolean gucci = true;
        for (int i = 0; i < size; i++)
        {
            if (arr[i] - currentJoltage <= 3)
            {

            }
            else
            {
                gucci = false;
                break;
            }
            currentJoltage = arr[i];
        }
        if (deviceJoltage - original[NUMS - 1] <= 3)
        {

        }
        else
            gucci = false;

        if (gucci)
            numCombos++;
    }
}