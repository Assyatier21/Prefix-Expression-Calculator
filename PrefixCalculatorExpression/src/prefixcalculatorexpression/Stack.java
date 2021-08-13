package prefixcalculatorexpression;

public class Stack 
{
    public String[] Stack;
    public int top;
    public int max;
    
    public Stack(int Max)
    {
        max = Max;
        Stack = new String[max];
        top = (-1);
    }
    
    public void Push(String Value)
    {
        if(StackFull() == true)
            System.out.print("");
        else
            Stack[(++top)] = Value;
    }
    
    public String Pop()
    {
        if(StackEmpty() == true)
        {
            return "";
        }
        else
        {
            return (Stack[(top--)]);
        }
    }
    public String peekOperand()
    {
        if(StackEmpty() == true)
        {
            return "";
        }
        else
        {
            return (Stack[top]);
        }
    }
    public String peek()
    {
        if(StackEmpty() == true)
        {
            return "";
        }
        else
        {
            return (Stack[top]);
        }
    }
    
    public boolean StackEmpty()
    {
        return top == -1;
    }
    public boolean StackFull()
    {
        return top == (max - 1);
    }
}
