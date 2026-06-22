# fix_create_crash_hoax (Create Crash Fix Crash Fix)

修复 [create_crash_fix_crash](https://modrinth.com/user/JN520) 的崩溃。

##链

```
createcrashfix                    — 机械动力崩溃修复
    ↓ 安装它
create_crash_fix_crash            — 检测到上者就崩
    ↓ 安装本 mod
fix_create_crash_hoax             — Mixin 吞掉上面的异常
    ↓ ???
```

## 技术原理

Mixin 注入 `CrashProcedure.execute()`，取消 RuntimeException 的抛出。

仅在 `create_crash_fix_crash` 已加载时激活 Mixin（MixinPlugin 条件判断）。

## 构建

```bash
gradlew jar
```

产物在 `build/libs/`。

## 许可

MIT License — 随便用，整活无国界。
