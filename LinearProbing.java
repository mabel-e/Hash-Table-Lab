import java.util.*;
import java.io.*;
public class LinearProbing
{
    public class Node
    {
        public Object key;
        public Object value;
        public boolean removed;
        public Node()
        {
            key = null;
            value = null;
        }

        public Node(Object k, Object v)
        {
            key = k;
            value = v;
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
    public LinearProbing()
    {
        initCap = 101;
        data = new Node [initCap];
        size = 0;
        putProbes = 0;
        getProbes = 0;
    }

    public LinearProbing(int cap)
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

        for(int i = 0; i < data.length; i++)
        {
            if(data[m] == null)
            {
                data[m] = n;
                size++;
                return null;
            }
            if((data[m].key).equals(key) && data[m].removed != true)
            {
                Object oldValue = data[m].value;
                data[m] = n;
                return oldValue;
            }
            if(data[m].removed == true)
            {
                data[m] = n;
                m = (m+1)%data.length;
                size++;
                for(int j = i; j < data.length; j++)
                {

                    if(data[m] == null)
                    {
                        return null;
                    }
                    if((data[m].key).equals(key) && data[m].removed != true)

                    {
                        size--;
                        data[m].removed = true;
                        return data[m].value;
                    }
                    m = (m+1)%data.length;
                }
            }
            m = (m+1)%data.length;
            putProbes++;
        }
        return null;
    }

    public Object get(Object key)
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
                return n.value;
            }

            m = (m+1)%data.length;
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
                s += (data[i] + "\n");
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
        LinearProbing h = new LinearProbing(43);
        while(scan.hasNextLine())
        {
            Integer key = scan.nextInt();
            String value = scan.nextLine().trim();
            h.put(key, value);
        }
        System.out.println(h.toString());
    }
}
 