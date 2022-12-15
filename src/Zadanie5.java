import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.net.*;
import java.io.*;

public class Zadanie5
{
    public static void main(String[] args) throws IOException {
        int Cyfry = 0;
        try
        {
            System.out.print("Podaj 3 cyfry konta: ");
            Cyfry = Integer.parseInt(new Scanner(System.in).nextLine().substring(0,3));
        }
        catch (Exception e)
        {
            System.out.println("ERROR: Podaj 3 cyfry konta: ");
        }
        URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()));
        String wiersz;
        while((wiersz = buffer.readLine()) != null) {
            if(wiersz.contains(String.valueOf(Cyfry)))
            {
                String[] element = wiersz.split(" ");
                if(element[0].substring(0,3).equals(String.valueOf(Cyfry)))
                {
                    System.out.println(element[0] + " " + element[1] + " " + element[2] + " " + element[3] + " " + element[4]);
                    break;
                }
            }
        }
    }
}
