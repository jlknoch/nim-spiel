/**
Einlesen von Werten der Typen String, int, double
@author Matthias Ebert
@version 1.0
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Input
{
  /** Reads a string from the console.
      @return string entered by the user */
  public static String readString()
  {
    return readString("");
  }
    
    
  /** Reads a string from the console.
      @param prompt text to written before the input
      @return string entered by the user */
  public static String readString(String prompt)
  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String str = "";
    
    try
    {
      System.out.print(prompt);
      str = reader.readLine();
    }
    catch (Exception e)
    {
      System.out.println("Fehler beim Einlesen.");
    }
    
    return str;
  }

  /** Reads an integer number from the console.
      @return number entered by the user */
  public static int readInt()
  {
    return readInt("");
  }
  
  /** Reads an integer number from the console.
      @param prompt text to written before the input
      @return number entered by the user */
  public static int readInt(String prompt)
  {
    int number = 0;
    boolean valid_number = false;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
    do
    {
      try
      {
        System.out.print(prompt);
        number = Integer.parseInt(reader.readLine());
        valid_number = true;
      }
      catch (Exception e)
      {
        System.out.println("Ungültige Eingabe. Keine ganze Zahl.");
      }
    }
    while (!valid_number);
    
    return number;
  }

  /** Reads a double number from the console.
      @return number entered by the user */
  public static double readDouble()
  {
    return readDouble("");
  }

  /** Reads a double number from the console.
      @param prompt text to written before the input
      @return number entered by the user */
  public static double readDouble(String prompt)
  {
    double number = 0;
    boolean valid_number = false;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
    do
    {
      try
      {
        System.out.print(prompt);
        number = Double.parseDouble(reader.readLine());
        valid_number = true;
      }
      catch (Exception e)
      {
        System.out.println("Ungültige Eingabe. Keine Dezimalzahl.");
      }
    }
    while (!valid_number);
    
    return number;
  }
}