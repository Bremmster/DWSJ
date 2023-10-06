package com.karlson.pokemondata.util;

import java.util.List;
import java.util.Random;

public class GivePokemonType {

    private static final List<Types> types = List.of(Types.values());
    private static final int TYPE_SIZE = types.size();

    public static String get(Random random) {
        return types.get(random.nextInt(TYPE_SIZE)).toString();
    }

    private GivePokemonType() {
    }
}
