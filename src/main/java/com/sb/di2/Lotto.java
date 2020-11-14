package com.sb.di2;

import java.util.Set;

public class Lotto {
    private Set<Integer> nums;

    public Set<Integer> getNums() {
        return nums;
    }

    public void setNums(Set<Integer> nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "Lotto{" + "nums=" + nums + '}';
    }
    
}
