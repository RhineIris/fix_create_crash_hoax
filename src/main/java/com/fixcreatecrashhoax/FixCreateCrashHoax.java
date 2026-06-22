package com.fixcreatecrashhoax;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 修复 "机械动力：崩溃修复" (create_crash_fix_crash) 的崩溃
 * <p>
 * 原 mod 逻辑：检测到 {@code createcrashfix} 已加载 → throw RuntimeException
 * 本 mod 逻辑：Mixin 吞掉该异常，让两个 mod 和平共处
 * <p>
 * 套娃链：
 * <ol>
 *   <li>createcrashfix — 机械动力的崩溃修复</li>
 *   <li>create_crash_fix_crash — 加载 ① 就崩 ("你为什么要这么做？")</li>
 *   <li>fix_create_crash_hoax — 修掉 ② 的崩溃 (本 mod)</li>
 *   <li>??? — 下一个整活等你来做</li>
 * </ol>
 */
@Mod(FixCreateCrashHoax.MODID)
public class FixCreateCrashHoax {
    public static final String MODID = "fix_create_crash_hoax";
    public static final Logger LOGGER = LogManager.getLogger();

    public FixCreateCrashHoax() {
        LOGGER.info("已加载。create_crash_fix_crash 的崩溃已被修复。");
        LOGGER.info("\"你为什么要这么做？\" → \"我这么做是为了让你不崩。\"");
    }
}
