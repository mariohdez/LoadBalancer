package org.mariocoding.loadbalancer.core;

import org.mariocoding.loadbalancer.config.Server;

public class RoundRobinRouter implements Router {
    private final Server[] servers;
    private int requestCount;

    public RoundRobinRouter(Server[] servers) {
        this.servers = servers;
    }

    @Override
    public Server getServer() {
        if (requestCount == Integer.MAX_VALUE) {
            requestCount = 0;
        }

        int serverIndex = requestCount % this.servers.length;

        requestCount++;

        return servers[serverIndex];
    }
}
