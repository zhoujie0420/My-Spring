package org.springframework.beans;

public class BeansException extends Throwable {
    public BeansException(String s) {
        super(s);
    }

    public BeansException(String s, Exception e) {
        super(s, e);
    }
}
