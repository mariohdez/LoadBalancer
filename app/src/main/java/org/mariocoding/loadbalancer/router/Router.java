package org.mariocoding.loadbalancer.router;

import org.mariocoding.loadbalancer.model.Server;

public interface Router {
    public Server getServer();
}

