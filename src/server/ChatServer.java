package server;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ChatServer {
	private JFrame frame;
	private JTextArea logTextArea;
	private ServerSocket serverSocket;
	private List<ClientHandler> clients = new ArrayList<>();

	public ChatServer() {
		frame = new JFrame("Chat Server");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLayout(new BorderLayout());

		logTextArea = new JTextArea();
		logTextArea.setEditable(false);
		frame.add(new JScrollPane(logTextArea), BorderLayout.CENTER);

		frame.setVisible(true);

		try {
			serverSocket = new ServerSocket(8888); // Port 8888에서 서버 실행
			log("Server is running. Waiting for clients...");

			while (true) {
				Socket clientSocket = serverSocket.accept();
				log("Client connected from " + clientSocket.getInetAddress().getHostAddress());
				ClientHandler clientHandler = new ClientHandler(clientSocket);
				clients.add(clientHandler);
				clientHandler.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void log(String message) {
		logTextArea.append(message + "\n");
	}

	private class ClientHandler extends Thread {
		private Socket socket;
		private PrintWriter out;
		private BufferedReader in;

		public ClientHandler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				while (true) {
					String message = in.readLine();
					if (message == null) {
						break;
					}
					log("Received: " + message);

					// Broadcast the message to all connected clients
					for (ClientHandler client : clients) {
						if (client != this) {
							client.sendMessage(message);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				log("Client disconnected from " + socket.getInetAddress().getHostAddress());
				clients.remove(this);
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		public void sendMessage(String message) {
			out.println(message);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new ChatServer());
	}
}
