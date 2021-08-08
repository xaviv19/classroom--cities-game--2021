package com.drpicox.game.testMocks;

import com.drpicox.game.old.players.RandomPlayerPicker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class RandomPlayerPickerTestConfiguration {

    private final RandomPlayerPickerMock randomPlayerPickerMock;

    public RandomPlayerPickerTestConfiguration(RandomPlayerPickerMock randomPlayerPickerMock) {
        this.randomPlayerPickerMock = randomPlayerPickerMock;
    }

    @Bean
    @Primary
    public RandomPlayerPicker randomPlayerPicker() {
        return randomPlayerPickerMock;
    }
}
