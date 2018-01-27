# Linked Lists! Re-listed! W/Stacks and Queues. 

In our [previous lessson](https://github.com/C4Q/AC-Android/blob/master/lessons/linked-lists/kennel-inventory/TheList.4.4.md) we talked about linked lists. They are neat; And the foundation for other structures. We were also introduced to a [project](https://github.com/lighterletter/TheList) which I have updated, by implementing the Linked List with generic input, and adding a `Queue` as well as a `Stack`. The secret to understanding them and the challenge therefore is the understanding of, among fundamental Java concepts, references.

If you have trouble with classes and how Java uses references take a look at  [this](https://stackoverflow.com/questions/9224517/what-are-classes-references-and-objects).

The main idea is to understand what we are doing in creating or modifying these structures, whether it is to add in a Linked List, pop on a Stack, or enqueue in a Queue, the aim is to change a reference that points from one Java object in memory to another. The way in which we do this defines which structure we are working with. 

### Node
The node mentioned in the lesson before is common among these three structures, it is a singular allocation in memory that contains an internal reference to a data Object and an address in memory pointing to another Node.

```java
public class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
```


### Exercise

Take a look at the following structures. Notice how they are used in the sample project, try to make sense of the way pointers (references) are being used in each method this is the key to understanding these structures. 

### Stack

A stack is a LIFO (Last in First out) operation. Which means that the last element you pushed onto the stack is the first one you retrieve with pop. An implementation of a Stack in Java follows:

```java
public class LinkedStack<T> {
    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data, null);
        if (top == null)
            top = newNode;
        else {
            newNode.setNext(top);
            top = newNode;
        }
        size++;
    }

    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        Node<T> node = top;
        top = node.getNext();
        size--;
        return node.getData();
    }

    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return top.getData();
    }

    public List<T> getCurrentStack() {
        List<T> currentStack = new ArrayList<>();
        System.out.print("\nCurrent Stack : ~~~~~");
        if (size == 0) {
            return currentStack; // empty list
        }
        Node<T> node = top;
        while (node != null) {
            currentStack.add(node.getData());
            node = node.getNext();
        }
        System.out.println();
        return currentStack;
    }
}
```

### Queue
Like a line in a grocery store, a Queue is a FIFO (First in First out) operation. Which means that the first element to enter is the first one to leave. The insert operation is technically called Enqueue and the remove operation Dequeue, but I left the example as is for clarity.

```java
public class LinkedQueue<T> {

    protected Node<T> front, rear;
    public int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    /*  Function to insert an element to the queue */
    public void insert(T data) {
        Node<T> newNode = new Node<>(data, null);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = rear.getNext();
        }
        size++;
    }

    /*  Function to remove front element from the queue */
    public T remove() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        Node<T> node = front;
        front = node.getNext();
        if (front == null)
            rear = null;
        size--;
        return node.getData();
    }

    /*  Function to check the front element of the queue */
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return front.getData();
    }

    /*  Function to getCurrentQueue the status of the queue */
    public List<T> getCurrentQueue() {
        List<T> currentQueue = new ArrayList<>();
        System.out.print("\nCurrent Queue: ~~~~~ ");
        if (size == 0) {
            System.out.print("Empty\n");
            return currentQueue; // will be empty.
        }
        Node<T> node = front;
        while (node != rear.getNext()) {
            currentQueue.add(node.getData());
            node = node.getNext();
        }
        return currentQueue;
    }
}

```