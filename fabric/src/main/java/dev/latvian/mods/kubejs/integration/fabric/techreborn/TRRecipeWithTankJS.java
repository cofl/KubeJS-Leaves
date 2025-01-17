package dev.latvian.mods.kubejs.integration.fabric.techreborn;

import com.google.gson.JsonObject;
import dev.latvian.mods.kubejs.util.ListJS;

/**
 * @author LatvianModder
 */
public class TRRecipeWithTankJS extends TRRecipeJS {
	@Override
	public void create(ListJS args) {
		super.create(args);
		tank(args.size() >= 5 ? args.get(4).toString() : "minecraft:water", args.size() >= 6 ? ((Number) args.get(5)).intValue() : 1000);
	}

	public TRRecipeWithTankJS tank(String fluidId, int amount) {
		var o = new JsonObject();
		o.addProperty("fluid", fluidId);
		o.addProperty("amount", amount);
		json.add("tank", o);
		save();
		return this;
	}
}
