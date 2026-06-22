package com.fixcreatecrashhoax.mixin;

import createcrashfixcrash.procedures.CrashProcedure;
import net.minecraftforge.eventbus.api.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * 直接劫持 CrashProcedure.execute(Event) 方法
 * <p>
 * 原方法：if (ModList.get().isLoaded("createcrashfix")) throw RuntimeException
 * 我们：直接 cancel，方法体不执行
 */
@Mixin(value = CrashProcedure.class, remap = false)
public abstract class CrashProcedureMixin {

    /**
     * 在 execute(Event) 入口处拦截，取消整个方法执行
     */
    @Inject(method = "execute(Lnet/minecraftforge/eventbus/api/Event;)V",
            at = @At("HEAD"),
            cancellable = true,
            remap = false)
    private static void onExecute(Event event, CallbackInfo ci) {
        ci.cancel();
    }
}
