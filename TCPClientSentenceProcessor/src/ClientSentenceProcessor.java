import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSentenceProcessor {

	public static void main(String[] args) throws UnknownHostException, IOException
	{
			//launch client side frame
			ClientSentenceFrame clientDateFrame = new ClientSentenceFrame ();
			clientDateFrame.setVisible(true);
			
			//connect to the server @local host, port4228
			Socket socket = new Socket (InetAddress.getLocalHost(),4228);
			
			//update the status of the connection
			clientDateFrame.updateConnectionStatus(socket.isConnected());
			
			String sentence = "Create a TCP-Based client-server application to process a length of a text";
			
			//send data to server
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(sentence);
			
			//get response from the server
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			int totalWords = dis.readInt();
			clientDateFrame.updateLengthLabel(totalWords);
			System.out.println("Total words : " + totalWords);
			
			socket.close();
		

	}

}
