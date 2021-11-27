package com.drpicox.game.components.containeds;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface ContainedsRepository extends JpaRepository<Contained, String> {

    List<Contained> findAllByContainerIdIn(List<String> containersId);
}
