import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslationApplication {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		
		try {
			//Bind serverSocket to a port
			int portNo = 4228;
			serverSocket = new ServerSocket(portNo);
			
			String text1 = "Good afternoon";
			System.out.println("Waiting for request");
			
			while (true) {
				
				//accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				//create stream to write data on the network
				DataOutputStream outputStream = new DataOutputStream (clientSocket.getOutputStream());
				
				//send current data back to the client
				outputStream.writeUTF(text1);
				
				// close socket
				clientSocket.close();
				
			}
		}catch (IOException ioe){
			if(serverSocket != null)
				serverSocket.close();
			ioe.printStackTrace();
		}
		
		

	}

}
