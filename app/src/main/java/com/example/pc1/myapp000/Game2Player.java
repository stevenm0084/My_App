package com.example.pc1.myapp000;

import android.content.BroadcastReceiver;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

import java.nio.channels.Channel;
import java.util.Random;

/**
 * Created by PC1 on 27-Apr-15.
 */
public class Game2Player {

    private String playerWeapon, cpuWeapon;
    private Random cpuGuessGenerator;
    private int currentRound;
    private int playerScore;
    private int cpuScore;
    private final int NUM_OF_ROUNDS = 3;
    private boolean gameFinished;

    public enum WinLoseOutcome {WIN, LOSE, TIE}

    WinLoseOutcome gameOutcome;
    private String[] Weapons = {"ROCK", "SCISSORS", "PAPER", "LIZARD", "SPOCK"};

    public Game2Player() {
        playerScore = 0;
        cpuScore = 0;
        currentRound = 1;
        gameFinished = false;
        gameOutcome = null;

    }

    public void setPlayerWeapon(String weapon) {
        switch (weapon) {
            case "ROCK":
                playerWeapon = Weapons[0];
                break;
            case "SCISSORS":
                playerWeapon = Weapons[1];
                break;
            case "PAPER":
                playerWeapon = Weapons[2];
                break;
            case "LIZARD":
                playerWeapon = Weapons[3];
                break;
            case "SPOCK":
                playerWeapon = Weapons[4];
                break;
            default:
                playerWeapon = Weapons[0];
                break;
        }
    }

    public void playRound() {

        if (currentRound < NUM_OF_ROUNDS) {
            cpuGuessGenerator = new Random();
            Log.i("GAME", "currentRound = " + currentRound);

            int cpuGuess = cpuGuessGenerator.nextInt((3 - 0) + 1);
            Log.v("PlayGameActivity", "cpuGuess = " + cpuGuess);
            cpuWeapon = Weapons[cpuGuess];

            if (playerWeapon.equals("ROCK")) {
                if (cpuWeapon.equals("SCISSORS") || cpuWeapon.equals("LIZARD")) {
                    //player wins
                    playerScore++;

                } else if (cpuWeapon.equals("SPOCK") || cpuWeapon.equals("PAPER")) {
                    //cpu wins
                    cpuScore++;
                }

            } else if (playerWeapon.equals("SCISSORS")) {
                if (cpuWeapon.equals("PAPER") || cpuWeapon.equals("LIZARD")) {
                    //player wins
                    playerScore++;

                } else if (cpuWeapon.equals("SPOCK") || cpuWeapon.equals("ROCK")) {
                    //cpu wins
                    cpuScore++;
                }
            } else if (playerWeapon.equals("PAPER")) {
                if (cpuWeapon.equals("ROCK") || cpuWeapon.equals("SPOCK")) {
                    //player wins
                    playerScore++;

                } else if (cpuWeapon.equals("SCISSORS") || cpuWeapon.equals("LIZARD")) {
                    //cpu wins
                    cpuScore++;
                }
            } else if (playerWeapon.equals("LIZARD")) {
                if (cpuWeapon.equals("SPOCK") || cpuWeapon.equals("PAPER")) {
                    //player wins
                    playerScore++;

                } else if (cpuWeapon.equals("SCISSORS") || cpuWeapon.equals("ROCK")) {
                    //cpu wins
                    cpuScore++;
                }
            } else if (playerWeapon.equals("SPOCK")) {
                if (cpuWeapon.equals("SCISSORS") || cpuWeapon.equals("SPOCK")) {
                    //player wins
                    playerScore++;

                } else if (cpuWeapon.equals("PAPER") || cpuWeapon.equals("LIZARD")) {
                    //cpu wins
                    cpuScore++;
                }
            } else {
                //game ties
            }
            currentRound++;
        } else {
            //game is finished
            checkWin();
            gameFinished = true;
            Log.i("GAME", "GAME IS FINISHED");
        }
    }

    public void checkWin() {
        if (this.playerScore < this.cpuScore) {
            gameOutcome = WinLoseOutcome.WIN;
        } else if (this.playerScore == this.cpuScore) {
            gameOutcome = WinLoseOutcome.TIE;
        } else {
            gameOutcome = WinLoseOutcome.LOSE;
        }
    }

/*    public String getGameOutcome() {

        if(playerResult == WinLoseOutcome.WIN){
            return "WIN";
        } else if(playerResult == WinLoseOutcome.LOSE){
            return "LOSE";
        } else {
            return "TIE";
        }

    }*/

    public WinLoseOutcome getGameOutcome() {
        return gameOutcome;
    }


    public boolean isGameFinished() {
        return gameFinished;
    }

    public int getPlayerScore() {
        Log.i("GAME", "player score: " + this.playerScore);
        return playerScore;
    }

    public int getCpuScore() {
        Log.i("GAME", "cpu score: " + this.cpuScore);
        return cpuScore;
    }
}
