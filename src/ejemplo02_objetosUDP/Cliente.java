package ejemplo02_objetosUDP;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws Exception {

		Scanner sc=new Scanner(System.in);
		DatagramSocket socketcliente=new DatagramSocket();
		InetAddress IPServidor=InetAddress.getLocalHost();
		byte[] enviados=new byte[1024];
		
		System.out.print("Dime nombre: ");
		String nombre=sc.nextLine();
		System.out.print("Dime edad: ");
		int edad=sc.nextInt();
		
		Persona persona=new Persona(nombre, edad);
		
		// Convertir un objeto a un array de bytes
		ByteArrayOutputStream salida=new ByteArrayOutputStream();
		
		ObjectOutputStream salidaobjeto=new ObjectOutputStream(salida);
		salidaobjeto.writeObject(persona);
		
		enviados=salida.toByteArray();
		DatagramPacket paquete=new DatagramPacket(enviados, enviados.length,IPServidor,5000);
		socketcliente.send(paquete);
		
		socketcliente.close();
		
	}
}
