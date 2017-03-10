import java.util.Stack;

public class SerializeDeserialize 
{

	public static class TreeNode
	{
		int val;
		TreeNode right;
		TreeNode left;
		
		public TreeNode(int val)
		{
			this.val = val;
		}
	}
	
	public static String serialize(TreeNode root)
	{
		if (root == null)
		{
			return null;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		StringBuilder stringBuilder = new StringBuilder();
		stack.push(root);
		
		while (!stack.isEmpty())
		{
			TreeNode h = stack.pop();
			
			if (h != null)
			{
				stringBuilder.append(h.val+" ");
				stack.push(h.right);
				stack.push(h.left);
			}
			
			else
			{
				stringBuilder.append("#,");
			}
		}
		
		return stringBuilder.toString().substring(0, stringBuilder.length()-1);
	}
	
	public static TreeNode deserialize(String data)
	{
		if (data == null)
		{
			return null;
		}
		
		int[] t = {0};
		String[] arr = data.split(",");
		
		return helper(arr, t);
	}
	
	public static TreeNode helper(String[] arr, int[] t)
	{
		if (arr[t[0]].equals("#"))
		{
			return null;
		}
		
		TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));
		
		t[0] = t[0] + 1;
		root.left = helper(arr, t);
		t[0] = t[0] + 1;
		root.right = helper(arr, t);
		
		return root;
	}
	
}