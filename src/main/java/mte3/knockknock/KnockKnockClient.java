// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 2
// Filename: KnockKnockClient.java (inside knockknock package)

package mte3.knockknock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

import mte3.knockknock2.Client;

public class KnockKnockClient {
    public static int PORT = 54322;
    public static String SERVER = "localhost";

    public static void sendAndReceive(PrintWriter writer, String message, Scanner scanner) throws IOException {
        Socket client = new Socket(SERVER, PORT);
        PrintWriter out = new PrintWriter(client.getOutputStream ());
        InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
        BufferedReader in = new BufferedReader(inputStreamReader);

        try {System.out.println(in.readLine());} 
		catch (IOException e) {System.err.println("Error: " + e.getMessage());}

        out.println(message);
        out.flush();
        out.println(client.getInetAddress() + " who?");
        out.flush();
        try {System.out.println(in.readLine());} 
		catch (IOException e) {System.err.println("Error: " + e.getMessage());}
        in.close();
        out.close();
        client.close();






        /* 
        receive();                // question
        send("Who's there?");    // answer
        String setup = receive();   // setup
        send(setup + " who?");     // response
        receive();                // punchline
        close();
         * 
         */
        // test commit 

    } // sendAndReceive() method closed
    

    public static void joke(String who,String punchLine) throws IOException {
        sendAndReceive(null, punchLine, null);

        //  
        // 
        // 

    } // joke() method closed

    public static void main(String[] args) throws IOException {

        String[][] jokes = {{"Tank","You're welcome!"},
                            {"Nobel","Nobel...that's why I knocked!"},
                            {"Says","Says me!"},
                            {"Hawaii","I'm good. Hawaii you?"},
                            {"Lettuce","Lettuce in, it's cold out here!"},
                            {"Cow says","No, a cow says moooooo!"},
                            {"Otto","Otto know. I forgot."}
                        };
        int i = new Random().nextInt(jokes.length);
        joke(jokes[i][0],jokes[i][1]);

        

    } // main() method closed

    // hint: please run KnockKnockServer first and then run KnockKnockClient

} // KnockKnockClient { } class closed