package ArraysAndStrings;

public class Intersection 
{

	Node head1, head2;
	 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    Node check(Node node1, Node node2, int differece)
    {
    	Node current1 = node1;
    	Node current2 = node2;
    	
    	for (int i = 0; i < differece; i++) {
            if (current1 == null) {
                return null;
            }
            current1 = current1.next;
        }
    	
    	while (current1 != null && current2 != null)
    	{
    		if (current1.data == current2.data)
    			return current1;
    		current1 = current1.next;
    		current2 = current2.next;
    	}
    	return null;
    }
    
    Node getNode()
    {
    	int count1 = getCount(head1);
    	int count2 = getCount(head2);
    	int difference = 0;
    	
    	if (count1 > count2)
    	{
    		difference = count1 - count2;
    		return check(head1, head2, difference);
    	}
    	else
    	{
    		difference = count2 - count1;
    		return check(head2, head1, difference);
    	}
    }
    
    int getCount(Node node)
    {
    	Node current = node;
    	int count = 0;
    	
    	while (current != null)
    	{
    		count ++;
    		current = current.next;
    	}
    	return count;
    }
	
	public static void main(String[] args) 
	{
		Intersection list = new Intersection();
 
        // creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(15);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);
 
        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);
 
        System.out.println("The node of intersection is " + list.getNode().data);
 
    }
	
}
