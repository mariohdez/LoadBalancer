package org.mariocoding.loadbalancer.config;

public class Server {
    private String host;
    private int port;

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("server_host: " + this.host + "\n");
        sb.append("server_port: " + this.port + "\n");

        return sb.toString();
    }
}
