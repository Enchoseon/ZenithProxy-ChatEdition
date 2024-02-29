package com.zenith.util;

import java.time.Instant;

public class TickTimer extends Timer {
    // one tick = 50ms
    private static final long TICK_TIME_CONSTANT = 50L;

    public TickTimer() {
        super();
    }

    @Override
    public long tickTimeConstant() {
        return TICK_TIME_CONSTANT;
    }

    public boolean tick(final long delay, final boolean resetIfTick) {
        if (Instant.now().toEpochMilli() - this.time.toEpochMilli() > delay * TICK_TIME_CONSTANT) {
            if (resetIfTick) {
                this.time = Instant.now();
            }
            return true;
        } else {
            return false;
        }
    }
}
