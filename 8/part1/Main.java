import java.util.Scanner;

public class Main
{
    static Scanner scan = new Scanner(System.in);
    static String[][] commands = new String[591][2];
    static String[][] dummyCommands = new String[591][2];
    static Boolean[] hasDoneCommand = new Boolean[591];
    static String temp = "";
    static String[] tempArr = {};
    static int index = 0;
    static String current;
    static int offset = 0;
    static int acc = 0;

    public static void main(String[] args)
    {

        while (scan.hasNextLine())
        {
            temp = scan.nextLine();
            tempArr = temp.split(" ");
            commands[index][0] = tempArr[0];
            commands[index][1] = tempArr[1];
            hasDoneCommand[index] = false;
            index++;
        }    
        reset();
        for (int i = 0; i < 591; i++)
        {
            if (commands[i][0].equals("jmp"))
            {
                dummyCommands[i][0] = "nop";
                runSim();
            }
            else if (commands[i][0].equals("nop"))
            {
                dummyCommands[i][0] = "jmp";
                runSim();
            }
            reset();
        }

    }

    public static void reset()
    {
        for (int i = 0; i < 591; i++)
        {
            dummyCommands[i][0] = commands[i][0];
            dummyCommands[i][1] = commands[i][1];
            hasDoneCommand[i] = false;
        }
    }

    public static void runSim()
    {
        index = 0;
        acc = 0;
        while (true)
        {
            if (index == 591)
            {
                System.out.println("WE WIN\nacc is: " + acc);
                System.exit(1);
            }
            String current;
            current = dummyCommands[index][0];
            System.out.println("Doing command: " + current + "| with offset: " + offset + "| index is: " + index);
            offset = Integer.parseInt(dummyCommands[index][1]);
            if (hasDoneCommand[index])
            {
                System.out.println(acc);
                return;
            }
            hasDoneCommand[index] = true;
            if (current.equals("acc"))
            {
                acc += offset;
                index++;
            }
            else if (current.equals("jmp"))
            {
                index += offset;
            }
            else if (current.equals("nop"))
            {
                index++;
            }
        }
    }
}

