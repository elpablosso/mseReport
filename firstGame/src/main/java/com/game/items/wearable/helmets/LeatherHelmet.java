package com.game.items.wearable.helmets;

import com.game.items.wearable.helmets.Helmet;

public class LeatherHelmet extends Helmet {

    public LeatherHelmet() {
        super(1,
                "Leather Helmet",
                "Regular helmet made of leather",
                200,
                1,
                1,
                5);
    }

    public LeatherHelmet(int itemLevel) {
        super(1,
                "Leather Helmet",
                "Regular helmet made of leather",
                200,
                1,
                itemLevel,
                5);
    }
}
