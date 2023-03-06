package ejemplo01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws Exception {
		
		Scanner sc=new Scanner(System.in);

		DatagramSocket socketcliente=new DatagramSocket();
		
		
		InetAddress IPServidor=InetAddress.getLocalHost();
		
		while(true) {
			byte[] enviados=new byte[1024];
			System.out.print("teclea mensaje: ");
			String texto=sc.nextLine();
			enviados=texto.getBytes();
			DatagramPacket paquete=new DatagramPacket(enviados, enviados.length,IPServidor,5000);
			socketcliente.send(paquete);
			
			if (texto.equals("*")) break;
		}
		
		socketcliente.close();
		sc.close();
	}

}
