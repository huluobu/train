package com.carrot.train.factory2;

public class GoldFactory implements CardFactory {
    public Card produce() {
        return new GoldCard();
    }
}
