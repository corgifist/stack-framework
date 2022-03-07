package com.stack.framework.boot;

public class Boot {
    private static BootSeq seq;

    public static BootSeq getSeq() {
        return seq;
    }

    public static void setSeq(BootSeq seq) {
        Boot.seq = seq;
    }
}
