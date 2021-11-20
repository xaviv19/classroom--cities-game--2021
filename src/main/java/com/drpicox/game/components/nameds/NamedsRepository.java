package com.drpicox.game.components.nameds;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface NamedsRepository extends JpaRepository<Named, String> {
    List<Named> findAllByName(String name);
}
