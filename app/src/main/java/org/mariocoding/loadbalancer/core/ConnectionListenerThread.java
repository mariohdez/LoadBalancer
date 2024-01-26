package org.mariocoding.loadbalancer.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionListenerThread extends Thread {
	private final static Logger LOGGER = LoggerFactory.getLogger(ConnectionListenerThread.class);

	private final int port;
	private final ServerSocket serverSocket;

	public ConnectionListenerThread(int port) throws IOException {
		this.port = port;
		this.serverSocket = new ServerSocket(this.port);
	}

	@Override
	public void run() {
		try {
			while (this.serverSocket.isBound() && !this.serverSocket.isClosed()) {
				Socket socket = this.serverSocket.accept();
				StringBuilder strBuilder = new StringBuilder();
				strBuilder.append(socket.getLocalAddress() + " ");
				strBuilder.append(socket.getLocalPort() + " ");
				strBuilder.append(socket.getInetAddress() + " ");
				strBuilder.append(socket.getPort());

				LOGGER.info("Socket connection identifier: {}", strBuilder.toString());
			}
		}  catch (IOException ioe) {
			LOGGER.error("Problem with setting socket", ioe);
		} finally {
			try {
				this.serverSocket.close();
			} catch (IOException ioe) {
			}
		}
	}
}

