package laboratorio5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDPBasico {

	private DatagramSocket socket = new DatagramSocket();
    private InetAddress address = InetAddress.getByName("larc.inf.furb.br");

    private byte[] buf;

	public static void main(String args[]) throws IOException {

		String sendMessage = "SEND MESSAGE 4268: ohfsp:0:Hello world!";
		String sendGame = "SEND GAME 4268: ohfsp: ENTER";
		
		System.out.println(sendToLarc(sendMessage));
		System.out.println(sendToLarc(sendGame));
	}

	private String sendToLarc(String msg){
		buf = msg.getBytes();
		
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 1011);
        socket.send(packet);

        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());

        return received;
	}
}