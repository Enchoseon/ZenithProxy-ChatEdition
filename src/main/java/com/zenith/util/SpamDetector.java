package com.zenith.util;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

// Very light Server -> Discord anti-spam
public class SpamDetector {
    private HashMap<UUID, List<String>> userLastMessagesMap = new HashMap<>();
    private final int MAX_MESSAGES = 3;

    public boolean isSpam(UUID senderUUID, String newMessage) {
        String processed = newMessage.toLowerCase().replaceAll("\\p{Punct}", "");
        List<String> lastMessages = userLastMessagesMap.getOrDefault(senderUUID, new ArrayList<>());

        if (lastMessages.contains(processed)) return true;

        if (lastMessages.size() >= MAX_MESSAGES)
            lastMessages.remove(0);
        lastMessages.add(processed);

        userLastMessagesMap.put(senderUUID, lastMessages);
        return false;
    }
}
