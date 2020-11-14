package com.sb.di2;

import java.util.Random;
import java.util.stream.IntStream;

public class Dice {
    private Integer amount; // 幾顆
    private Integer score; // 分數

    public Dice() {
    }

    public Dice(Integer amount) {
        this.amount = amount;
        final Random r = new Random();
        IntStream.range(0, amount).forEach(i -> score += r.nextInt(6)+1);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Dice{" + "amount=" + amount + ", score=" + score + '}';
    }
    
    
}
