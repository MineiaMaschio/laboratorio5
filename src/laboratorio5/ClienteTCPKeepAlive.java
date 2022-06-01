package laboratorio5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClienteTCPKeepAlive {
	  public static void main(String[] args) {
	    try {
	      Socket cliente = new Socket("larc.inf.furb.br",1012);
	      System.out.println(cliente);

		  
		Thread th = new Thread(findAnotherUsers(cliente));
		while (true)
		{			
			System.out.println("Iniciando loop");
			th.start();
			System.out.println("Finalizando loop");
			th.sleep(6000);
		}
          
	      
	    }
	    catch(Exception e) {
	      System.out.println("Erro: " + e.getMessage());
	    }
	  }

	  private void findAnotherUsers(Socket client)
	  {
		System.out.println("Conexão iniciada");
		PrintStream out = new PrintStream( client.getOutputStream() );
		BufferedReader in = new BufferedReader( new InputStreamReader( client.getInputStream() ) );
		
		String t = "GET USERS 4268:ohfsp";
		
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
		System.out.println("Conex�o encerrada");
	  }
	}
