package org.mariocoding.loadbalancer.config;

public class Configuration {
    private int port;
    private Server[] servers;

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Server[] getServers() {
        return this.servers;
    }

    public void setServers(Server[] servers) {
        this.servers = servers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LB port: ").append(this.port).append("\n");

        for (Server s : this.servers) {
            sb.append(s.toString()).append("\n");
        }

        return sb.toString();
    }
}
