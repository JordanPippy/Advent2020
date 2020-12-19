import java.util.ArrayList;

public class Tree
{
    Node head;

    public Tree(String val)
    {
        head = new Node(val);
    }


    public void addChild(String parent, String childName)
    {
        addChildRecrusive(head, parent, childName);
    }

    public void addChildRecrusive(Node node, String parent, String childName)
    {
        if (node.val.equals(parent))
        {
            //found it
            Node temp = new Node(childName);
            node.children.add(temp);
            return;
        }

        for (int i = 0; i < node.children.size(); i++)
        {
            addChildRecrusive(node.children.get(i), parent, childName);
        }
    }


    public String toString()
    {
        return "head: " + head;
    }
}