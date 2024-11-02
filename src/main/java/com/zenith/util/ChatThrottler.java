package com.zenith.util;

import com.zenith.Proxy;
import org.geysermc.mcprotocollib.protocol.packet.ingame.serverbound.ServerboundChatPacket;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;

public class ChatThrottler {
    private static final long THROTTLE_THRESHOLD_SECONDS = 2;
    private static final long DELAY_SECONDS = 3;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private Instant lastMessageSent = Instant.MIN;
    private Instant lastScheduledMessage = Instant.MIN;

    private static final Pattern containsDollarSignPattern = Pattern.compile("\\$");

    public synchronized void sendMessageWithThrottle(String message) {
        if (isSpam(message)) return;

        Instant now = Instant.now();
        long secondsSinceLastMessage = Duration.between(lastMessageSent, now).getSeconds();

        if (secondsSinceLastMessage >= THROTTLE_THRESHOLD_SECONDS) {
            sendMessageNow(message);
        } else {
            delay(message, now);
        }
    }

    private void sendMessageNow(String message) {
        Proxy.getInstance().getClient().sendAsync(new ServerboundChatPacket(message));
        lastMessageSent = Instant.now();
        lastScheduledMessage = lastMessageSent;
    }

    private void delay(String message, Instant now) {
        long secondsSinceLastScheduled = Duration.between(lastScheduledMessage, now).getSeconds();
        long delay = Math.max(DELAY_SECONDS - secondsSinceLastScheduled, 0);
        scheduler.schedule(() -> {
            sendMessageNow(message);
        }, delay, TimeUnit.SECONDS);
        lastScheduledMessage = now.plusSeconds(delay);
    }

    private boolean isSpam(String message) {
        return containsDollarSignPattern.matcher(message).find();
    }
}
