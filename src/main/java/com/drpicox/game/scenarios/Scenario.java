package com.drpicox.game.scenarios;

import java.util.Properties;
import java.util.function.BiConsumer;

public class Scenario {
    private Properties props;

    public Scenario(Properties props) {
        this.props = props;
    }

    public void forEach(String preffix, BiConsumer<String, String> action) {
        props.forEach((okey, ovalue) -> {
            var key = okey.toString();
            if (!key.startsWith(preffix)) return;

            var value = ovalue.toString();
            action.accept(key, value);
        });
    }
}
