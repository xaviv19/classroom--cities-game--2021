package com.drpicox.game.testSteps.docks;

import com.drpicox.game.ecs.EntityResponse;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class DockTestView {
    public static Predicate<EntityResponse> isDock() {
        return e -> (Boolean) e.getOrDefault("isDock", Boolean.FALSE);
    }
}
