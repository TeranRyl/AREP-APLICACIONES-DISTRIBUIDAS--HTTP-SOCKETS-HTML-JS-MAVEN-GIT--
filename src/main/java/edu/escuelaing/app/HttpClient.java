package edu.escuelaing.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpClient {

    /**
     * Allows manual queries (by title) from a Java client when connecting to the web server.
     * @throws IOException if an error occurs while making the HTTP connection
     */
    public static void main(String[] args) throws IOException {
        while (true) {
            Socket echoSocket = null;
            PrintWriter out = null;
            BufferedReader in = null;
            String userInput;
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

            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.println("Movie name or press spacebar and enter to finish");
            userInput = stdIn.readLine();
            if (userInput.startsWith(" ")) {
                out.println("GET /search?title=%20 HTTP/1.1");
                break;
            }
            System.out.println("Title: " + userInput);
            userInput = userInput.replace(" ", "+");
            userInput = userInput.replace(":", "%3A");
            out.println("GET /search?title=" + userInput + " HTTP/1.1");
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine() + "\n\n");

            out.close();
            in.close();
            echoSocket.close();
        }
    }
}
