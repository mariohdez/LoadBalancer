package org.mariocoding.loadbalancer.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.mariocoding.loadbalancer.router.Router;
import org.mariocoding.loadbalancer.model.Server;

public class ConnectionListenerThread extends Thread implements Closeable {
    private final static Logger LOGGER = LoggerFactory.getLogger(ConnectionListenerThread.class);

    private final int port;
    private final Router router;
    private final ServerSocket serverSocket;

    public ConnectionListenerThread(int port, Router router) throws IOException, IllegalArgumentException {
        if (router == null) {
            throw new IllegalArgumentException("router is null.");
        }

        this.port = port;
        this.router = router;
        this.serverSocket = new ServerSocket(this.port);
	}

    @Override
    public void run() {
        try {
            while (this.serverSocket.isBound() && !this.serverSocket.isClosed()) {
                LOGGER.info("Server Socket is waiting for connection...");

                Socket socket = this.serverSocket.accept();
                LOGGER.info("Server Socket connection accepted."); 
                StringBuilder strBuilder = new StringBuilder();
                strBuilder.append(socket.getLocalAddress() + " ");
                strBuilder.append(socket.getLocalPort() + " ");
                strBuilder.append(socket.getInetAddress() + " ");
                strBuilder.append(socket.getPort());
                LOGGER.info("socket unique identifier: {}", strBuilder.toString());

                Server server = this.router.getServer();
                socket.getOutputStream().write("".getBytes());
            }
        }  catch (IOException ioe) {
            LOGGER.error("Problem with setting socket", ioe);
        } finally {
            try {
                this.serverSocket.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    @Override
    public void close() {
        if (this.serverSocket != null) {
            try {
                this.serverSocket.close();
            } catch (IOException ioe) {
                LOGGER.error("Could not properly dispose of server socket.");
            }
        }
    }
}

