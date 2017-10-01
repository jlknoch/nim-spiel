/** Virutelles Nim-Spiel
    @author Jan-Lukas Knoch 
    @version 1.2.2 */

public class Main
{
  public static void main(String[] args)
  {
    // Vordefinieren der Variablen 
    int startwert = 17; //Hölzer insgesamt
    int startmaxwert = 8; //Abgerundete Hälfte der insgesamten Hölzer

    String streichholz = "|"; //Zeichen für Hölzer insgesamt
    String streichholzübrig = "O"; //Zeichen für ziehbare Hölzer
    
    do {
      int checktoken = 0; //Überprüfungswert
      int spielerzieht = 0; //Vordefinierte Variable für die Spielereingabe
      int computerzieht = 0; //Vordefinierte Variable für die Computereingabe
      
      /** USERBEREICH */
      
      do { 
        //Ausgabe der gesamten Streichhölzer
        for (int a = 1; a <= startwert; a++) {
          System.out.print(streichholz);
        }
        System.out.println("");
        
        //Ausgabe der übrigen Streichhölzer
        for (int a = 1; a <= startmaxwert; a++) {
          System.out.print(streichholzübrig);
        }
        if (startwert == 1 ) {
          System.out.print(streichholzübrig);
        }
        System.out.println("");
        
       //Eingabe des Nutzers 
        spielerzieht = Input.readInt("Wie viel Hölzer möchtest du ziehen? ");
        
        /* Überprüfung der Eingabe **/
        if (spielerzieht <= startmaxwert) {
          checktoken = 1;
        } else {
          if(startwert == 1 && spielerzieht == 1) {
           System.out.println("Du hast gewonnen");
           break;
          }
          System.out.println("Bitte geben Sie einen validen Wert ein");
        }
        
      } while (checktoken == 0);
      
      //Berechnen der übrigen Hölzer
      int verbleibendeHölzer = startwert - spielerzieht;
      startwert = verbleibendeHölzer;
      startmaxwert = startwert / 2;
      
      //Überprüfen der Ausgabe
      if (startwert > 0) {
        if (startwert >= 2) {
          System.out.println("Es sind noch " + startwert + " Hölzer vorhanden.");
        }
        else {
          System.out.println("Es ist noch " + startwert + " Holz vorhanden.");
        }
      }
      else {
        System.out.println("Spiel beendet!");
        break;
      }
      
      /** COMPUTERBEREICH */
      
      //Ausgabe der gesamten Streichhölzer für den Computer
      for (int a = 1; a <= startwert; a++) {
        System.out.print(streichholz);
      }
      System.out.println("");
        
      //Ausgabe der übrigen Streichhölzer
      for (int a = 1; a <= startmaxwert; a++) {
        System.out.print(streichholzübrig);
      }
      if (startwert == 1 ) {
        System.out.print(streichholzübrig);
      }
      System.out.println("");
      
      System.out.println("Nun ist der Computer dran.");
      
      //Computer überprüft den maximal ziehbaren Wert und zieht diesen
      if (startwert == 1) {
          computerzieht = 1;
      }
      else {
          computerzieht = startmaxwert;
      }
      
      //Überprüfen des gezogenen Wertes um eine entsprechende Ausgabe zu generieren
      if (computerzieht >= 2) {
          System.out.println("Der Computer hat " + computerzieht + " Hölzer gezogen.");
      }
      else {
          System.out.println("Der Computer hat " + computerzieht + " Holz gezogen.");
      }
      
      //Berechnen der übrigen Hölzer
      startwert = startwert - computerzieht;
      
      //Prüfen ob Hölzer übrig sind
      if (startwert == 0) {
          System.out.println("Der Computer hat gewonnen!");
      }
      else {
          startmaxwert = startwert / 2;
          if (startwert >= 2) {
              System.out.println("Es sind noch " + startwert + " Hölzer vorhanden");
          }
          else {
              System.out.println("Es ist noch " + startwert + " Holz vorhanden");
          }
      }
      
    }
    while (startwert > 0);
  }
}
