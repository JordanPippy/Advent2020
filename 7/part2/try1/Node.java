import java.util.ArrayList;

public class Node
{
    ArrayList<Node> children;
    Node parent;
    String val;
    int num;
    public Node(String val, int num, Node parent)
    {
        children = new ArrayList<Node>();
        this.val = val;
        this.num = num;
        this.parent = parent;
    }

    public String toString()
    {
        return this.val + " " + this.num;
    }
}