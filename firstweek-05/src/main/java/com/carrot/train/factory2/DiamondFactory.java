package com.carrot.train.factory2;

public class DiamondFactory implements CardFactory {
    public Card produce() {
        return new DiamondCard();
    }
}
