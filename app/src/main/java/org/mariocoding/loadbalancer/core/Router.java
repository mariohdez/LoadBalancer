package org.mariocoding.loadbalancer.core;

import org.mariocoding.loadbalancer.model.Server;

public interface Router {
    public Server getServer();
}

