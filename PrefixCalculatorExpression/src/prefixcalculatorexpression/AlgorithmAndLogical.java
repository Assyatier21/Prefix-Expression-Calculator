package prefixcalculatorexpression;
import java.text.DecimalFormat;

public class AlgorithmAndLogical 
{
    private static double[] TempDouble =  new double [100];
    private static String[] TempStr = new String[100];
    
    public static int Factorial(double a)
    {
        int Hasil = 1;
         
        if(a % 1 != 0)
        {
            return 0;
        }
        else
        {
            for(int i = 1; i <= a; i++)
            {
                Hasil = i * Hasil;
            }
            return Hasil;
        }
    }
    public static void CheckVariable(Stack X)
    {
        DecimalFormat decimal = new DecimalFormat("#.##");
        for(int i = 0; i < TempStr.length; i++)
        {    
            if(X.peek().equals(TempStr[i]))
            {
                System.out.println("$ " + decimal.format(TempDouble[i]));
                break;
            }
            else
            {
                System.out.println("$ " + X.peek());
                break;
            }
        }
    }
    public void SaveAritmathicArray(Stack X, String[] SaveStr, double[] SaveDouble, int index)
    {   
        DecimalFormat decimal = new DecimalFormat();
        TempStr[index] = SaveStr[index];
        TempDouble[index] = SaveDouble[index];
        System.out.println("$ " + ((TempStr[index])));
    }
    public void Aritmathic(Stack X)
    {
        DecimalFormat decimal = new DecimalFormat("#.##");
        double Hasil = 0;
        decimal.format(Hasil);
        double leftValue = 0, rightValue = 0;
        boolean Check;
        boolean CheckLeft = false;
        boolean CheckRight = false;
        boolean CheckValue1 = false;
        boolean CheckValue2 = false;
        
        try
        {
            for(int i = 0; i < TempStr.length; i++)
            {
                if(X.peek().equals(TempStr[i]))
                {
                    rightValue = TempDouble[i];
                    CheckRight = true;
                    CheckValue1 = true;
                }
            }
            if(CheckValue1 == true)
            {
                X.Pop();
            }
            else
            {
                rightValue = Double.valueOf(X.peek());
                CheckRight = true;
                X.Pop();
            }
            
            
            for(int i = 0; i < TempStr.length; i++)
            {
                if(X.peek().equals(TempStr[i]))
                {
                    leftValue = TempDouble[i];
                    CheckLeft = true;
                    CheckValue2 = true;
                    X.Pop();
                }
                else
                {
                    CheckValue2 = false;
                }
            }
            if(CheckValue2 == true)
            {
                X.Pop();
            }
            else if(CheckValue2 == false)
            {
                leftValue = Double.valueOf(X.peek());
                CheckLeft = true;
                X.Pop();
            }
        }       
        catch (Exception e) 
        {
            if(CheckLeft == false || CheckRight == false)
                System.out.println("$ Input Tidak Valid !");
            else
            {
            }   
        }
        String Operand = X.peekOperand();
        switch(Operand)
        {
            case "+" :
                Hasil = (leftValue + rightValue);
                System.out.println("$ " + decimal.format(Hasil));
                break;
            case "-" :
                Hasil = (leftValue - rightValue);
                System.out.println("$ " + decimal.format(Hasil));
                break;
            case "*" :
                Hasil = (leftValue * rightValue);
                System.out.println("$ " + decimal.format(Hasil));
                break;
            case "/" :
                Hasil = (double)(leftValue / rightValue);
                System.out.println("$ " + decimal.format(Hasil));
                break;
            case ">" :
                if(leftValue > rightValue)
                    Check = true;
                else
                    Check = false;
                System.out.println("$ " + Check);
                break;
            case ">=" :
                if(leftValue >= rightValue)
                    Check = true;
                else
                    Check = false;
                System.out.println("$ " + Check);
                break;
            case "<" :
                if(leftValue < rightValue)
                    Check = true;
                else
                    Check = false;
                System.out.println("$ " + Check);  
                break;
            case "<=" :
                if(leftValue <= rightValue)
                    Check = true;
                else
                    Check = false;
                System.out.println("$ " + Check);    
                break;
            case "==" :
                if(leftValue == rightValue)
                    Check = true;
                else
                    Check = false;
                System.out.println("$ " + Check);    
                break;    
            case "!=" :
                if(rightValue != leftValue)
                    Check = true;
                else
                    Check = false;
                System.out.println("$ " + Check);    
                break;    
            case "%" :
                Hasil = (leftValue % rightValue);
                System.out.println("$ " + decimal.format(Hasil));
                break;
            case "^" :
                Hasil = (Math.pow(leftValue, rightValue));
                System.out.println("$ " + decimal.format(Hasil));
                break;
            case "Root" :
                double Pecahan = (double)(1 / leftValue);
                Hasil = (double)(Math.pow(rightValue, Pecahan));
                System.out.println("$ " + decimal.format(Hasil));
                break;   
            case "root" :
                Pecahan = (double)(1 / leftValue);
                Hasil = (double)(Math.pow(rightValue, Pecahan));
                System.out.println("$ " + decimal.format(Hasil));
                break;  
            case "C" :
                double x = leftValue - rightValue;
                try
                {
                    Hasil = (double)(Factorial(leftValue)/((Factorial(x) * Factorial(rightValue))));
                    System.out.println("$ " + decimal.format(Hasil));
                }
                catch(Exception e)
                {
                    System.out.println("$ Input Tidak Valid !");
                }
                break;               
            case "P" :
                x = leftValue - rightValue;
                try
                {    
                    Hasil = (double)(Factorial(leftValue)/(Factorial(x)));
                    System.out.println("$ " + decimal.format(Hasil));
                }
                catch(Exception e)
                {
                     System.out.println("$ Input Tidak Valid !");
                }
                break;
            case "Log" :
                Hasil = (double)(Math.log(rightValue) / Math.log(leftValue));
                System.out.println("$ " + decimal.format(Hasil));
                break;
        }
    }
}
