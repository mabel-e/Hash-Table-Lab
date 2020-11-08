import java.util.*;
import java.io.*;
public class HashTableTester
{

    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner(new File("Large Data Set.txt"));
        ArrayList<String> list = new ArrayList<>();
        while(scan.hasNextLine())
        {
            String line = scan.nextLine();
            list.add(line);
        }
        scan.close();

        Scanner scan2 = new Scanner(new File("Successful Search.txt"));
        ArrayList<String> list2 = new ArrayList<>();
        while(scan2.hasNextLine())
        {
            String line2 = scan2.nextLine();
            list2.add(line2);
        }
        scan2.close();

        Scanner scan3 = new Scanner(new File("Unsuccessful Search.txt"));
        ArrayList<String> list3 = new ArrayList<>();
        while(scan3.hasNextLine())
        {
            String line3 = scan3.nextLine();
            list3.add(line3);
        }
        scan3.close();

        System.out.println("Linear Probing:");
        double loadfactors[] = new double[]{.1, .5, .8, .9, 1};
        for(int a = 0; a < loadfactors.length; a++)
        {
            double loadfactor = loadfactors[a];
            int capacity = (int) (50000/loadfactor);

            LinearProbing l = new LinearProbing(capacity);
            long putStart = System.currentTimeMillis();
            for(int b = 0; b < list.size(); b++)
            {   
                Integer key = Integer.valueOf(list.get(b).substring(0,8));
                String value = list.get(b).substring(8).trim();
                l.put(key, value);
            }
            long putEnd = System.currentTimeMillis();
            long putTime = putEnd - putStart;

            long successfulStart = System.currentTimeMillis();
            for(int b = 0; b < list2.size(); b++)
            {   
                Integer key = Integer.valueOf(list2.get(b).substring(0,8));
                String value = list2.get(b).substring(8).trim();
                Node n = new Node(key, value);
                l.get(n);
            }
            long successfulEnd = System.currentTimeMillis();
            long successfulTime = successfulEnd - successfulStart;
            int gprobe = l.getProbes;

            l.clearProbes();

            long unsuccessfulStart = System.currentTimeMillis();
            for(int b = 0; b < list2.size(); b++)
            {   
                Integer key = Integer.valueOf(list3.get(b).substring(0,8));
                String value = list3.get(b).substring(8).trim();
                Node n = new Node(key, value);
                l.get(n);
            }
            long unsuccessfulEnd = System.currentTimeMillis();
            long unsuccessfulTime = unsuccessfulEnd - unsuccessfulStart;

            System.out.println("Load Factor: " + loadfactor);
            System.out.println("Insertion Probes: " + l.putProbes);
            System.out.println("Successful Search Probes: " + gprobe);
            System.out.println("Unsuccessful Search Probes: " + l.getProbes);
            System.out.println("Insertion Time: " + putTime);
            System.out.println("Successful Search Time: " + successfulTime);
            System.out.println("Unsuccessful Search Time: " + unsuccessfulTime);
            System.out.println(" ");
        }

        System.out.println("Quadratic Probing:");
        for(int a = 0; a < loadfactors.length; a++)
        {
            double loadfactor = loadfactors[a];
            int capacity = (int) (50000/loadfactor);

            QuadraticProbing q = new QuadraticProbing(capacity);
            long putStart = System.currentTimeMillis();
            for(int b = 0; b < list.size(); b++)
            {   
                Integer key = Integer.valueOf(list.get(b).substring(0,8));
                String value = list.get(b).substring(8).trim();
                q.put(key, value);
            }
            long putEnd = System.currentTimeMillis();
            long putTime = putEnd - putStart;

            long successfulStart = System.currentTimeMillis();
            for(int b = 0; b < list2.size(); b++)
            {   
                Integer key = Integer.valueOf(list2.get(b).substring(0,8));
                String value = list2.get(b).substring(8).trim();
                Node n = new Node(key, value);
                q.get(n);
            }
            long successfulEnd = System.currentTimeMillis();
            long successfulTime = successfulEnd - successfulStart;
            int gprobe = q.getProbes;
            q.clearProbes();

            long unsuccessfulStart = System.currentTimeMillis();
            for(int b = 0; b < list2.size(); b++)
            {   
                Integer key = Integer.valueOf(list3.get(b).substring(0,8));
                String value = list3.get(b).substring(8).trim();
                Node n = new Node(key, value);
                q.get(n);
            }
            long unsuccessfulEnd = System.currentTimeMillis();
            long unsuccessfulTime = unsuccessfulEnd - unsuccessfulStart;

            System.out.println("Load Factor: " + loadfactor);
            System.out.println("Insertion Probes: " + q.putProbes);
            System.out.println("Successful Search Probes: " + gprobe);
            System.out.println("Unsuccessful Search Probes: " + q.getProbes);
            System.out.println("Insertion Time: " + putTime);
            System.out.println("Successful Search Time: " + successfulTime);
            System.out.println("Unsuccessful Search Time: " + unsuccessfulTime);
            System.out.println(" ");
        }

