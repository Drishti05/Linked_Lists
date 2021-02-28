/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

import java.util.*;
// class to create a node for the linked list
class ListNode{
    int data; // to store the data in the linked list 
    ListNode next; // to store the address of next location of the linked list
    ListNode(){} // Constructor to create node with default values
    ListNode(int data){this.data=data;} // Constructor to create the node with given data
    ListNode(int data,ListNode next){this.data=data;this.next=next;} // Constuctor to create the node with given data and given address of next location

public static void main(String[] args) 
{ 
System.out.println("Enter the number for List1");
    Scanner sc1 = new Scanner(System.in);// To take inut from the user
    int val1 = sc1.nextInt();// Input is stored in a variable
    
System.out.println("Enter the number for List2");
    Scanner sc2 = new Scanner(System.in);// To take input from the user
    int val2 = sc2.nextInt();// Input is stored in the variable
    System.out.println("The First List");
    printList(createList(val1));// Function call to print the list
    System.out.println("The Second List");
    printList(createList(val2));// Function call to print the list

System.out.println("The Third List");
    printList(addTwoNumbers(createList(val1),createList(val2)));// Function call to print the list
}
// Function to calculate the sum of numbers present on the corresponding nodes of the two lists
static ListNode addTwoNumbers(ListNode l1, ListNode l2){  
    int carry=0; // since each node contains single digit so it is to store the carry 
    ListNode dummy_head= new ListNode(); // dummy_head is created to return the head of the list
    ListNode list1=l1 , list2=l2 , curr =dummy_head; // curr is created to traverse in the list
    while(list1!=null || list2!=null) // the loop will run till both the lists aren't empty
    {
        int x = (list1!=null) ? list1.data:0; // if list1 has not traversed completely then store the value of a node in x 
        int y = (list2!=null) ? list2.data:0; // if list2 has not traversed completely then store the value of a node in x 
        int sum = x+y+carry; // sum stores the sum of numbers present at corresponding nodes of the two lists
        curr.next = new ListNode(sum%10); // to create a new node  
        curr = curr.next; // curr will point to the new node
        carry = sum/10; // to extract the carry from the sum
        if(list1!=null) list1=list1.next; // if list1 has not traversed completely then list1 will point its next node
        if(list2!=null) list2=list2.next; // if list2 has not traversed completely then list2 will point its next node
        
    }
    if(carry==1) curr.next = new ListNode(carry); // if both the lists have completely traversed but still carry contains some value
    return dummy_head.next; // head of the list is returned to the calling function
 }
 // Function to create lists for which the user has provided the input
static ListNode createList(int val){
 ListNode list= new ListNode(); // list is created to traverse in the list
        ListNode head= list; // head is created to return the head of list 
        int number=val; // number has the value entered by the user
    do
    {
        int digit =number%10; // extracting the single digit from least significant bit of the number
        number=number/10; // updating the number such that number contains one digit less
        list.next=new ListNode(digit); // creating a new node of the list with extracted digit
        list=list.next; // list will point to the new node
    }while(number>1); // the loop will run till the number doesn't have a decimal value i.e when all the digits of number are extraxcted
    return head.next; // head of the list is returned to the calling function
}
// Function to print the list
static void printList(ListNode l)
{
    ListNode list= new ListNode(); // list is created to traverse the list
    list=l;
    System.out.print("[");
    while(list!=null) // loop to traverse the list until all the nodes are not traversed
    { 
        System.out.print(list.data); // to print the value stord at each node of the list
        list=list.next; // list will point to its next node
    }
    System.out.println("]");
}

}
