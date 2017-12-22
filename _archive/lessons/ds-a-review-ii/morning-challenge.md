# Morning Challenge

Write a method called `searchLinkedList(Node head, Object target)` that receives the head of a linked list and target search value, and returns `true` if the target is in the list, or `false` if the target is not in the list. What is the worst-case runtime complexity of your algorithm?

```java
Node next;
Object data;

public Node(Object data) { 
    this.value = data;
    this.next = null ;
} 

Node list = new Node("Apple");
list.next = new Node("Orange") 
list.next.next = new Node("Banana");
list.next.next.next = new Node("Carrot");
list.next.next.next.next = new Node("Beet");

searchLinkedList(list, "Apple"); // returns true
searchLinkedList(list, "Pear"); // returns false
```
