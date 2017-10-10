/** Virtuelles Nim-Spiel
    @author Jan-Lukas Knoch 
    @version 1.2.6 */
    
public class Main
{  
    /**
    Gibt die Spielregeln aus.
    */
    public static void zeigeRegeln()
    {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Regeln: ");
        System.out.println("Es wird mit 17 Hoelzern gestartet.");
        System.out.println("Die Spieler ziehen abwechselnd und muessen jeweils mindesten ein Holz ziehen.");
        System.out.println("Maximal darf die abgerundete Haelfte der insgesamt vorhandenen Hoelzer gezogen werden.");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("");
    }
    
    /**
    Zeigt den aktuellen Spielstand an.
    @param startwert Insgesamt vorhandene Hoelzer
    @param startmaxwert Insgesamt ziehbare Hoelzer
    */
    public static void zeigeSpielstand(int startwert, int startmaxwert)
    {
        String streichholz = "|"; //Zeichen fuer Hoelzer insgesamt
        String streichholzuebrig = "O"; //Zeichen fuer ziehbare Hoelzer
      
        //Ausgabe der gesamten Streichhoelzer
        for (int a = 1; a <= startwert; a++) 
        {
            System.out.print(streichholz);
        }
        System.out.println("");
          
        //Ausgabe der uebrigen Streichhoelzer
        for (int a = 1; a <= startmaxwert; a++) 
        {
            System.out.print(streichholzuebrig);
        }
        if (startwert == 1 ) 
        {
            System.out.print(streichholzuebrig);
        }
        System.out.println("");
    }
      
    /**
    Hauptprogramm
    @param args Liste der Parameter, die beim Programmaufruf angegeben werden.
    */
    public static void main(String[] args)
    {      
        //Vordefinieren der Variablen 
        int startwert = 17; //Hoelzer insgesamt
        int startmaxwert = 8; //Abgerundete Haelfte der insgesamten Hoelzer
        
        zeigeRegeln();
        do
        {
            int checktoken = 0; //Ueberpruefungswert
            int spielerzieht = 0; //Vordefinierte Variable fuer die Spielereingabe
        
            do
            { 
                zeigeSpielstand(startwert, startmaxwert);
          
                //Eingabe des Nutzers 
                spielerzieht = Input.readInt("Wie viele Hoelzer moechtest du ziehen? ");
          
                //Ueberpruefung der Eingabe
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
        
            //Berechnen der uebrigen Hoelzer
            int verbleibendeHoelzer = startwert - spielerzieht;
            startwert = verbleibendeHoelzer;
            startmaxwert = startwert / 2;
        
            //Ueberpruefen der Ausgabe
            if(startwert > 0)
            {
                System.out.println("Es sind noch " + startwert + " Hoelzer vorhanden.");
            }
            else
            {
                System.out.println("Spiel beendet!");
            }
        
        }
        while (startwert > 0);
    }
}