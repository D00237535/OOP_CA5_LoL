package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        Client client = new Client();
        client.start();
    }

    public void start()
    {
        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 8081);  // connect to server socket
            System.out.println("Client: Port# of this client : " + socket.getLocalPort());
            System.out.println("Client: Port# of Server :" + socket.getPort() );

            System.out.println("Client message: The Client is running and has connected to the server");

            System.out.println("Please enter a command:  (\"Time\" to get time, or \"Echo message\" to get echo) \n>");
            String command = in.nextLine();

            OutputStream os = socket.getOutputStream();
            PrintWriter socketWriter = new PrintWriter(os, true);   // true => auto flush buffers

            socketWriter.println(command);

            Scanner socketReader = new Scanner(socket.getInputStream());  // wait for, and retrieve the reply

            boolean continueLooping = true;
            while (continueLooping == true){

                System.out.println("Client message: Here are the available commands: \n" +
                        "DisplayAll" + "\n" +
                        "DisplayByID" + "\n" +
                        "AddChamp" + "\n" +
                        "DeleteChamp" + "\n" +
                        "DisplayByName" + "\n" +
                        "Exit" + "\n");

                if(command.startsWith("DisplayById"))   //we expect the server to return a time
                {
                    String id = socketReader.nextLine();
                    System.out.println("Client message: Response from server Champ: " + id);
                }
                else if(command.startsWith("DisplayAll"))
                {
                    String id = socketReader.nextLine();
                    System.out.println("Client message: Response from server Time: " + id);

                }
                else if(command.startsWith("AddChamp"))
                {
                    String id = socketReader.nextLine();
                    System.out.println("Client message: Response from server Time: " + id);
                }
                else if(command.startsWith("DeleteChamp"))
                {
                    String id = socketReader.nextLine();
                    System.out.println("Client message: Response from server Champ: " + id + " has been deleted");
                }
                else if(command.startsWith("DisplayByName")){
                    String id = socketReader.nextLine();
                    System.out.println("Client message: Response from server Champ: " + id);
                }
                else                            // the user has entered the Echo command or an invalid command
                {
                    String input = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\n");
                }
                System.out.println("Please enter a command:  (\"Time\" to get time, or \"Echo message\" to get echo) \n>");
                command = in.nextLine();
                socketWriter.println(command);
            }

            socketWriter.close();
            socketReader.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Client message: IOException: "+e);
        }
    }
}
