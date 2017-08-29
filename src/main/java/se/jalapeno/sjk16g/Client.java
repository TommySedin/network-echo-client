package se.jalapeno.sjk16g;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class Client 
{
	public static void main( String[] args ) throws UnknownHostException, IOException
	{
		System.out.println( "Hello Client!" );
		Socket socket = new Socket("127.0.0.1", 12345);
		BufferedReader reader = new BufferedReader(
									new InputStreamReader(
										socket.getInputStream()
									, "UTF-8")
								);
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(
					socket.getOutputStream()
				, "UTF-8")
				);
		
		String msg = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println(msg);
		writer.write(msg + "\n");
		writer.flush();
		System.out.println("Server says: " + reader.readLine());
	}
}
