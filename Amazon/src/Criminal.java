import java.util.ArrayList;

class Criminal
{
    
    private int number;
    
    public Criminal()
    {
        //default constructor
    }
    
    public Criminal(int number)
    {
        this.number = number;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public static void main (String[] args)
    {
        int n = Integer.parseInt(args[0]);
        killMen(n);
    }
    
    public static void killMen(int n)
    {
        
        Criminal killed = new Criminal();
        
        ArrayList<Criminal> criminals = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            criminals.add(new Criminal(i));
        }
        
        while(criminals.size() > 1)
        {
            for (int j = 0; j < criminals.size(); j++)
            {
                killed = criminals.remove((j+1) % criminals.size());
            }
        }
        
        System.out.println(killed.getNumber()+", "+criminals.get(0).getNumber());
        
    }
    
}