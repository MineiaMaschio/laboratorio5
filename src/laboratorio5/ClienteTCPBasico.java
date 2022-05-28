package laboratorio5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClienteTCPBasico {
	  public static void main(String[] args) {
	    try {
	      Socket cliente = new Socket("larc.inf.furb.br",1012);
	      System.out.println(cliente);


	      PrintStream out = new PrintStream( cliente.getOutputStream() );
          BufferedReader in = new BufferedReader( new InputStreamReader( cliente.getInputStream() ) );
	      
          String t = "GET MESSAGE 4268: ohfsp";
          
          out.println(t);
          out.println();
          
          String line = in.readLine();
          while( line != null )
          {
              System.out.println( line );
              line = in.readLine();
          }

          // Close our streams
          in.close();
          out.close();
          cliente.close();
          
	      System.out.println("Conexão encerrada");
	    }
	    catch(Exception e) {
	      System.out.println("Erro: " + e.getMessage());
	    }
	  }
	}
