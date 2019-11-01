/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertest;


import java.net.*;
import java.io.*;

public class ServerTest {
    public final static int PORT = 13;
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)){
            while(true){
                try(Socket connection = server.accept()){
                    InetAddress n = connection.getInetAddress();
                    String ipAd = n.getHostAddress();
                    System.out.println("RECEIVED CONNECTION FROM: "+ ipAd);
                    connection.close();
                }catch (IOException ex){}
                
            }
        }catch (IOException ex){
                    System.err.println(ex);
                    }
        // TODO code application logic here
    }
}
    