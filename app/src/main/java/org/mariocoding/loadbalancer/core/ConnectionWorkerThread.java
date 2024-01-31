package org.mariocoding.loadbalancer.core;

import java.net.Socket;

import org.mariocoding.loadbalancer.model.Server;

public class ConnectionWorkerThread extends Thread {
    private final Socket clientSocket;
    private Socket serverSocket;

    public ConnectionWorkerThread(Socket socket, Server server) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        // TODO: implement server socket connection and replying back to client with response.
    }
}
