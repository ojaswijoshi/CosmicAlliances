package com.tmsimple.cosmicalliances;

public class LevelManager {
    private int currentLevel;

    public LevelManager() {
        this.currentLevel = 1; // Assuming starting level
    }

    public void loadNextLevel() {
        currentLevel++;
        // Logic to load next level, e.g., reset player position, update obstacles, etc.
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    // Add other necessary methods for managing levels
}
