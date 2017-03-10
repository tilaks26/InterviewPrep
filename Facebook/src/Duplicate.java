
public class Duplicate 
{
	static class ListNode 
	{
		 public int val;
		 public ListNode next;
		 ListNode(int x) 
		 { 
			 val = x; next = null; 
		 }
	}
	
	public static ListNode deleteDuplicates(ListNode a) 
	{
	    ListNode current = a;
	    ListNode delete = null;
	    
	    if (a == null)
	    {
	        return null;
	    }
	    
	    while(current.next != null)
	    {
	    	if (current.val == current.next.val)
	    	{
	    	    delete = current.next.next;
	    	    current.next = delete;
	    	}
	    	else
	    	{
	    	    current = current.next;
	    	}
	    }
	    
	    return a;
	}
	
	public static void main(String[] args)
	{
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(1);
		ListNode listNode3 = new ListNode(2);
		ListNode listNode4 = new ListNode(3);
		ListNode listNode5 = new ListNode(3);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		
		ListNode listNode = deleteDuplicates(listNode1);
		
		while (listNode.next != null)
		{
			System.out.println(listNode.next.val);
			listNode = listNode.next;
		}
		
	}
	
}
