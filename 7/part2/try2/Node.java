import java.util.ArrayList;

public class Node
{
    ArrayList<Node> children;
    String val;
    public Node(String val)
    {
        children = new ArrayList<Node>();
        this.val = val;
    }

    public String toString()
    {
        return this.val;
    }
}