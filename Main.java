/** Virtuelles Nim-Spiel
    @author Jan-Lukas Knoch 
    @version 1.2.1 */

public class Main
{
    
  public static void zeigeSpielstand (int startwert, int startmaxwert)
  {
      String streichholz = "|"; //Zeichen für Hölzer insgesamt
      String streichholzübrig = "O"; //Zeichen für ziehbare Hölzer
    
      //Ausgabe der gesamten Streichhölzer
      for (int a = 1; a <= startwert; a++) 
      {
          System.out.print(streichholz);
      }
      System.out.println("");
        
      //Ausgabe der übrigen Streichhölzer
      for (int a = 1; a <= startmaxwert; a++) 
      {
          System.out.print(streichholzübrig);
      }
      if (startwert == 1 ) 
      {
          System.out.print(streichholzübrig);
      }
      System.out.println("");
  }
    
  
  public static void main(String[] args)
  {
      // Vordefinieren der Variablen 
      int startwert = 17; //Hölzer insgesamt
      int startmaxwert = 8; //Abgerundete Hälfte der insgesamten Hölzer
    
      do
      {
          int checktoken = 0; //Überprüfungswert
          int spielerzieht = 0; //Vordefinierte Variable für die Spielereingabe
      
          do
          { 
              zeigeSpielstand(startwert, startmaxwert);
        
              //Eingabe des Nutzers 
              spielerzieht = Input.readInt("Wie viel Hölzer möchtest du ziehen? ");
        
              /* Überprüfung der Eingabe **/
              if (spielerzieht <= startmaxwert) 
              {
                  checktoken = 1;
              } 
              else 
              {
                  if(spielerzieht == startwert) 
                  {
                      System.out.println("Du hast gewonnen");
                      break;
                  }
                  System.out.println("Bitte geben Sie einen validen Wert ein");
              }
        
          } 
          while (checktoken == 0);
      
          //Berechnen der übrigen Hölzer
          int verbleibendeHölzer = startwert - spielerzieht;
          startwert = verbleibendeHölzer;
          startmaxwert = startwert / 2;
      
          //Überprüfen der Ausgabe
          if(startwert > 0)
          {
              System.out.println("Es sind noch " + startwert + " Hölzer vorhanden.");
          }
          else
          {
              System.out.println("Spiel beendet!");
          }
      
      }
      while (startwert > 0);
  }
}
