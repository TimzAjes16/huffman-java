package huffman;

import huffman.tree.Leaf;
import huffman.tree.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * A priority queue of @Node@ objects. Each node has an int as its label representing its frequency.
 * The queue should order objects in ascending order of frequency, i.e. lowest first.
 */
public class PQueue {

    private List<Node> queue; // can access this 'queue' attribute with 'this' 
    private int itemsInList = 0;

    public List<Node> getQueue() { // created Getter method to access the queue list for Task 3
        return queue;
    }

    public void setQueue(List<Node> queue) { // created Setter method for access to the queue for Task 3
        this.queue = queue;
    }

    public PQueue() {
        queue = new ArrayList<>(); // each time constructor is called a new queue will be created
    }

    /**
     * Add a node to the queue. The new node should be inserted at the point where the frequency of next node is
     * greater than or equal to that of the new one.
     * @param n The node to enqueue.
     */
    public void enqueue(Node n) {
        // throw new UnsupportedOperationException("Method not implemented");
        /*
         * 1. We need to check if queue is full or at least equal to inital capacity [x]
         * 2. We need to add element to queue in constructtor [x]
         * 3. We want to remove this element from the queue [x]
         * 4. Adding to private data type queue and order setting the pirority varaible [x]
         */

        String checkIfLeaf = n.getClass().getName(); // variable for holding Data on entered Node type.
        // System.out.println(checkIfLeaf); /* alpha-testing variable logic  */
        
        int initialCapicity = 10;
        boolean addedToArray = false;
        
        if (queue.size() == initialCapicity){
            // Then the queue is full, and we cannot add an item.
            System.out.println("Queue is full.");

        } else {
            int sizeofQueue = queue.size();
            if (sizeofQueue == 0){
                queue.add(n);
            } else{
                for(int i=0; i < sizeofQueue; i++){

                    /*
                     * Realised that the following code is for the Leaf Nodes being added to the PQ.
                     * (Need to account for the Branch Nodes as well.) - Task 3
                     */

                     if (checkIfLeaf == "huffman.tree.Leaf"){
                        char LabelOfItem = ((Leaf) queue.get(i)).getLabel(); // casting from 'Node' data type to 'Leaf'
                        int FreqOfItem = queue.get(i).getFreq();
                        System.out.println(n); 

                        // queue.get(i).getFreq(); /* alpha testing variable values */

                        if (addedToArray == false){
                            if (((Leaf) n).getFreq() >= FreqOfItem){
                                queue.add(n);
                                addedToArray = true;
                            } else if (((Leaf) n).getFreq() < FreqOfItem){
                                Node deletedNode = queue.remove(i);
                                queue.add(i,n);
                                queue.add(i+1,deletedNode);
                                addedToArray = true;
                            }
                        } else if (addedToArray == true){
                            if (((Leaf) queue.get(i)).getFreq() >= ((Leaf) queue.get(i+1)).getFreq()){
                                Node deletedNode = queue.remove(i);
                                queue.add(i+1,deletedNode);
                            } else {
                                continue;
                            }
                        }
                     } else if (checkIfLeaf == "huffman.tree.Branch"){
                        // System.out.println("Hello World."); /* alpha testing logic */
                        // if (addedToArray == false){
                        //     queue.add(n);
                        // }

                        int FreqOfItem = queue.get(i).getFreq();

                        if (addedToArray == false){
                            if (((Node) n).getFreq() >= FreqOfItem){
                                queue.add(n);
                                addedToArray = true;
                            } else if (((Node) n).getFreq() < FreqOfItem){
                                Node deletedNode = queue.remove(i);
                                queue.add(i,n);
                                queue.add(i+1,deletedNode);
                                addedToArray = true;
                            }
                        } else if (addedToArray == true){
                            if (((Node) queue.get(i)).getFreq() >= ((Node) queue.get(i+1)).getFreq()){
                                Node deletedNode = queue.remove(i);
                                queue.add(i+1,deletedNode);
                            } else {
                                continue;
                            }
                        }
                        

                     }
                    

                    



                    

                }
            }
            
            
        }

        // System.out.println(String.format("%s", queue, "\n")); /* alpha testing variable values */
        // System.out.println(queue.get(0).getClass().getName()); /* alpha testing variable values for Class Data Type */


    }

    /**
     * Remove a node from the queue.
     * @return  The first node in the queue.
     */
    public Node dequeue() {
        // throw new UnsupportedOperationException("Method not implemented");

        /*
         * Just neeed to implement dequeue which should in theory return the first node of the list.
         * But first I need to check if queue is empty.
         */
        
        if (queue.size() == 0){
            System.out.println("Queue is empty, cannot delete item.");
            return null;
        } else {
            Node deletedNode = queue.remove(0);
            return deletedNode;
            
        }
        
        /*
         * was having errors with the above code due to the fact that if I used a single if block the compiler would 
         * keep telling me to 'return Node', however I realised this was due to the fact that I wasn't returning a value
         * in the first if statement. (I was only printing)
         * 
         * Read further that this could be solved using a return statement in an if-else block of code.
         */
    

    }

    /**
     * Return the size of the queue.
     * @return  Size of the queue.
     */
    public int size() {
        // throw new UnsupportedOperationException("Method not implemented");
        return queue.size();
    }
}
