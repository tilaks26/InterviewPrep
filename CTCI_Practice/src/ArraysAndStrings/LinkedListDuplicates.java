package ArraysAndStrings;

public class LinkedListDuplicates 
{
	
	static Node head;
	 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }

    void printList(Node node) 
    {
        while (node != null) 
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
	public static void main(String[] args) 
	{
		LinkedListDuplicates list = new LinkedListDuplicates();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(12);
        list.head.next.next.next.next.next = new Node(11);
        list.head.next.next.next.next.next.next = new Node(10);
 
        System.out.println("Linked List before removing duplicates ");
        list.printList(head);
 
        list.removeDuplicates();
        System.out.println("");
        System.out.println("Linked List after removing duplicates");
        list.printList(head);
 
    }
	
	public static void removeDuplicates()
	{
		Node pointer1 = head;
		Node duplicate = null;	
		while (pointer1 != null && pointer1.next != null)
		{
			Node pointer2 = pointer1;
			
			while (pointer2.next != null)
			{
				if (pointer1.data == pointer2.data)
				{
					duplicate = pointer2;
					pointer2.next = pointer2.next.next;
				}
				else
				{
					pointer2 = pointer2.next;
				}
			}
		}		
		pointer1 = pointer1.next;
	}
	
}
