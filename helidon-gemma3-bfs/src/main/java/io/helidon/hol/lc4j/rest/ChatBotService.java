package io.helidon.hol.lc4j.rest;

import io.helidon.hol.lc4j.ai.ChatAiService;
import io.helidon.hol.lc4j.model.IslandRequest;
import io.helidon.hol.lc4j.service.NumberOfIslandsBFS;
import io.helidon.service.registry.Service;
import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

@Service.Singleton
public class ChatBotService implements HttpService {

    private final ChatAiService chatAiService;

    @Service.Inject
    public ChatBotService(ChatAiService chatAiService) {
        this.chatAiService = chatAiService;
    }

    @Override
    public void routing(HttpRules httpRules) {
        httpRules.post("/islands-count", this::shortestpath);
    }

    private void shortestpath(ServerRequest req, ServerResponse res) {
        IslandRequest islandRequest =  req.content().as(IslandRequest.class);
        var grid = islandRequest.getGrid();
        NumberOfIslandsBFS numberofislandsbfs = new NumberOfIslandsBFS();
        int islands_count = numberofislandsbfs.numIslands(grid);
        System.out.println("Number of islands: " + islands_count);

        String prompt = "The total number of islands found was: " + islands_count;
        String genairesult = chatAiService.chat(prompt);
    
        res.send(genairesult);
    }
}
