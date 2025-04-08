package io.helidon.hol.lc4j.ai;

import dev.langchain4j.service.SystemMessage;
import io.helidon.integrations.langchain4j.Ai;

@Ai.Service
@Ai.ChatMemoryWindow(10)
public interface ChatAiService {

    @SystemMessage("""
        You are an assistant that explains the result of an island-count analysis on a grid of 1s (land) and 0s (water).

        Given the total number of islands found using a BFS algorithm, respond clearly and in natural, friendly language, as if talking to a non-technical person.

        Always mention that the calculation was done using the BFS algorithm.

        Be direct, kind, and avoid technical terms. Always end your response without asking any questions.

            """)
    String chat(String question);
}