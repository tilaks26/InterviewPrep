class Hanoi
{
    
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        tower(n, '1', '2', '3');
    }
    
    public static void tower(int n, char pole1, char pole2, char pole3)
    {
        if (n == 1)
        {
            System.out.println("moving disk "+n+" from pole "+pole1+" to pole "+pole3);
            return;
        }
        
        tower(n-1, pole1, pole3, pole2);
        System.out.println("moving disk "+n+" from pole "+pole1+" to pole "+pole3);
        tower(n-1, pole2, pole1, pole3);
    }
    
}