        System.out.println("Pseudo-Random Probing:");

        for(int a = 0; a < loadfactors.length; a++)
        {
            double loadfactor = loadfactors[a];
            int capacity = (int) (50000/loadfactor);

            PseudoRandom l = new PseudoRandom(capacity);
            long putStart = System.currentTimeMillis();
            for(int b = 0; b < list.size(); b++)
            {   
                Integer key = Integer.valueOf(list.get(b).substring(0,8));
                String value = list.get(b).substring(8).trim();
                l.put(key, value);
            }
            long putEnd = System.currentTimeMillis();
            long putTime = putEnd - putStart;

            long successfulStart = System.currentTimeMillis();
            for(int b = 0; b < list2.size(); b++)
            {   
                Integer key = Integer.valueOf(list2.get(b).substring(0,8));
                String value = list2.get(b).substring(8).trim();
                Node n = new Node(key, value);
                l.get(n);
            }
            long successfulEnd = System.currentTimeMillis();
            long successfulTime = successfulEnd - successfulStart;
            int gprobe = l.getProbes;

            l.clearProbes();

            long unsuccessfulStart = System.currentTimeMillis();
            for(int b = 0; b < list2.size(); b++)
            {   
                Integer key = Integer.valueOf(list3.get(b).substring(0,8));
                String value = list3.get(b).substring(8).trim();
                Node n = new Node(key, value);
                l.get(n);
            }
            long unsuccessfulEnd = System.currentTimeMillis();
            long unsuccessfulTime = unsuccessfulEnd - unsuccessfulStart;

            System.out.println("Load Factor: " + loadfactor);
            System.out.println("Insertion Probes: " + l.putProbes);
            System.out.println("Successful Search Probes: " + gprobe);
            System.out.println("Unsuccessful Search Probes: " + l.getProbes);
            System.out.println("Insertion Time: " + putTime);
            System.out.println("Successful Search Time: " + successfulTime);
            System.out.println("Unsuccessful Search Time: " + unsuccessfulTime);
            System.out.println(" ");
        }

        System.out.println("Chaining Probing:");

        for(int a = 0; a < loadfactors.length; a++)
        {
            double loadfactor = loadfactors[a];
            int capacity = (int) (50000/loadfactor);

            Chaining l = new Chaining(capacity);
            long putStart = System.currentTimeMillis();
            for(int b = 0; b < list.size(); b++)
            {   
                Integer key = Integer.valueOf(list.get(b).substring(0,8));
                String value = list.get(b).substring(8).trim();
                l.put(key, value);
            }
            long putEnd = System.currentTimeMillis();
            long putTime = putEnd - putStart;

            long successfulStart = System.currentTimeMillis();
            for(int b = 0; b < list2.size(); b++)
            {   
                Integer key = Integer.valueOf(list2.get(b).substring(0,8));
                String value = list2.get(b).substring(8).trim();
                Node n = new Node(key, value);
                l.get(n);
            }
            long successfulEnd = System.currentTimeMillis();
            long successfulTime = successfulEnd - successfulStart;
            int gprobe = l.getProbes;

            l.clearProbes();

            long unsuccessfulStart = System.currentTimeMillis();
            for(int b = 0; b < list2.size(); b++)
            {   
                Integer key = Integer.valueOf(list3.get(b).substring(0,8));
                String value = list3.get(b).substring(8).trim();
                Node n = new Node(key, value);
                l.get(n);
            }
            long unsuccessfulEnd = System.currentTimeMillis();
            long unsuccessfulTime = unsuccessfulEnd - unsuccessfulStart;

            System.out.println("Load Factor: " + loadfactor);
            System.out.println("Insertion Probes: " + l.putProbes);
            System.out.println("Successful Search Probes: " + gprobe);
            System.out.println("Unsuccessful Search Probes: " + l.getProbes);
            System.out.println("Insertion Time: " + putTime);
            System.out.println("Successful Search Time: " + successfulTime);
            System.out.println("Unsuccessful Search Time: " + unsuccessfulTime);
            System.out.println(" ");
        }
    }}