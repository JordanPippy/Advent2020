import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    public static final int NUMS = 99;
    public static int[] arr;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int currentJoltage = 0;
        int deviceJoltage;
        int singleJoltDifference = 0;
        int threeJoltDifference = 1;

        arr = new int[NUMS];

        for (int i = 0; i < NUMS; i++)
            arr[i] = scan.nextInt();
        Arrays.sort(arr);
        deviceJoltage = arr[NUMS - 1] + 3;

        for (int i = 0; i < NUMS; i++)
        {
            if (arr[i] - currentJoltage <= 3) //shes a go
            {
                if (arr[i] - currentJoltage == 1)
                    singleJoltDifference++;
                else if (arr[i] - currentJoltage == 3)
                    threeJoltDifference++;

                currentJoltage = arr[i];
            }
        }

        System.out.println("Single Jolt: " + singleJoltDifference);
        System.out.println("Three Jolt: " + threeJoltDifference);
        System.out.println("Multiplied: " + singleJoltDifference * threeJoltDifference);
    }
}