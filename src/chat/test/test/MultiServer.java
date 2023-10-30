package chat.test.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MultiServer extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private ServerSocket serverSocket;
	private HashMap<String, ObjectOutputStream> clientOutputStreams;

	public MultiServer() {
		setTitle("Multi-Client Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		textArea = new JTextArea();
		textArea.setEditable(false);
		add(textArea, BorderLayout.CENTER);
		clientOutputStreams = new HashMap<>();
		try {
			serverSocket = new ServerSocket(12345);
			appendToChat("Server is running. Waiting for clients...");
			while (true) {
				Socket clientSocket = serverSocket.accept();
				ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
				new ClientHandler(clientSocket, out).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void appendToChat(String message) {
		textArea.append(message + "\n");
	}

	private class ClientHandler extends Thread {
		private Socket socket;
		private ObjectOutputStream out;
		private ObjectInputStream in;
		private String clientName;

		public ClientHandler(Socket socket, ObjectOutputStream out) {
			this.socket = socket;
			this.out = out;
		}

		@Override
		public void run() {
			try {
				while (true) {
					in = new ObjectInputStream(socket.getInputStream());
					String id = (String) in.readObject();
					String pwd = (String) in.readObject();
					String inp = (String) in.readObject();
					System.out.println(inp);
					String[] arr = inp.split(":");
					String sendName = arr[0];
					String message = arr[1];
					String recipient = arr[2];
					System.out.println(sendName + " " + message + " " + recipient);
					clientOutputStreams.put(clientName, out);
					ObjectOutputStream recipientOut = clientOutputStreams.get(recipient);
					if (recipientOut != null) {
						System.out.println(clientName + ":" + message);
						recipientOut.writeObject(clientName + ":" + message);
					}
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				clientOutputStreams.remove(clientName);
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new MultiServer().setVisible(true));
	}
}
