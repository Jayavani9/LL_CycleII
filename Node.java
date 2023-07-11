//Leetcode problem 707. Design Linked List
/*
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 
 */

public class Node {
    int val;
    Node next;
    Node(int x) {
        val = x;
    }
}

class MyLinkedList {
    int len;
    Node head;

    public MyLinkedList() {
        len = 0;
        head = null; // Set head to null to indicate an empty list
    }
    
    public int get(int index) {
        if (index < 0 || index >= len) return -1;
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        len++;
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val); // If the list is empty, add the node at the head
            return;
        }
        
        Node newNode = new Node(val);
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        len++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > len) return;
        if (index <= 0) {
            addAtHead(val); // If the index is 0 or negative, add the node at the head
            return;
        }
        if (index == len) {
            addAtTail(val); // If the index is the length of the list, add the node at the tail
            return;
        }
        
        Node newNode = new Node(val);
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        len++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= len) return;
        if (index == 0) {
            head = head.next; // If the index is 0, delete the head node
            len--;
            return;
        }
        
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        len--;
    }
}
