package edu.escuelaing.app;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/** ESCUELA COLOMBIANA DE INGENIERIA - ARQUITECTURAS EMPRESARIALES

 Juan Francisco Teran Roman
 21/08/2023

 APLICACIONES DISTRIBUIDAS (HTTP, SOCKETS, HTML, JS,MAVEN, GIT)
 Debe construir una aplicación para consultar la información de películas de cine.

 https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-TALLER-1
 */

// TALLER 1

public class AppTest extends TestCase {
    private App app;

    public void scene(){
        app = new App();
    }

    /**
     * Try the "getTitle" method of the "HttpServer" class.
     * This test verifies that the method returns the correct result when fetching the information of a movie in JSON format.
     */
    @Test
    public void testgetTitle() throws IOException {
        scene();
        assertEquals("HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json\r\n"
                + "\r\n"
                + "{\"Title\":\"Hola\",\"Year\":\"2005\",\"Rated\":\"N/A\",\"Released\":\"01 Mar 2005\",\"Runtime\":\"61 min\",\"Genre\":\"N/A\",\"Director\":\"Ana Ynsaurralde\",\"Writer\":\"Ana Ynsaurralde\",\"Actors\":\"Raquel Adoler, Julieta Buschiazzo, Gabriel Coba\",\"Plot\":\"N/A\",\"Language\":\"Spanish\",\"Country\":\"Argentina\",\"Awards\":\"N/A\",\"Poster\":\"N/A\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"5.2/10\"}],\"Metascore\":\"N/A\",\"imdbRating\":\"5.2\",\"imdbVotes\":\"5\",\"imdbID\":\"tt0451761\",\"Type\":\"movie\",\"DVD\":\"N/A\",\"BoxOffice\":\"N/A\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}", app.getTitle("Hola"));

        assertEquals("HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json\r\n"
                + "\r\n"
                + "{\"Title\":\"Guardians of the Galaxy\",\"Year\":\"2014\",\"Rated\":\"PG-13\",\"Released\":\"01 Aug 2014\",\"Runtime\":\"121 min\",\"Genre\":\"Action, Adventure, Comedy\",\"Director\":\"James Gunn\",\"Writer\":\"James Gunn, Nicole Perlman, Dan Abnett\",\"Actors\":\"Chris Pratt, Vin Diesel, Bradley Cooper\",\"Plot\":\"A group of intergalactic criminals must pull together to stop a fanatical warrior with plans to purge the universe.\",\"Language\":\"English\",\"Country\":\"United States\",\"Awards\":\"Nominated for 2 Oscars. 52 wins & 103 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNDIzMTk4NDYtMjg5OS00ZGI0LWJhZDYtMzdmZGY1YWU5ZGNkXkEyXkFqcGdeQXVyMTI5NzUyMTIz._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.0/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"92%\"},{\"Source\":\"Metacritic\",\"Value\":\"76/100\"}],\"Metascore\":\"76\",\"imdbRating\":\"8.0\",\"imdbVotes\":\"1,233,785\",\"imdbID\":\"tt2015381\",\"Type\":\"movie\",\"DVD\":\"15 Nov 2015\",\"BoxOffice\":\"$333,718,600\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}", app.getTitle("Guardians+of+the+galaxy"));

        assertEquals("HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json\r\n"
                + "\r\n"
                + "{\"Title\":\"The Avengers\",\"Year\":\"2012\",\"Rated\":\"PG-13\",\"Released\":\"04 May 2012\",\"Runtime\":\"143 min\",\"Genre\":\"Action, Sci-Fi\",\"Director\":\"Joss Whedon\",\"Writer\":\"Joss Whedon, Zak Penn\",\"Actors\":\"Robert Downey Jr., Chris Evans, Scarlett Johansson\",\"Plot\":\"Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.\",\"Language\":\"English, Russian\",\"Country\":\"United States\",\"Awards\":\"Nominated for 1 Oscar. 38 wins & 80 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.0/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"91%\"},{\"Source\":\"Metacritic\",\"Value\":\"69/100\"}],\"Metascore\":\"69\",\"imdbRating\":\"8.0\",\"imdbVotes\":\"1,426,217\",\"imdbID\":\"tt0848228\",\"Type\":\"movie\",\"DVD\":\"22 Jun 2014\",\"BoxOffice\":\"$623,357,910\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}", app.getTitle("The+Avengers"));

        assertEquals("HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json\r\n"
                + "\r\n"
                + "{\"Title\":\"Mario Bros\",\"Year\":\"2010\",\"Rated\":\"Not Rated\",\"Released\":\"07 Feb 2010\",\"Runtime\":\"N/A\",\"Genre\":\"Short, Comedy, Fantasy\",\"Director\":\"Marcus Mero\",\"Writer\":\"Marcus Mero\",\"Actors\":\"Matt Hamilton, Drew Falabella, Justin Mero, Sarah Hamilton\",\"Plot\":\"Mario and Luigi are sent on a mission to save Princess Peach.\",\"Language\":\"English\",\"Country\":\"USA\",\"Awards\":\"N/A\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BOGJkZGRkMzctODIwOC00NTJhLTlhNmMtMGNhOTIwYzlhNzE2XkEyXkFqcGdeQXVyNTc4OTc4OTI@._V1_SX300.jpg\",\"Ratings\":[],\"Metascore\":\"N/A\",\"imdbRating\":\"N/A\",\"imdbVotes\":\"N/A\",\"imdbID\":\"tt7747230\",\"Type\":\"movie\",\"DVD\":\"N/A\",\"BoxOffice\":\"N/A\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}", app.getTitle("Mario+Bros"));

        assertEquals("HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json\r\n"
                + "\r\n"
                + "{\"Title\":\"Pokemon 4Ever: Celebi - Voice of the Forest\",\"Year\":\"2001\",\"Rated\":\"G\",\"Released\":\"11 Oct 2002\",\"Runtime\":\"75 min\",\"Genre\":\"Animation, Action, Adventure\",\"Director\":\"Kunihiko Yuyama, Jim Malone\",\"Writer\":\"Hideki Sonoda, Satoshi Tajiri, Junichi Masuda\",\"Actors\":\"Veronica Taylor, Rica Matsumoto, Rachael Lillis\",\"Plot\":\"Ash must stop a hunter who forces the mythical Pokémon Celebi to help him destroy a forest.\",\"Language\":\"Japanese\",\"Country\":\"Japan\",\"Awards\":\"N/A\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BZDZiYjc3MWYtODE5Mi00MDM5LWFkZTAtNjAzZmUxMzc4ZGQxL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"5.7/10\"}],\"Metascore\":\"N/A\",\"imdbRating\":\"5.7\",\"imdbVotes\":\"9,021\",\"imdbID\":\"tt0287635\",\"Type\":\"movie\",\"DVD\":\"N/A\",\"BoxOffice\":\"$1,727,447\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}", app.getTitle("Pokemon+4Ever"));
    }

