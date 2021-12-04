package dev.latvian.mods.kubejs;

import dev.latvian.mods.kubejs.client.SoundRegistryEventJS;
import dev.latvian.mods.kubejs.script.ScriptType;
import net.minecraft.sounds.SoundEvent;

/**
 * @author LatvianModder
 */
public class KubeJSOtherEventHandler {
	public static void init() {
		new SoundRegistryEventJS(id -> KubeJSRegistries.soundEvents().register(id, () -> new SoundEvent(id))).post(ScriptType.STARTUP, KubeJSEvents.SOUND_REGISTRY);
	}
}