package net.seanomik.tamablefoxes.versions.version_1_21_5_R1;

import net.minecraft.core.UUIDUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntArrayTag;

import java.util.UUID;

public class NMSUtil {

    public static void putUUID(CompoundTag compoundTag, String key, UUID uuid) {
        compoundTag.put(key, createUUIDTag(uuid));
    }

    public static UUID getUUID(CompoundTag compoundTag, String key) {
        int[] result = compoundTag.getIntArray(key).orElse(null);
        if (result == null) return null;
        return getUUITFromTag(result);
    }

    public static UUID getUUITFromTag(int[] intArray) {
        return UUIDUtil.uuidFromIntArray(intArray);
    }

    public static IntArrayTag createUUIDTag(UUID var0) {
        return new IntArrayTag(UUIDUtil.uuidToIntArray(var0));
    }
}