    /**
     * Try the "getIndexResponse" method of the "HttpServer" class.
     * This test verifies that the method returns a multi-user graphical interface to the application.
     */
    @Test
    public void testgetIndexResponse(){
        scene();
        assertTrue(("HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>All about movies</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "        <style>"
                + "             body {"
                + "                 background-image: url('https://i.ibb.co/hgQ45Zz/1200px-Hollywood-Sign-PB050006.jpg');"
                + "                 background-size: cover;"
                + "             }"
                + "         </style>"
                + "    </head>\n"
                + "    <body>\n"
                + "        <h1>CHECK MOVIE INFORMATION</h1>\n"
                + "        <form action=\"/search\">\n"
                + "            <label for=\"name\">Original title:</label><br>\n"
                + "            <input type=\"text\" id=\"title\" name=\"title\" value=\"John\"><br><br>\n"
                + "            <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsg()\">\n"
                + "        </form> \n"
                + "        <div id=\"getrespmsg\"></div>\n"
                + "\n"
                + "        <script>\n"
                + "            function loadGetMsg() {\n"
                + "                let nameVar = document.getElementById(\"title\").value;\n"
                + "                const xhttp = new XMLHttpRequest();\n"
                + "                xhttp.onload = function() {\n"
                + "                    document.getElementById(\"getrespmsg\").innerHTML =\n"
                + "                    this.responseText;\n"
                + "                }\n"
                + "                xhttp.open(\"GET\", \"/search?title=\"+nameVar);\n"
                + "                xhttp.send();\n"
                + "            }\n"
                + "        </script>\n"
                + "\n"
                + "    </body>\n"
                + "</html>").equals(app.getIndexResponse()));
    }

