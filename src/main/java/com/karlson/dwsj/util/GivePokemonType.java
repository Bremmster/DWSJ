package com.karlson.dwsj.util;

import org.apache.kafka.common.protocol.types.Field;

import java.util.List;
import java.util.Random;

public class GivePokemonType {

    private static final List<Types> types = List.of(Types.values());
    private static final int typeSize = types.size();

    public static String get(Random random) {
        return types.get(random.nextInt(typeSize)).toString();

    }
}
