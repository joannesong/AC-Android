# Linked Lists!

We know that an algorithm is a sequence of steps. In this lesson we will explore the methods of Linked Lists as an excercise to understand software design in the sense of reference, complexity and its measurement.
 
The building blocks of a linked list are nodes and the list itself is a class with methods on those nodes. Simply put, to create a Linked list in Java you'd need two classes, one for the node or granular element and one for the utility class that performs calculations on those nodes. The List. This utility class will serve as the programming interface for the structure. In this lesson we will create a list that contains numbers, We will explore how the list works and talk about how this list can be modified so that it can manage dogs in a kennel, subscribers to a service, or product inventory as well.

### A Node:

A 'Node' is a singular piece of information and it is the building block of our algorithm. It's essentially a value and an address in memory. A list is a construct composed of a sequence of Node Objects referenced in some way to each other in memory. The runtime complexity of this list's methods can be optimized based on how you build it.

There are different types of linked list depending on their behavior. 
We will focus on a singly linked list: This is a list whose last node always points to null.

We begin with a `Node` who's only attributes are some type of `data` and a `pointer` to another allocation of memory of its same type.
```
class Node { 
    int data; // information held in each element of a linked list. ie. A Type "Customer", "Inventory" or "Dog".
    Node next; // An instance of this class that is used to reference a different Node element. 
}
```

A full implementation of a Node class might look like this:
```
class Node {
    protected int data;
    protected Node next;

    /*  Constructor  */
    public Node() {
        next = null;
        data = 0;
    }

    /*  Constructor  */
    public Node(int d, Node n) {
        data = d;
        next = n;
    }

    /*  Method to set next to next Node  */
    public void setNext(Node n) {
        next = n;
    }

    /*  Method to set data to current Node  */
    public void setData(int d) {
        data = d;
    }

    /*  Method to get next to next node  */
    public Node getNext() {
        return next;
    }

    /*  Method to get data from current Node  */
    public int getData() {
        return data;
    }
}
```

### A List:

A LinkedList Using such a Node might look like this:
```
public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void insertAtStart(int val) {
        Node newNode = new Node(val, null);
        size++;
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void insertAtEnd(int val) {
        Node newNode = new Node(val, null);
        size++;
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void insertAtPos(int val, int pos) {
        Node newNode = new Node(val, null);
        Node node = head;
        pos = pos - 1;
        for (int i = 1; i < size; i++) {
            if (i == pos) {
                Node tmp = node.getNext();
                node.setNext(newNode);
                newNode.setNext(tmp);
                break;
            }
            node = node.getNext();
        }
        size++;
    }

    public void deleteAtPos(int pos) {
        if (pos == 1) {
            head = head.getNext();
            size--;
            return;
        }
        if (pos == size) {
            Node s = head;
            Node t = head;
            while (s != tail) {
                t = s;
                s = s.getNext();
            }
            tail = t;
            tail.setNext(null);
            size--;
            return;
        }
        Node node = head;
        pos = pos - 1;
        for (int i = 1; i < size - 1; i++) {
            if (i == pos) {
                Node tmp = node.getNext();
                tmp = tmp.getNext();
                node.setNext(tmp);
                break;
            }
            node = node.getNext();
        }
        size--;
    }

    public String display() {
        StringBuilder builder = new StringBuilder();

        builder.append("\nSingly Linked List = ");
        if (size == 0) {
            builder.append("empty\n");
            return builder.toString();
        }

        if (head.getNext() == null) {
            builder.append(head.getData());
            return builder.toString();
        }
        Node node;
        builder.append(head.getData()).append("->");
        node = head.getNext();
        while (node.getNext() != null) {
            builder.append(node.getData()).append("->");
            node = node.getNext();
        }
        builder.append(node.getData()).append("\n");
        return builder.toString();
    }
}
```
Above is the list use in the sample project. Don't be put off by what seems like a wall of text. We can see that there are only three fields that contain state in this class: 
```
    private Node head;
    private Node tail;
    private int size;
```

These are the only things that we need to keep track of, a `head` or the start of a list, the `tail`, in other words the last element in the list and its size. 

One of the defining attributes of a linked list is that since we hold a reference to a starting node, inserting an element into this list can be a constant time operation: O(1). In other words, we only need to change a reference of an object in memory to another and this is a really inexpensive operation. Having a tail allows us to do the same to insert an element at the end. 

We can definitely build a list with only a head but adding an element at the end of such a list would be a Linear, or O(N) operation, because we need to traverse the entire list to find the last element and append the element we are adding to it.

This is what adding an element without the tail might look like: Note this method uses a generic as the datatype
```
public void addNode(T data) {
        if (head == null) {
            head = new Node<T>(data); // assigning a value is constant time.
        } else {
            Node<T> curr = head;
            while (curr.getNext() != null) { // traversing through this loop is in the worst case a linear time operation: O(N)
                curr = curr.getNext();
            }
            curr.setNext(new Node<T>(data));
        }
    }
```

Below we are adding at the beginning and at the end. 
Both operations are constant time: O(1) Because we're only changin references
```
    public void insertAtStart(int val) {
        Node newNode = new Node(val, null);
        size++;
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void insertAtEnd(int val) {
        Node newNode = new Node(val, null);
        size++;
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }
```
The Java standard library packages an implementation of a list structure through the `ArrayList` and the `LinkedList` class. The list itself is an old world structure in C, but its understanding through object and algorithm is a strong foundation for interviews.

Note that A `stack` and a `Queue` are both implemented in a simliar way as a linked list; Rather that for each, the nodes are referenced to each other in different ways. 

### `Excercise`:

Study the project included in this lesson, It is a simple app that uses a linked list to add and remove numbers received as input by the user. 

The code is in the numbers package which creates a list specifically meant for numbers only and uses that in the NumbersActiviy. 

Using this as a basis type out a Generic List that can be used by both the `kennel` and the `inventory` package. Then implement the use of this list in one or both of the activities. 

For example create a layout that allows you to create a dog with attributes and add it to a list, give the user the ability to add or remove dogs. The design of such functionality is up to you. 

Remember to add the launcher intent to the activity you are working on. 

Better yet, create an activity with buttons that allows you to choose between which example you want to explore. 

### Resources:
[Linked List example used in application](http://www.sanfoundry.com/java-program-implement-singly-linked-list/)
[Further Reading](https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/)
[Project]()






