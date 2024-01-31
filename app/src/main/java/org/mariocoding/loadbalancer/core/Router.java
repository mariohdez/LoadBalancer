package org.mariocoding.loadbalancer.core;

import org.mariocoding.loadbalancer.config.Server;

public interface Router {
    public Server getServer();
}

