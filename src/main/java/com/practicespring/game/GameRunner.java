package com.practicespring.game;

public class GameRunner {

    private final MarioGame game;
    public GameRunner(MarioGame marioGame) {

        this.game = marioGame;
    }

    public void run() {
        System.out.println("Running game: "+ game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
