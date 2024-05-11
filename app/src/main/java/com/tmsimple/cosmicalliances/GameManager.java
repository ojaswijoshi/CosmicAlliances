package com.tmsimple.cosmicalliances;

public class GameManager {
    private int score;
    private int health;
    private LevelManager levelManager;

    public GameManager() {
        this.score = 0;
        this.health = 100; // Assuming starting health
        this.levelManager = new LevelManager();
    }

    public void updateScore(int points) {
        score += points;
    }

    public void updateHealth(int damage) {
        health -= damage;
        if (health <= 0) {
            // Game over logic, e.g., show game over screen, reset level, etc.
        }
    }

    // Add other necessary methods for managing game state
}
