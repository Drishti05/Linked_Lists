/* You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.*/


import java.util.*;

class ListNode{
    int data;
    ListNode next;
    ListNode(){}
    ListNode(int data){this.data=data;}
    ListNode(int data,ListNode next)
    {
        this.data=data;
        this.next=next;
    }
}
class AddTwoIntegers2{
public static void main(String[] args) {
    ListNode list1,list2,list3;
    System.out.println("Enter the size of List1");
    Scanner sc1= new Scanner(System.in);
    int size1=sc1.nextInt();
    list1=createListNode(size1); 
    System.out.println("The List1:");
    printList(list1);
    System.out.println("The Revesrse List1");
    list1=reverseList(list1);
    printList(list1);
    System.out.println("Enter the size of List2");
    Scanner sc2= new Scanner(System.in);
    int size2=sc2.nextInt();
    list2=createListNode(size2); 
    System.out.println("The List2:");
    printList(list2); 
    System.out.println("The Revesrse List2");
    list2=reverseList(list2);
    printList(list2);
    System.out.println("The List3");
    list3=addTwoNumbers(list1, list2);
    printList(list3);
    System.out.println("The Revesrse List3");
    list3=reverseList(list3);
    printList(list3);

    
}

static ListNode createListNode(int size)
{
    ListNode head=new ListNode();
    ListNode curr=head;
    for(int i=0;i<size;i++)
    {
        System.out.println("Enter the element");
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        curr.next=new ListNode(data);
        curr=curr.next;
    }
    return head.next;
} 

static ListNode reverseList(ListNode list)
{
    ListNode curr=list;
    ListNode prev=null, next=curr;
    while(curr!=null)
    {
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    } 
    return prev;
}

static void printList(ListNode list)
{
    System.out.print("[");
    ListNode curr=list;
    while(curr!=null)
    {
        System.out.print(curr.data);
        curr=curr.next;
    }
    System.out.println("]");

}

static ListNode addTwoNumbers(ListNode l1,ListNode l2)
{
    ListNode head=new ListNode();
    ListNode list1=l1, list2=l2, curr=head;
    int carry=0;
    while(list1!=null||list2!=null)
    {
        int x=(list1!=null)? list1.data:0;
        int y=(list2!=null)? list2.data:0;
        int sum =x+y+carry;
        carry=sum/10;
        curr.next=new ListNode(sum%10);
        curr=curr.next;
        if(list1!=null) list1=list1.next;
        if(list2!=null) list2=list2.next;

    }
    if(carry==1) curr.next=new ListNode(carry);
    return head.next;
}
}