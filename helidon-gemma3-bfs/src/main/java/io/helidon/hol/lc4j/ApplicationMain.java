package io.helidon.hol.lc4j;

import io.helidon.common.config.Config;
import io.helidon.hol.lc4j.rest.ChatBotService;
import io.helidon.logging.common.LogConfig;
import io.helidon.service.registry.Services;
import io.helidon.webserver.WebServer;

public class ApplicationMain {
    public static void main(String[] args) {
        // Make sure logging is enabled as the first thing
        LogConfig.configureRuntime();

        var config = Services.get(Config.class);

        // Initialize embedding store
        //Services.get(MenuItemsIngestor.class)
                //.ingest();

        WebServer.builder()
                .config(config.get("server"))
                .routing(routing -> routing.register("/", Services.get(ChatBotService.class)))
                .build()
                .start();
    }
}