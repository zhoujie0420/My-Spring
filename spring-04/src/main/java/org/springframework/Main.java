package org.springframework;

import cn.hutool.core.lang.Assert;

public class Main {
    public static void main(String[] args) {
        String s = null;

        Assert.notNull(s, "s must not be null");
        System.out.println("s is not null");
    }
}