    /**
     * Try the "httpConnection" method of the "HttpServer" class.
     * This test verifies that the method returns the movie information.
     */
    @Test
    public void testhttpConnection() throws IOException {
        scene();
        assertEquals("{\"Title\":\"Saw III\",\"Year\":\"2006\",\"Rated\":\"R\",\"Released\":\"27 Oct 2006\",\"Runtime\":\"108 min\",\"Genre\":\"Horror, Mystery, Thriller\",\"Director\":\"Darren Lynn Bousman\",\"Writer\":\"Leigh Whannell, James Wan\",\"Actors\":\"Tobin Bell, Shawnee Smith, Angus Macfadyen\",\"Plot\":\"Jigsaw abducts a doctor in order to keep himself alive while he watches his new apprentice put an unlucky citizen named Jeff through a brutal test.\",\"Language\":\"English\",\"Country\":\"Canada, United States\",\"Awards\":\"1 win & 9 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNWVjMzgwMTctZmZjNC00ZmE0LThiNTUtYzkyM2RkYWIzY2Y2XkEyXkFqcGdeQXVyNjEyNDAyMzI@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"6.2/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"30%\"},{\"Source\":\"Metacritic\",\"Value\":\"48/100\"}],\"Metascore\":\"48\",\"imdbRating\":\"6.2\",\"imdbVotes\":\"200,944\",\"imdbID\":\"tt0489270\",\"Type\":\"movie\",\"DVD\":\"20 Dec 2015\",\"BoxOffice\":\"$80,238,724\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}", app.httpConnection("Saw+III"));
        assertEquals("{\"Title\":\"Saw VI\",\"Year\":\"2009\",\"Rated\":\"R\",\"Released\":\"23 Oct 2009\",\"Runtime\":\"90 min\",\"Genre\":\"Horror, Mystery, Thriller\",\"Director\":\"Kevin Greutert\",\"Writer\":\"Patrick Melton, Marcus Dunstan\",\"Actors\":\"Tobin Bell, Costas Mandylor, Mark Rolston\",\"Plot\":\"Agent Strahm is dead, and FBI agent Erickson draws nearer to Hoffman. Meanwhile, a pair of insurance executives find themselves in another game set by Jigsaw.\",\"Language\":\"English\",\"Country\":\"Canada, United States, Australia\",\"Awards\":\"2 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTMyNTM5MDcyOV5BMl5BanBnXkFtZTcwMzkzMzY4Mg@@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"6.0/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"39%\"},{\"Source\":\"Metacritic\",\"Value\":\"30/100\"}],\"Metascore\":\"30\",\"imdbRating\":\"6.0\",\"imdbVotes\":\"117,149\",\"imdbID\":\"tt1233227\",\"Type\":\"movie\",\"DVD\":\"25 Oct 2011\",\"BoxOffice\":\"$27,693,292\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}", app.httpConnection("Saw+VI"));
        assertEquals("{\"Title\":\"Saw II\",\"Year\":\"2005\",\"Rated\":\"R\",\"Released\":\"28 Oct 2005\",\"Runtime\":\"93 min\",\"Genre\":\"Horror, Mystery\",\"Director\":\"Darren Lynn Bousman\",\"Writer\":\"Leigh Whannell, Darren Lynn Bousman\",\"Actors\":\"Donnie Wahlberg, Beverley Mitchell, Franky G\",\"Plot\":\"A detective and his team must rescue 8 people trapped in a factory by the twisted serial killer known as Jigsaw.\",\"Language\":\"English\",\"Country\":\"Canada, United States\",\"Awards\":\"4 wins & 11 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BOTRjMDNmNjctNjg4ZC00N2ZkLThkMzMtOWRmYTFhMzA1ZDZlXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"6.6/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"37%\"},{\"Source\":\"Metacritic\",\"Value\":\"40/100\"}],\"Metascore\":\"40\",\"imdbRating\":\"6.6\",\"imdbVotes\":\"262,246\",\"imdbID\":\"tt0432348\",\"Type\":\"movie\",\"DVD\":\"20 Dec 2015\",\"BoxOffice\":\"$87,039,965\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}", app.httpConnection("Saw+II"));
        assertEquals("{\"Title\":\"The Dark Knight\",\"Year\":\"2008\",\"Rated\":\"PG-13\",\"Released\":\"18 Jul 2008\",\"Runtime\":\"152 min\",\"Genre\":\"Action, Crime, Drama\",\"Director\":\"Christopher Nolan\",\"Writer\":\"Jonathan Nolan, Christopher Nolan, David S. Goyer\",\"Actors\":\"Christian Bale, Heath Ledger, Aaron Eckhart\",\"Plot\":\"When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.\",\"Language\":\"English, Mandarin\",\"Country\":\"United States, United Kingdom\",\"Awards\":\"Won 2 Oscars. 162 wins & 164 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"9.0/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"94%\"},{\"Source\":\"Metacritic\",\"Value\":\"84/100\"}],\"Metascore\":\"84\",\"imdbRating\":\"9.0\",\"imdbVotes\":\"2,755,440\",\"imdbID\":\"tt0468569\",\"Type\":\"movie\",\"DVD\":\"14 Jun 2010\",\"BoxOffice\":\"$534,987,076\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}", app.httpConnection("The+Dark+Knight"));
        assertEquals("{\"Title\":\"Oppenheimer\",\"Year\":\"2023\",\"Rated\":\"R\",\"Released\":\"21 Jul 2023\",\"Runtime\":\"180 min\",\"Genre\":\"Biography, Drama, History\",\"Director\":\"Christopher Nolan\",\"Writer\":\"Christopher Nolan, Kai Bird, Martin Sherwin\",\"Actors\":\"Cillian Murphy, Emily Blunt, Matt Damon\",\"Plot\":\"The story of American scientist, J. Robert Oppenheimer, and his role in the development of the atomic bomb.\",\"Language\":\"English, Dutch\",\"Country\":\"United States, United Kingdom\",\"Awards\":\"1 win & 1 nomination\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMDBmYTZjNjUtN2M1MS00MTQ2LTk2ODgtNzc2M2QyZGE5NTVjXkEyXkFqcGdeQXVyNzAwMjU2MTY@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.7/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"94%\"},{\"Source\":\"Metacritic\",\"Value\":\"88/100\"}],\"Metascore\":\"88\",\"imdbRating\":\"8.7\",\"imdbVotes\":\"252,355\",\"imdbID\":\"tt15398776\",\"Type\":\"movie\",\"DVD\":\"N/A\",\"BoxOffice\":\"$174,566,060\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}", app.httpConnection("Oppenheimer"));

    }

}
