// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 2
// Filename: KnockKnockServer.java (inside knockknock package)

package mte3.knockknock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class KnockKnockServer {
    public static int PORT = 54322;

    public static void receiveAndSend(Scanner scanner,String message,PrintWriter writer,boolean concat) {
        PrintWriter out = writer;
        InputStreamReader inputStreamReader;
        BufferedReader in = new BufferedReader(inputStreamReader);

        try {System.out.println(in.readLine());} 
		catch (IOException e) {System.err.println("Error: " + e.getMessage());}

        out.println(message);
        out.flush();
        out.println(" who?");
        out.flush();
        try {System.out.println(in.readLine());} 
		catch (IOException e) {System.err.println("Error: " + e.getMessage());}
        in.close();
        out.close();
        // 
        // 
        // 

    } // receiveAndSend() method closed
    
    public static void main(String args[]) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        Scanner s = new Scanner();
        server.accept();
        receiveAndSend(s, null, null, false);
        // 
        // 
        // 
        server.close();
    } // main() method closed
}