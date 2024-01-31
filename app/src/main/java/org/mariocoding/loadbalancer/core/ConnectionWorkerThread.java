package org.mariocoding.loadbalancer.core;

import java.net.Socket;

import org.mariocoding.loadbalancer.model.Server;

public class ConnectionWorkerThread {
    private final Socket clientSocket;
    private Socket serverSocket;

    public ConnectionWorkerThread(Socket socket, Server server) {
        this.clientSocket = socket;
    }
}
