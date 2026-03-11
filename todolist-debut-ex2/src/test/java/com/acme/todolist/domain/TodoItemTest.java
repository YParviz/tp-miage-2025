package com.acme.todolist.domain;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TodoItemTest {

    @Test
    void testItemEnRetardAfficheLate() {
        Instant ilYaDeuxJours = Instant.now().minus(2, ChronoUnit.DAYS);
        TodoItem itemRetard = new TodoItem("1", ilYaDeuxJours, "Faire le TP");

        String contenu = itemRetard.finalContent();
        assertTrue(contenu.startsWith("[LATE!] "), "Le tag [LATE!] doit être ajouté au début");
        assertEquals("[LATE!] Faire le TP", contenu);
    }

    @Test
    void testItemPasEnRetardAfficheContenuNormal() {
        Instant ilYaDeuxHeures = Instant.now().minus(2, ChronoUnit.HOURS);
        TodoItem itemNormal = new TodoItem("2", ilYaDeuxHeures, "Manger");

        String contenu = itemNormal.finalContent();
        assertFalse(contenu.startsWith("[LATE!]"), "Le tag [LATE!] ne doit pas être présent");
        assertEquals("Manger", contenu);
    }
}