import java.util.Scanner;
import java.io.File;

public class Main
{
    static File inFile = new File("input.dat");
    static Scanner scan;
    static String bag = "shiny silver";
    static Tree tree = new Tree(bag, 1);
    static int x = 0;
    static int temp = 0;

    public static void main(String[] args) throws Exception
    {
        recursive(bag);
        addingFunction(tree.head);
        System.out.println(x);
    }

    public static void recursive(String lookingFor) throws Exception
    {
        String line;
        String[] lineArr;
        String left = "";
        String[] right = {""};
        scan = new Scanner(inFile);

        while (scan.hasNextLine())
        {
 
            line = scan.nextLine();
            lineArr = line.split("contain ");
            for (int i = 0; i < lineArr.length; i++)
            {
                lineArr[i] = lineArr[i].replace("no other bags.", "done");
                lineArr[i] = lineArr[i].replace(" bags ", "");
                lineArr[i] = lineArr[i].replace(" bags", "");
                lineArr[i] = lineArr[i].replace(" bag ", "");
                lineArr[i] = lineArr[i].replace(" bag", "");
                lineArr[i] = lineArr[i].replace(".", "");
            }

            String[] temp;
            temp = lineArr[1].split(", ");
            left = lineArr[0];
            right = temp;
            //GOT INPUT.....
            if (left.equals(lookingFor))
            {
                for (int i = 0; i < right.length; i++)
                {
                    //put shit on right in tree as child of left.
                    if (right[0].equals("done"))
                    {
                        tree.addChild(left, "done", 0);
                    }
                    else
                    {
                        int num = right[i].charAt(0) - '0';
                        String indexNoNumber = right[i].substring(2, right[i].length());
                        //System.out.println(num + "|" + indexNoNumber);
                        tree.addChild(left, indexNoNumber, num);
                        recursive(indexNoNumber);
                    }
                }
            }
        }
    }

    public static void addingFunction(Node node)
    {
        int temp = 0;
        for (int i = 0; i < node.children.size(); i++)
        {
            addingFunction(node.children.get(i));
        }

 
        System.out.println("bag is: " + node.val);
        for (int i = 0; i < node.children.size(); i++)
        {
            temp += node.children.get(i).num;
        }
        if (temp == 0)
            return;
        System.out.println("Children add up to: " + temp);
        Node tempNode = node;
        while (tempNode != null)
        {
            temp *= tempNode.num;
            System.out.println("mult by parent: " + temp);

            tempNode = tempNode.parent;

        }
        x += temp;
    }
}





















/*
        String line;
        String[] lineArr;
        String left = "";
        String[] right = {""};
        String lookingFor = "";
        scan = new Scanner(inFile);

        while (scan.hasNextLine())
        {
            if (lookingFor.equals(""))
                lookingFor = "shiny gold";
            line = scan.nextLine();
            lineArr = line.split("contain ");
            for (int i = 0; i < lineArr.length; i++)
            {
                lineArr[i] = lineArr[i].replace(" bags ", "");
                lineArr[i] = lineArr[i].replace(" bags", "");
                lineArr[i] = lineArr[i].replace(" bag ", "");
                lineArr[i] = lineArr[i].replace(" bag", "");
                lineArr[i] = lineArr[i].replace(".", "");
            }

            String[] temp;
            temp = lineArr[1].split(", ");
            left = lineArr[0];
            right = temp;
            //GOT INPUT.....
            if (left.equals(lookingFor))
            {
                for (int i = 0; i < right.length; i++)
                {
                    //put shit on right in tree as child of left.
                    int num = right[i].charAt(0) - '0';
                    String indexNoNumber = right[i].substring(2, right[i].length());
                    //System.out.println(num + "|" + indexNoNumber);
                    tree.addChild(left, indexNoNumber, num);
                    didSomething = true;
                }
            }
        }
        System.out.println("YO IM GETTING THE CHILDREN");
        for (int i = 0; i < tree.head.children.size(); i++)
        {
            System.out.println(tree.head.children.get(i));
        }

    }
    */