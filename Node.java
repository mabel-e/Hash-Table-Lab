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