/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttest;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author awaddell
 */
public class ClientTest {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
       // String hostname = "192.168.99.226";
       String hostname = "192.168.99.249";
       boolean h = true;
       int attempts = 0;
        Socket socket = null;
        while(h){
        try {
            socket = new Socket(hostname, 125);
            socket.setSoTimeout(30000);
            
            //INPUT STUFF GOES HERE
            //InputStream in = socket.getInputStream();
            
        }catch(IOException ex){
            System.err.println(ex);
        }finally {
            if (socket != null){
                try {
                    socket.close();
                    
                }catch (IOException ex){
                    //ignore
                }
            }
            if (attempts > 5){
                h = false;
                
            }
        }
    }
    
    }
}