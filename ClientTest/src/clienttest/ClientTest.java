/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttest;

import java.io.IOException;
import java.io.*;
import java.net.*;

/**
 *
 * @author awaddell
 */
public class ClientTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        for (int i = 0; i < 1; i++){
            connect();
            System.out.println("Attempt #"+i);
        }
    }
    public static void connect() throws IOException {
       // String hostname = "192.168.99.226";
       String hostname = "192.168.99.249";
       boolean h = true;
       int attempts = 0;
        Socket socket = null;
        
        try {
            socket = new Socket(hostname, 3210);
            socket.setSoTimeout(30000);
            attempts++;
            
            
            //INPUT STUFF GOES HERE
            //InputStream in = socket.getInputStream();
            
        }catch(IOException ex){
            System.err.println(ex);
        }finally {
            if (socket != null){
                
                System.out.println("Connection made!");
                InputStream in = socket.getInputStream();
                Writer out = new OutputStreamWriter(socket.getOutputStream(), "ascii");
                //OutputStreamWriter writer = new OutputStreamWriter(out);
                out.write("report");
                out.flush();
                InputStreamReader reader = new InputStreamReader(in);
                StringBuilder test = new StringBuilder();
                for (int c = reader.read(); c != -1; c= reader.read()){
                    //System.out.println(Character.toString((char) c));
                    System.out.println((char)c);
                    test.append((char)c);
                    test.append('-');
                    
                    
                }
                System.out.print("MESSAGE: " + test);
                out.write("EXIT");
                out.flush();
                h = false;
                try {
                    socket.close();
                    
                }catch (IOException ex){
                    //ignore
                }
            }
        
                
            
        }
    }
    
    
}