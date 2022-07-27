import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;

class Node
{
    private int data = -1;
    private Node next;

    void setData(int data)
    {
        this.data = data;
    }

    int getData()
    {
        return this.data;
    }

    void setNext(Node next)
    {
        this.next = next;
    }

    Node getNext()
    {
        return this.next;
    }

    Boolean isNotEmpty()
    {
        return !(this.data == -1);
    }

}

class myLinkedList
{
    private Node root = new Node();

    private Node getRoot()
    {
        return this.root;
    }

    public String toString()
    {
        Node currentNode = getRoot();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (currentNode.isNotEmpty())
        {
            String nodeValue = String.valueOf(currentNode.getData());
            if (currentNode.getData()==-2)
            {
                nodeValue = "null";
            }
            sb.append(nodeValue);
            currentNode = currentNode.getNext();
            if (currentNode.isNotEmpty())
            {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    void append(int value)
    {
        if (value < 0)
        {
            throw new IllegalArgumentException("myLinkedList only accepts positive integers");
        }

        Node nodeTraverse = getRoot();
        while (nodeTraverse.isNotEmpty())
        {
            nodeTraverse = nodeTraverse.getNext();
        }
        nodeTraverse.setData(value);
        nodeTraverse.setNext(new Node());
    }

    int getLength()
    {
        Node currentNode = getRoot();
        int size = 0;

        while (currentNode.isNotEmpty())
        {
            size++;
            currentNode = currentNode.getNext();
        }
        return size;
    }

    int pop(int index)
    {
        if (index > getLength()-1 || index < 0)
        {
            throw new IndexOutOfBoundsException("Passed index out of bounds of myLinkedList");
        }

        int traversalIndex = 0;
        Node currentNode = getRoot();
        while (currentNode.isNotEmpty())
        {
            if (traversalIndex == index)
            {
                int result = currentNode.getData();
                remove(index);
                return result;
            }
            currentNode = currentNode.getNext();
            traversalIndex++;
        }
        throw new RuntimeException("Index not found");
    }

    void remove(int index)
    {
        Node currentNode = getRoot();
        int traversalIndex = 0;

        while (currentNode.isNotEmpty())
        {
            if (index == traversalIndex)
            {
                currentNode.setData(-2);
                return;
            }
            currentNode = currentNode.getNext();
            traversalIndex++;
        }
    }

    myLinkedList sort()
    {
        Node currentNode = getRoot();
        ArrayList<Integer> list = new ArrayList<>();

        while (currentNode.isNotEmpty())
        {
            list.add(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        Object[] items = list.toArray();
        Arrays.sort(items);
        myLinkedList newLinkedList = new myLinkedList();
        for (Object i: items)
        {
            newLinkedList.append((int) i);
        }
        return newLinkedList;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        myLinkedList list = new myLinkedList();
    }
}
