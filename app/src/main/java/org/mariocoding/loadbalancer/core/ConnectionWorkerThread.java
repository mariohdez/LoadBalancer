package org.mariocoding.loadbalancer.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.mariocoding.loadbalancer.model.Server;

public class ConnectionWorkerThread extends Thread {
    private final Socket clientSocket;
    private Socket serverSocket;

    public ConnectionWorkerThread(Socket socket, Server server) throws UnknownHostException, IOException {
        this.clientSocket = socket;

        this.serverSocket = new Socket(server.getHost(), server.getPort());
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();





        } catch (IOException ioe) {
        } finally {

        }
    }
}
