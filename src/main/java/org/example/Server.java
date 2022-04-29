package org.example;

/**
 * SERVER  - MULTITHREADED                                         March 2021
 * <p>
 * Server accepts client connections, creates a ClientHandler to handle the
 * Client communication, creates a socket and passes the socket to the handler,
 * runs the handler in a separate Thread.
 * <p>
 * <p>
 * The handler reads requests from clients, and sends replies to clients, all in
 * accordance with the rules of the protocol. as specified in
 * "ClientServerBasic" sample program
 * <p>
 * The following PROTOCOL is implemented:
 * <p>
 * If ( the Server receives the request "Time", from a Client ) then : the
 * server will send back the current time
 * <p>
 * If ( the Server receives the request "Echo message", from a Client ) then :
 * the server will send back the message
 * <p>
 * If ( the Server receives the request it does not recognize ) then : the
 * server will send back the message "Sorry, I don't understand"
 * <p>
 * This is an example of a simple protocol, where the server's response is based
 * on the client's request.
 *
 *  Each client is handled by a ClientHandler running in a separate worker Thread
 *  which allows the Server to continually listen for and handle multiple clients
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.DAO.ChampDaoInterface;
import org.example.DAO.MySQLChampDAO;
import org.example.DTOs.Champ;
import org.example.Exceptions.DaoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args)
    {
        Server server = new Server();
        server.start();
    }

    public void start()
    {
        ChampDaoInterface dao = new MySQLChampDAO();

        try
        {
            ServerSocket ss = new ServerSocket(8081);  // set up ServerSocket to listen for connections on port 8080

            System.out.println("Server: Server started. Listening for connections on port 8080...");

            int clientNumber = 0;  // a number for clients that the server allocates as clients connect

            while (true)    // loop continuously to accept new client connections
            {
                Socket socket = ss.accept();    // listen (and wait) for a connection, accept the connection,
                // and open a new socket to communicate with the client
                clientNumber++;

                System.out.println("Server: Client " + clientNumber + " has connected.");

                System.out.println("Server: Port# of remote client: " + socket.getPort());
                System.out.println("Server: Port# of this server: " + socket.getLocalPort());

                Thread t = new Thread(new ClientHandler(socket, clientNumber, dao)); // create a new ClientHandler for the client,
                t.start();                                                  // and run it in its own thread

                System.out.println("Server: ClientHandler started in thread for client " + clientNumber + ". ");
                System.out.println("Server: Listening for further connections...");
            }
        } catch (IOException e)
        {
            System.out.println("Server: IOException: " + e);
        }
        System.out.println("Server: Server exiting, Goodbye!");
    }

    public class ClientHandler implements Runnable   // each ClientHandler communicates with one Client
    {
        BufferedReader socketReader;
        PrintWriter socketWriter;
        Socket socket;
        int clientNumber;
        ChampDaoInterface dao;

        public ClientHandler(Socket clientSocket, int clientNumber, ChampDaoInterface dao)
        {
            this.dao = dao;
            try
            {
                InputStreamReader isReader = new InputStreamReader(clientSocket.getInputStream());
                this.socketReader = new BufferedReader(isReader);

                OutputStream os = clientSocket.getOutputStream();
                this.socketWriter = new PrintWriter(os, true); // true => auto flush socket buffer

                this.clientNumber = clientNumber;  // ID number that we are assigning to this client

                this.socket = clientSocket;  // store socket ref for closing

            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

        @Override
        public void run()
        {
            String message;
            try
            {
                while ((message = socketReader.readLine()) != null)
                {
                    System.out.println("Server: (ClientHandler): Read command from client " + clientNumber + ": " + message);

                    if (message.startsWith("DisplayById"))
                    {
                        try {
                            String id = message.substring(message.indexOf(" ") + 1);
                            System.out.println("Server: (ClientHandler): DisplayById: " + id);
                            String champ = dao.findAllChampByIDJSON(String.valueOf(Integer.parseInt(id)));
                            System.out.println("Server: (ClientHandler): DisplayById: " + champ);
                            socketWriter.println(champ.toString());
                        }
                        catch (NumberFormatException e)
                        {
                            socketWriter.println("Invalid ID");
                        } catch (DaoException e) {
                            e.printStackTrace();
                        }
                    }

                    else if (message.startsWith("DisplayAll"))
                    {
                        try {
                            String json = dao.findAllChampJSON();
                            socketWriter.println(json);
                        }
                        catch (Exception e)
                        {
                            socketWriter.println("Error: " + e.getMessage());
                        }
                    }

                    else if (message.startsWith("AddChamp")){
                        try {
                            Gson gsonParser = new Gson();
                            System.out.println("Server: (ClientHandler): AddChamp: " + message);
                            String JsonString = "";
                            String[] tokens = message.split(" ");
                            int id = Integer.parseInt(tokens[1]);
                            String name = tokens[2];
                            String mainRole = tokens[3];
                            String region = tokens[4];
                            Double winRate = Double.parseDouble(tokens[5]);
                            Double pickRate = Double.parseDouble(tokens[6]);
                            Double BanRate = Double.parseDouble(tokens[7]);
                            int roleRank = Integer.parseInt(tokens[8]);
                            int overallRank = Integer.parseInt(tokens[9]);
                            String tier = tokens[10];
                            Champ champ = new Champ(id, name, mainRole, region, winRate, pickRate, BanRate, roleRank, overallRank, tier);
                            if (champ != null) {
                                JsonString = gsonParser.toJson(champ);
                                dao.addChamp(champ);
                                socketWriter.println(JsonString);
                            }
                            else {
                                socketWriter.println("Champ is null");
                            }
                        }
                        catch (Exception e)
                        {
                            socketWriter.println("Error: " + e.getMessage());
                        }
                    }

                    else if (message.startsWith("DeleteChamp")){
                        try {
                            String id = message.substring(message.indexOf(" ") + 1);
                            dao.deleteChampByID(Integer.parseInt(String.valueOf(Integer.parseInt(id))));
                            socketWriter.println("Deleted Champ with ID: " + id);
                        }
                        catch (NumberFormatException e)
                        {
                            socketWriter.println("Invalid ID");
                        } catch (DaoException e) {
                            e.printStackTrace();
                        }

                    }

                    else if (message.startsWith("DisplayByName"))
                    {
                        try {
                            String name = message.substring(message.indexOf(" ") + 1);
                            System.out.println("Server: (ClientHandler): DisplayById: " + name);
                            String champ = dao.findAllChampByNameJSON(name);
                            System.out.println("Server: (ClientHandler): DisplayById: " + champ);
                            socketWriter.println(champ.toString());
                        }
                        catch (NumberFormatException e)
                        {
                            socketWriter.println("Invalid ID");
                        } catch (DaoException e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        socketWriter.println("I'm sorry I don't understand :(");
                    }
                }

                socket.close();

            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
            System.out.println("Server: (ClientHandler): Handler for Client " + clientNumber + " is terminating .....");
        }
    }

}
