package prefixcalculatorexpression;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PrefixCalculatorExpression 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int index = 0;
        boolean start = true;
        boolean Check = false;
        String[] TempStr = new String [100];
        double[] TempDouble = new double [100];
        String[] SaveOperand = {"+", "-", "*", "/", ">", ">=", "<", "<=", "^", "==", "!=", "%", "Root", "root", "C", "P", "Log"};    
        
//        System.out.println
//        (   "Berbagai Operand Yang Tersedia : \n" +
//                "1. Penjumlahan   ( + )\n" + 
//                "2. Penngurangan  ( - )\n" +
//                "3. Pembagian     ( / )\n" +
//                "4. Perkalian     ( * )\n" +
//                "5. Perpangkatan  ( ^ )\n" +
//                "6. Kombinasi     ( C )\n" +
//                "7. Permutasi     ( P )\n" +
//                "8. Modulus       ( % )\n" +
//                "9. Unari / Not   ( ! )\n" +
//                "10. Lebih Besar  ( > )\n" +
//                "11. Lebih Kecil  ( < )\n" +
//                "12. Logika Dan   ( && )\n" +
//                "13. Logika Atau  ( || )\n" +
//                "14. Increment    ( ++ )\n" +
//                "15. Decrememnt   ( -- )\n" +
//                "16. Sinus        ( Sin )\n" +
//                "17. Cosinus      ( Cos )\n" +
//                "18. Tangen       ( Tan )\n" +
//                "19. Log10        ( Log )\n" +
//                "20. a Log b      ( Log )\n" +
//                "21. Sama Dengan        ( == )\n" +
//                "22. Tidak Sama Dengan  ( != )\n" +
//                "23. Lebih Besar Sama Dengan ( >= )\n" +
//                "24. Lebih Kecil Sama Dengan ( <= )\n" +
//                "25. Akar        ( Root      || root      )\n" +
//                "26. Faktorial   ( Factorial || factorial )" 
//                );
//      System.out.println("_____________________________________________________\n");

        while(start)
        {
            System.out.print("$ ");
            AlgorithmAndLogical A = new AlgorithmAndLogical();
            String B = input.nextLine();
            String[] C = B.split(" ");
            Stack queue = new Stack (C.length);
            String Operand = C[0];
            
            if(Operand.equalsIgnoreCase("exit"))
                System.exit(0);
            
            if(C.length == 1)
            {
                queue.Push(C[0]);
                A.CheckVariable(queue);
                queue.Pop();
            }
            else if(C.length == 2)
            {
                queue.Push(Operand);
                if(queue.peekOperand().equals("!"))
                {
                    String leftValue = C[1];
                    queue.Push(leftValue);
                    
                    if(leftValue.equalsIgnoreCase("false"))
                        System.out.println("$ true");
                    else if(leftValue.equalsIgnoreCase("true"))
                        System.out.println("$ false");
                    else
                        System.out.println("$ Input Tidak Valid !");
                    queue.Pop();
                    queue.Pop();
                }
                else if(Operand.equalsIgnoreCase("Factorial"))
                {   
                    boolean CheckFactorial = false;
                    double Temp = 0;
                    for(int i = 0; i < TempStr.length; i++)
                    {
                        if(C[1].equals(TempStr[i]))
                        {
                            Temp = TempDouble[i];
                            CheckFactorial = true; 
                            break;
                        }
                        else
                        {
                            CheckFactorial = false;
                        }
                    }
                    if(CheckFactorial == true)
                        System.out.println("$ " + A.Factorial(Temp));
                    
                    else if(CheckFactorial == false)
                    {
                        try
                        {
                            System.out.println("$ " + A.Factorial(Double.valueOf(C[1])));
                        }
                        catch(Exception e)
                        {
                            System.out.println("$ Input Tidak Valid !");
                        }
                    }                    
                }
                else if(Operand.equalsIgnoreCase("Log"))
                {
                    DecimalFormat decimal = new DecimalFormat();
                    boolean CheckLog = false;
                    double Temp = 0;
                    for(int i = 0; i < TempStr.length; i++)
                    {
                        if(C[1].equals(TempStr[i]))
                        {
                            Temp = TempDouble[i];
                            CheckLog = true; 
                            break;
                        }
                        else
                        {
                            CheckLog = false;
                        }
                    }
                    if(CheckLog == true)
                        System.out.println("$ " + decimal.format(Math.log10(Temp)));
                    else if(CheckLog == false)
                    {
                        try
                        {
                            System.out.println("$ " + decimal.format(Math.log10(Double.valueOf(C[1]))));
                        }
                        catch(Exception e)
                        {
                            System.out.println("$ Input Tidak Valid !");
                        }
                    }
                }
                else if(Operand.equals("++") || Operand.equals("--"))
                {
                    DecimalFormat decimal = new DecimalFormat();
                    boolean CheckIncDec = false;
                    double Temp = 0;
                    double Temp2 = 0;
                    
                    for(int i = 0; i < TempStr.length; i++)
                    {
                        if(C[1].equals(TempStr[i]))
                        {
                            Temp = TempDouble[i];
                            CheckIncDec = true; 
                            break;
                        }
                        else
                            CheckIncDec = false;
                    }
                    if(CheckIncDec == true)
                    {
                        if(Operand.equals("++"))
                            System.out.println("$ " + decimal.format(++Temp));
                        else if(Operand.equals("--"))
                            System.out.println("$ " + decimal.format(--Temp));
                    }
                    else if(CheckIncDec == false)
                    {
                        try
                        {
                            Temp2 = Double.valueOf(C[1]);
                            if(Operand.equals("++"))
                                System.out.println("$ " + decimal.format(++Temp2));
                            else if(Operand.equals("--"))
                                System.out.println("$ " + decimal.format(--Temp2));                        
                        }
                        catch(Exception e)
                        {
                            System.out.println("$ Input Tidak Valid !");
                        }
                    }
                }
                else if(Operand.equalsIgnoreCase("Sin") || Operand.equalsIgnoreCase("Cos") || Operand.equalsIgnoreCase("Tan"))
                {
                    DecimalFormat decimal = new DecimalFormat();
                    boolean CheckRadians = false;
                    
                    double Temp = 0;
                    double Temp2 = 0;
                    for(int i = 0; i < TempStr.length; i++)
                    {
                        if(C[1].equals(TempStr[i]))
                        {
                            Temp = TempDouble[i];
                            CheckRadians = true; 
                            break;
                        }
                        else
                        {
                            CheckRadians = false;
                        }
                    }
                    if(CheckRadians == true)
                    {
                        if(Operand.equalsIgnoreCase("Sin"))
                            System.out.println("$ " + decimal.format(Math.sin(Math.toRadians(Temp))));
                        else if(Operand.equalsIgnoreCase("Cos"))
                            System.out.println("$ " + decimal.format(Math.cos(Math.toRadians(Temp))));
                        else if(Operand.equalsIgnoreCase("Tan"))
                            System.out.println("$ " + decimal.format(Math.tan(Math.toRadians(Temp))));
                    }
                    else if(CheckRadians == false)
                    {
                        try
                        {
                            Temp2 = Double.valueOf(C[1]);
                            if(Operand.equalsIgnoreCase("Sin"))
                                System.out.println("$ " + decimal.format(Math.sin(Math.toRadians(Temp2))));
                            else if(Operand.equalsIgnoreCase("Cos"))
                                System.out.println("$ " + decimal.format(Math.cos(Math.toRadians(Temp2))));
                            else if(Operand.equalsIgnoreCase("Tan"))
                                System.out.println("$ " + decimal.format(Math.tan(Math.toRadians(Temp2))));        
                            
                         
                        }
                        catch(Exception e)
                        {
                            System.out.println("$ Input Tidak Valid !");
                        }
                    }
                }
                else
                    System.out.println("$ Input Tidak Valid !");
            }
            else if(C.length == 3)
            {
                Operand = C[0];
                queue.Push(Operand);
                
                if(Operand.equalsIgnoreCase("exit"))
                    System.exit(0);
                else if(Operand.equals("="))
                {
                    TempStr[index] = C[1];
                    try
                    {
                        TempDouble[index] = Double.valueOf(C[2]);
                        String leftValue = C[1];
                        queue.Push(leftValue);
                        String rightValue = C[2];
                        queue.Push(rightValue);
                        A.SaveAritmathicArray(queue, TempStr, TempDouble, index);
                        index++;
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("$ Input Tidak Valid !");
                    }
                    queue.Pop();
                    queue.Pop();
                    queue.Pop();
                }
                else if(Operand.equals("&&") || Operand.equals("||"))
                {
                    try
                    {
                        boolean left = false;
                        boolean right = false;
                        boolean CheckBoolean = true;
                        
                        if(C[1].equalsIgnoreCase("true") || C[1].equalsIgnoreCase("false"))
                            left = Boolean.valueOf(C[1]);
                        else
                            CheckBoolean = false;
                        if(C[2].equalsIgnoreCase("true") || C[2].equalsIgnoreCase("false"))
                            right = Boolean.valueOf(C[2]);  
                        else
                            CheckBoolean = false;
                        
                        if(CheckBoolean == true)
                        {
                            if(Operand.equals("&&"))
                            {
                                System.out.println("$ " + Boolean.logicalAnd(left, right));
                            }
                            if(Operand.equals("||"))
                            {
                                System.out.println("$ " + Boolean.logicalOr(left, right));
                            }
                        }
                        else if(CheckBoolean == false)
                            System.out.println("$ Input Tidak Valid !");                    
                    }
                    catch(Exception e)
                    {
                        System.out.println("$ Input Tidak Valid !");
                    }
                    queue.Pop();
                    queue.Pop();
                    queue.Pop();
                }
                else
                {
                    for(int i = 0; i < SaveOperand.length; i++)
                    {
                        if(C[0].equals(SaveOperand[i]))
                            Check = true;
                    }
                    if(Check == true)
                    {
                        String leftValue = C[1];
                        queue.Push(leftValue);
                        String rightValue = C[2];
                        queue.Push(rightValue);
                        A.Aritmathic(queue);
                        queue.Pop();
                        queue.Pop();
                        queue.Pop();
                    }
                    else
                        System.out.println("$ Input Tidak Valid !");
                }
            }
            else 
                System.out.println("$ Input Tidak Valid !");
        }
    }
}
