package laboratorio5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDPBasico {
	public static void main(String args[]) throws IOException {

		DatagramSocket ds = new DatagramSocket();

		InetAddress ip = InetAddress.getByName("larc.inf.furb.br");

		// convert the String input into the byte array.
		byte buf[] = "SEND MESSAGE 4268: ohfsp:0:Hello world!".getBytes();

		// Step 2 : Create the datagramPacket for sending
		// the data.
		DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1011);

		// Step 3 : invoke the send call to actually send
		// the data.
		ds.send(DpSend);

	}
}