package edu.escuelaing.app;

import java.net.*;



import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

/** ESCUELA COLOMBIANA DE INGENIERIA - ARQUITECTURAS EMPRESARIALES

Juan Francisco Teran Roman
21/08/2023

APLICACIONES DISTRIBUIDAS (HTTP, SOCKETS, HTML, JS,MAVEN, GIT)
Debe construir una aplicación para consultar la información de películas de cine.
*/

// TALLER 1


public class App {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();


    /**
     * A web application to consult movie information searching by title, using different distributed applications (JS, HTML, Maven, among others)
     * @throws IOException if an error occurs while making the HTTP connection
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35001);

        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }



        boolean running = true;
        while (running) {


            Socket clientSocket = null;
            try {
                System.out.println("\nListo para recibir... \n");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }


            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()
                    ));
            String pelicula, respuesta;

            boolean firstLine = true;
            String urlString = "";
            while ((pelicula = in.readLine()) != null) {
                System.out.println("Received: " + pelicula);
                if (firstLine) {
                    firstLine = false;
                    // POST
                    System.out.println("Data request: " + pelicula);
                    urlString = pelicula.split(" ")[1];

                }

                if (!in.ready()){
                    break;
                }

            }

            if (urlString.startsWith("/search?")) {
                if (urlString.startsWith("/search?title=%20")){
                    break;
                }
                String peliculaUrl = urlString.split("title=")[1];
                peliculaUrl = peliculaUrl.replace(" ", "+");
                peliculaUrl = peliculaUrl.replace(":", "%3A");
                respuesta = getTitle(peliculaUrl);
            } else {
                respuesta = getIndexResponse();
            }
            out.println(respuesta);



            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }


    /**
     * Prepare the message in JSON format and invoke a GET service (Java) from a web server
     * @param url the omdbapi URL to search for the movie by title (without API key)
     * @return the movie data (searched by title) in JSON format
     * @throws IOException if an error occurs while making the HTTP connection
     */
    public static String getTitle(String url) throws IOException {
        String response = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json\r\n"
                + "\r\n"
                + httpConnection(url);//"{ \"msg\": \"Hello Pedro\" }";
        return response;
    }

    /**
     * Invoke GET service asynchronously from a JS web client
     * @return the graphical interface of the client of an application (web server) that does not ask for a password
     */
    public static String getIndexResponse(){
        String response = "HTTP/1.1 200 OK\r\n"
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
                + "</html>";
        return response;
    }

    /**
     * Invokes a GET service from Java to connect to an external API service (omdbapi) and query the movie information (with API key). Implements cache to avoid repeated API queries
     * @param pelicula title of the movie for which your information is requested in a format compatible with the API service
     * @return the movie information
     * @throws IOException if an error occurs while making the HTTP connection
     */
    public static String httpConnection(String pelicula) throws IOException {

        String result = "";
        if (cache.containsKey(pelicula)){
            result = get(pelicula);
            System.out.println("Cache response :: Repeated Query ");
            System.out.println(result);
            return result;
        } else {
            String site = "http://www.omdbapi.com/?t=" + pelicula + "&apikey=2017f520";
            URL obj = new URL(site);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            //The following invocation perform the connection implicitly before getting the code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                result = response.toString();
                put(pelicula, result);
                // print result
                System.out.println(result);

            } else {
                System.out.println("GET request not worked");
            }
            System.out.println("GET DONE");
            return result;
        }
    }

    public static String get(String query){
        return cache.get(query);
    }

    public static void put (String query, String call){
        cache.put(query, call);
    }

}