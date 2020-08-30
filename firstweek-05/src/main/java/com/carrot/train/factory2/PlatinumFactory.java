package com.carrot.train.factory2;

public class PlatinumFactory implements CardFactory {
    public Card produce() {
        return new Platinum();
    }
}
