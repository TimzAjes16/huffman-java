package huffman;

import huffman.tree.Leaf;

public class test {
    public static void main(String[] args) {
        PQueue pq = new PQueue();
        pq.dequeue();
        pq.enqueue(new Leaf('a', 42));
        pq.enqueue(new Leaf('b', 1));
        pq.enqueue(new Leaf('c', 101));
        pq.enqueue(new Leaf('d', -101));
        pq.size(); // should equal 4
        pq.dequeue().getFreq(); // should equal 101
        pq.dequeue().getFreq(); // should equal 1
    }
}
