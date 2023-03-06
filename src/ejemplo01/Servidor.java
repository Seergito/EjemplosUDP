package ejemplo01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {

	public static void main(String[] args) throws Exception {
		
		DatagramSocket socketservidor=new DatagramSocket(5000);
		
		System.out.println("Servidor Arrancado");
		while(true) {
			byte[] recibidos=new byte[1024];
			DatagramPacket paquete=new DatagramPacket(recibidos, recibidos.length);
			socketservidor.receive(paquete);
			
			String texto=new String(paquete.getData());
			texto=texto.trim();
			System.out.println(texto);
			
			if (texto.equals("*")) break;
			
		}
		socketservidor.close();
	}
}
