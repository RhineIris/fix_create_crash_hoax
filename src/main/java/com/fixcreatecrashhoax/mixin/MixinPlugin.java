package com.fixcreatecrashhoax.mixin;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

/**
 * 仅在 create_crash_fix_crash 存在时激活 Mixin
 */
public class MixinPlugin implements IMixinConfigPlugin {

    private boolean targetModLoaded;

    @Override
    public void onLoad(String mixinPackage) {
        targetModLoaded = net.minecraftforge.fml.ModList.get() != null
                && net.minecraftforge.fml.ModList.get().isLoaded("create_crash_fix_crash");
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return targetModLoaded;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}
