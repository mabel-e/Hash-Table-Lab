import java.util.*;
import java.io.*;
public class Chaining
{
    public class Node
    {
        public Object key;
        public Object value;
        public boolean removed;
        public Node next;

        public Node()
        {
            key = null;
            value = null;
            next = null;
        }

        public Node(Object k, Object v)
        {
            key = k;
            value = v;
            next = null;
        }

        public Node getNextPtr()
        {
            return next;
        }

        public void setNextPtr(Node nxt)
        {
            next = nxt;
        }

        public String toString()
        {
            return "<" + key + "," + value + ">";
        }
    }
    private int initCap;
    private Node data[];
    private int size;
    public int putProbes;
    public int getProbes;
    public Chaining()
    {
        initCap = 101;
        data = new Node [initCap];
        size = 0;
        putProbes = 0;
        getProbes = 0;
    }

    public Chaining(int cap)
    {
        initCap = cap;
        data = new Node [initCap];
        size = 0;
        putProbes = 0;
        getProbes = 0;
    }

    public Object put(Object key, Object value)
    {
        if(size == data.length)
        {
            return null;
        }
        Node n = new Node(key, value);
        int m = key.hashCode()%data.length;

        if(data[m] == null)
        {
            data[m] = n;
            return null;
        }
        if(data[m] != null)
        {
            Node current = data[m];
            while(true)
            {
                if(current.getNextPtr() == null)
                {               
                    current.setNextPtr(n);
                    size++;
                    return null;
                }                
                if(current.getNextPtr().key.equals(key) && current.getNextPtr().removed != true)
                {
                    Object oldValue = current.getNextPtr().value;
                    current.setNextPtr(n);
                    return oldValue;
                }
                Node temp = current.getNextPtr();
                current = temp;
                putProbes++;
            }
        }
        return null;
    }

    public Object get(Object key)
    {
        Node n = null;
        int m = key.hashCode()%data.length;
       

        Node current = new Node();
        current.setNextPtr(data[m]);
        while(current.getNextPtr() != null)
        {
            
            if(current.getNextPtr().key.equals(key) && current.getNextPtr().removed != true)
            {
                n = current.getNextPtr();
                return n.value;                
            }
            current.setNextPtr(current.getNextPtr().getNextPtr());
            getProbes++;
        }
        return null;
    }

    public Object remove(Object key)
    {
        Node n = null;
        int m = key.hashCode()%data.length;
        for(int i = 0; i < data.length; i++)
        {
            if (data[m] == null)
            {
                return null;
            }
            if((data[m].key).equals(key) && data[m].removed != true)
            {
                n = data[m];
                n.removed = true;
                size--;
                return n.value;
            }

            m = (m+1)%data.length;

        }
        return null;
    }

    public String toString()
    {
        String s = "";
        for(int i = 0; i < data.length; i++)
        {
            if(data[i] == null)
            {
                s += (data[i] + "\n");
            }
            else if(data[i].removed == true)
            {
                s += ("dummy" + "\n");
            }
            else
            {
                Node current = new Node();
                current.setNextPtr(data[i]);
                while(current.getNextPtr() != null)
                {
                    s += current.getNextPtr() + ", ";
                    current.setNextPtr(current.getNextPtr().getNextPtr());
                }
                s += "\n";
            }
        }
        return s;
    }

    public void clearProbes()
    {
        getProbes = 0;
    }
    
    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner(new File("Small Data Set.txt"));
        Chaining h = new Chaining(43);
        while(scan.hasNextLine())
        {
            Integer key = scan.nextInt();
            String value = scan.nextLine().trim();
            h.put(key, value);
        }
        System.out.println(h.toString());
    }
}
