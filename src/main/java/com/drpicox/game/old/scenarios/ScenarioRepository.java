package com.drpicox.game.old.scenarios;

import org.springframework.data.jpa.repository.JpaRepository;

interface ScenarioRepository extends JpaRepository<Scenario, String> {
    // see https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
}
