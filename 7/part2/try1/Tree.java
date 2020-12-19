import java.util.ArrayList;

public class Tree
{
    Node head;

    public Tree(String val, int num)
    {
        head = new Node(val, num, null);
    }


    public void addChild(String parent, String childName, int num)
    {
        addChildRecrusive(head, parent, childName, num);
    }

    public void addChildRecrusive(Node node, String parent, String childName, int num)
    {
        if (node.val.equals(parent))
        {
            //found it
            Node temp = new Node(childName, num, node);
            node.children.add(temp);
            return;
        }

        for (int i = 0; i < node.children.size(); i++)
        {
            addChildRecrusive(node.children.get(i), parent, childName, num);
        }
    }


    public String toString()
    {
        return "head: " + head;
    }
}