package ejemplo02_objetosUDP;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class Servidor {

	public static void main(String[] args) throws Exception {

		DatagramSocket socketservidor=new DatagramSocket(5000);
		System.out.println("Servidor Arrancado");
		
		byte[] recibidos=new byte[1024];
		DatagramPacket paquete=new DatagramPacket(recibidos, recibidos.length);
		socketservidor.receive(paquete);
		
		// Convertir el array de bytes a un objeto
		
		//ByteArrayInputStream entrada=new ByteArrayInputStream(recibidos);
		//ObjectInputStream entradaobjeto=new ObjectInputStream(entrada);
		
		ObjectInputStream entradaobjeto=new ObjectInputStream(new ByteArrayInputStream(recibidos));
		Persona persona=(Persona) entradaobjeto.readObject();
		
		System.out.println(persona);
		
		socketservidor.close();
	}

}
