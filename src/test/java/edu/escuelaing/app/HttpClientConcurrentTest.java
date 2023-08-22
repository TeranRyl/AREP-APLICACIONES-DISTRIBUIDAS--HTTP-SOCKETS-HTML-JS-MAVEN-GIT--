package edu.escuelaing.app;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/** ESCUELA COLOMBIANA DE INGENIERIA - ARQUITECTURAS EMPRESARIALES

 Juan Francisco Teran Roman
 21/08/2023

 APLICACIONES DISTRIBUIDAS (HTTP, SOCKETS, HTML, JS,MAVEN, GIT)
 Debe construir una aplicación para consultar la información de películas de cine.
 */

// TALLER 1

public class HttpClientConcurrentTest {
    private static final ConcurrentHashMap<String, String> moviesTest = new ConcurrentHashMap<>();

    /**
     * Server concurrency tests
     * @throws IOException if an error occurs while making the HTTP connection
     */
    @Test
    public void main() throws IOException {
        moviesTest.put("Barbie", "{\"Title\":\"Barbie\",\"Year\":\"2023\",\"Rated\":\"PG-13\",\"Released\":\"21 Jul 2023\",\"Runtime\":\"114 min\",\"Genre\":\"Adventure, Comedy, Fantasy\",\"Director\":\"Greta Gerwig\",\"Writer\":\"Greta Gerwig, Noah Baumbach\",\"Actors\":\"Margot Robbie, Ryan Gosling, Issa Rae\",\"Plot\":\"Barbie suffers a crisis that leads her to question her world and her existence.\",\"Language\":\"English, Spanish\",\"Country\":\"United States, United Kingdom\",\"Awards\":\"2 wins & 1 nomination\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BOWIwZGY0OTYtZjUzYy00NzRmLTg5YzgtYWMzNWQ0MmZiY2MwXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.4/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"88%\"},{\"Source\":\"Metacritic\",\"Value\":\"80/100\"}],\"Metascore\":\"80\",\"imdbRating\":\"7.4\",\"imdbVotes\":\"238,040\",\"imdbID\":\"tt1517268\",\"Type\":\"movie\",\"DVD\":\"N/A\",\"BoxOffice\":\"$541,907,382\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        moviesTest.put("John Wick", "{\"Title\":\"John Wick\",\"Year\":\"2014\",\"Rated\":\"R\",\"Released\":\"24 Oct 2014\",\"Runtime\":\"101 min\",\"Genre\":\"Action, Crime, Thriller\",\"Director\":\"Chad Stahelski, David Leitch\",\"Writer\":\"Derek Kolstad\",\"Actors\":\"Keanu Reeves, Michael Nyqvist, Alfie Allen\",\"Plot\":\"An ex-hitman comes out of retirement to track down the gangsters who killed his dog and stole his car.\",\"Language\":\"English, Russian, Hungarian\",\"Country\":\"United States, United Kingdom, China\",\"Awards\":\"5 wins & 10 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTU2NjA1ODgzMF5BMl5BanBnXkFtZTgwMTM2MTI4MjE@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.4/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"86%\"},{\"Source\":\"Metacritic\",\"Value\":\"68/100\"}],\"Metascore\":\"68\",\"imdbRating\":\"7.4\",\"imdbVotes\":\"707,438\",\"imdbID\":\"tt2911666\",\"Type\":\"movie\",\"DVD\":\"07 Jun 2016\",\"BoxOffice\":\"$43,037,835\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        moviesTest.put("John Wick: Chapter 4", "{\"Title\":\"John Wick: Chapter 4\",\"Year\":\"2023\",\"Rated\":\"R\",\"Released\":\"24 Mar 2023\",\"Runtime\":\"169 min\",\"Genre\":\"Action, Crime, Thriller\",\"Director\":\"Chad Stahelski\",\"Writer\":\"Shay Hatten, Michael Finch, Derek Kolstad\",\"Actors\":\"Keanu Reeves, Laurence Fishburne, George Georgiou\",\"Plot\":\"John Wick uncovers a path to defeating The High Table. But before he can earn his freedom, Wick must face off against a new enemy with powerful alliances across the globe and forces that turn old friends into foes.\",\"Language\":\"English, French, Japanese, Russian, Spanish, Cantonese, German, Latin\",\"Country\":\"Germany, United States\",\"Awards\":\"1 win & 3 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMDExZGMyOTMtMDgyYi00NGIwLWJhMTEtOTdkZGFjNmZiMTEwXkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.8/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"94%\"},{\"Source\":\"Metacritic\",\"Value\":\"78/100\"}],\"Metascore\":\"78\",\"imdbRating\":\"7.8\",\"imdbVotes\":\"262,144\",\"imdbID\":\"tt10366206\",\"Type\":\"movie\",\"DVD\":\"23 May 2023\",\"BoxOffice\":\"$187,131,806\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        moviesTest.put("Saw IV", "{\"Title\":\"Saw IV\",\"Year\":\"2007\",\"Rated\":\"R\",\"Released\":\"26 Oct 2007\",\"Runtime\":\"93 min\",\"Genre\":\"Horror, Mystery, Thriller\",\"Director\":\"Darren Lynn Bousman\",\"Writer\":\"Patrick Melton, Marcus Dunstan, Thomas Fenton\",\"Actors\":\"Tobin Bell, Scott Patterson, Louis Ferreira\",\"Plot\":\"Despite Jigsaw's death, and in order to save the lives of two of his colleagues, Lieutenant Rigg is forced to take part in a new game, which promises to test him to the limit.\",\"Language\":\"English\",\"Country\":\"Canada, United States\",\"Awards\":\"2 wins & 7 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNjc0NjUyNzg3MF5BMl5BanBnXkFtZTYwODMxOTM3._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"5.9/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"18%\"},{\"Source\":\"Metacritic\",\"Value\":\"36/100\"}],\"Metascore\":\"36\",\"imdbRating\":\"5.9\",\"imdbVotes\":\"156,116\",\"imdbID\":\"tt0890870\",\"Type\":\"movie\",\"DVD\":\"22 Jan 2008\",\"BoxOffice\":\"$63,300,095\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        moviesTest.put("Harry Potter and the Chamber of Secrets", "{\"Title\":\"Harry Potter and the Chamber of Secrets\",\"Year\":\"2002\",\"Rated\":\"PG\",\"Released\":\"15 Nov 2002\",\"Runtime\":\"161 min\",\"Genre\":\"Adventure, Family, Fantasy\",\"Director\":\"Chris Columbus\",\"Writer\":\"J.K. Rowling, Steve Kloves\",\"Actors\":\"Daniel Radcliffe, Rupert Grint, Emma Watson\",\"Plot\":\"An ancient prophecy seems to be coming true when a mysterious presence begins stalking the corridors of a school of magic and leaving its victims paralyzed.\",\"Language\":\"English, Latin\",\"Country\":\"United Kingdom, United States\",\"Awards\":\"Won 1 BAFTA Award13 wins & 46 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMjE0YjUzNDUtMjc5OS00MTU3LTgxMmUtODhkOThkMzdjNWI4XkEyXkFqcGdeQXVyMTA3MzQ4MTc0._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.4/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"82%\"},{\"Source\":\"Metacritic\",\"Value\":\"63/100\"}],\"Metascore\":\"63\",\"imdbRating\":\"7.4\",\"imdbVotes\":\"663,189\",\"imdbID\":\"tt0295297\",\"Type\":\"movie\",\"DVD\":\"15 Jan 2008\",\"BoxOffice\":\"$262,641,637\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        moviesTest.put("Halloween II", "{\"Title\":\"Halloween II\",\"Year\":\"1981\",\"Rated\":\"R\",\"Released\":\"30 Oct 1981\",\"Runtime\":\"92 min\",\"Genre\":\"Horror\",\"Director\":\"Rick Rosenthal\",\"Writer\":\"John Carpenter, Debra Hill\",\"Actors\":\"Jamie Lee Curtis, Donald Pleasence, Charles Cyphers\",\"Plot\":\"While Dr. Loomis hunts for Michael Myers, a traumatized Laurie is rushed to Haddonfield Memorial Hospital, and The Shape is not far behind her.\",\"Language\":\"English\",\"Country\":\"United States\",\"Awards\":\"1 win & 3 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMjZmYjg0ODctOTIyYy00YzhkLTgyMzEtNjUyY2JiZjVmYzI2XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"6.5/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"33%\"},{\"Source\":\"Metacritic\",\"Value\":\"40/100\"}],\"Metascore\":\"40\",\"imdbRating\":\"6.5\",\"imdbVotes\":\"96,871\",\"imdbID\":\"tt0082495\",\"Type\":\"movie\",\"DVD\":\"19 Oct 2015\",\"BoxOffice\":\"$25,533,818\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        moviesTest.put("Freddy vs. Jason", "{\"Title\":\"Freddy vs. Jason\",\"Year\":\"2003\",\"Rated\":\"R\",\"Released\":\"15 Aug 2003\",\"Runtime\":\"97 min\",\"Genre\":\"Action, Horror\",\"Director\":\"Ronny Yu\",\"Writer\":\"Wes Craven, Victor Miller, Damian Shannon\",\"Actors\":\"Robert Englund, Ken Kirzinger, Kelly Rowland\",\"Plot\":\"Freddy Krueger and Jason Voorhees return to terrorize the teenagers of Elm Street. Only this time, they're out to get each other, too.\",\"Language\":\"English\",\"Country\":\"Canada, United States\",\"Awards\":\"2 wins & 11 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BODNlNWVjOTMtZjVjYy00MzRjLTg2MmQtNTM3MWVmZjFjYzgwXkEyXkFqcGdeQXVyMzM4MjM0Nzg@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"5.7/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"41%\"},{\"Source\":\"Metacritic\",\"Value\":\"37/100\"}],\"Metascore\":\"37\",\"imdbRating\":\"5.7\",\"imdbVotes\":\"123,528\",\"imdbID\":\"tt0329101\",\"Type\":\"movie\",\"DVD\":\"01 Dec 2012\",\"BoxOffice\":\"$82,633,448\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        moviesTest.put("The Chronicles of Narnia: Prince Caspian", "{\"Title\":\"The Chronicles of Narnia: Prince Caspian\",\"Year\":\"2008\",\"Rated\":\"PG\",\"Released\":\"16 May 2008\",\"Runtime\":\"150 min\",\"Genre\":\"Action, Adventure, Family\",\"Director\":\"Andrew Adamson\",\"Writer\":\"Andrew Adamson, Christopher Markus, Stephen McFeely\",\"Actors\":\"Ben Barnes, Skandar Keynes, Georgie Henley\",\"Plot\":\"The Pevensie siblings return to Narnia, where they are enlisted to once again help ward off an evil king and restore the rightful heir to the land's throne, Prince Caspian.\",\"Language\":\"English\",\"Country\":\"United States, Poland, Slovenia, Czech Republic, United Kingdom\",\"Awards\":\"4 wins & 21 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BM2Q3NWExNjYtM2MwMC00NmM0LTgzZDctMzcxNjE4ZTk5ODA3XkEyXkFqcGdeQXVyNTE1NjY5Mg@@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"6.5/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"66%\"},{\"Source\":\"Metacritic\",\"Value\":\"62/100\"}],\"Metascore\":\"62\",\"imdbRating\":\"6.5\",\"imdbVotes\":\"218,390\",\"imdbID\":\"tt0499448\",\"Type\":\"movie\",\"DVD\":\"01 Jan 2014\",\"BoxOffice\":\"$141,621,490\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        moviesTest.put("Fast & Furious 6", "{\"Title\":\"Fast & Furious 6\",\"Year\":\"2013\",\"Rated\":\"PG-13\",\"Released\":\"24 May 2013\",\"Runtime\":\"130 min\",\"Genre\":\"Action, Adventure, Crime\",\"Director\":\"Justin Lin\",\"Writer\":\"Chris Morgan, Gary Scott Thompson\",\"Actors\":\"Vin Diesel, Paul Walker, Dwayne Johnson\",\"Plot\":\"Hobbs has Dominic and Brian reassemble their crew to take down a team of mercenaries: Dominic unexpectedly gets sidetracked with facing his presumed deceased girlfriend, Letty.\",\"Language\":\"English, Spanish, Russian, Japanese, Cantonese, Dutch, Danish, Ukrainian\",\"Country\":\"United States, Japan, Spain, United Kingdom\",\"Awards\":\"11 wins & 22 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTM3NTg2NDQzOF5BMl5BanBnXkFtZTcwNjc2NzQzOQ@@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.0/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"71%\"},{\"Source\":\"Metacritic\",\"Value\":\"61/100\"}],\"Metascore\":\"61\",\"imdbRating\":\"7.0\",\"imdbVotes\":\"407,595\",\"imdbID\":\"tt1905041\",\"Type\":\"movie\",\"DVD\":\"06 Jan 2015\",\"BoxOffice\":\"$238,679,850\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        moviesTest.put("18 Hours", "{\"Title\":\"18 Hours\",\"Year\":\"2017\",\"Rated\":\"Not Rated\",\"Released\":\"10 Nov 2017\",\"Runtime\":\"70 min\",\"Genre\":\"Drama, Thriller\",\"Director\":\"Njue Kevin\",\"Writer\":\"Njue Kevin\",\"Actors\":\"Nick Ndeda, Sue Wanjiru, Brian Ogola\",\"Plot\":\"A rookie paramedic spends 18 hours in an ambulance for the life of a road crash victim who struggles to be admitted to any hospital.\",\"Language\":\"English, Swahili\",\"Country\":\"Kenya\",\"Awards\":\"2 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNzE1Y2RiZmItMTdjOS00ZTA4LTkxZWMtYmQ4Mjk5ZTY3OWU5XkEyXkFqcGdeQXVyMjU4Njg5NTk@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.0/10\"}],\"Metascore\":\"N/A\",\"imdbRating\":\"7.0\",\"imdbVotes\":\"21\",\"imdbID\":\"tt6892088\",\"Type\":\"movie\",\"DVD\":\"N/A\",\"BoxOffice\":\"N/A\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String[] keys = moviesTest.keySet().toArray(new String[0]);
        Random rand = new Random();
        String userInput;
        for (int i = 0; i < 20; i++) {
            try {
                echoSocket = new Socket("127.0.0.1", 35001);
                out = new PrintWriter(echoSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(
                        echoSocket.getInputStream()));
            } catch (UnknownHostException e) {
                System.err.println("Don’t know about host!.");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn’t get I/O for "
                        + "the connection to: localhost.");
                System.exit(1);
            }



            int index = rand.nextInt(keys.length);
            userInput = keys[index];
            System.out.println("Title: " + userInput);

            String expectedOutput = moviesTest.get(userInput);

            userInput = userInput.replace(" ", "+");
            userInput = userInput.replace(":", "%3A");
            out.println("GET /search?title=" + userInput + " HTTP/1.1");
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine());


            String actualOutput = in.readLine();
            System.out.println(actualOutput);
            System.out.println("Concurrent Test: " + actualOutput.equals(expectedOutput) + "\n\n");
        }

        //manualSearch();


    }




}
