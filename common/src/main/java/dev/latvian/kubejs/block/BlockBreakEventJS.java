package dev.latvian.kubejs.block;

import dev.latvian.kubejs.entity.EntityJS;
import dev.latvian.kubejs.player.PlayerEventJS;
import dev.latvian.kubejs.world.BlockContainerJS;
import me.shedaniel.architectury.utils.IntValue;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * @author LatvianModder
 */
public class BlockBreakEventJS extends PlayerEventJS
{
	public final ServerPlayer entity;
	public final Level world;
	public final BlockPos pos;
	public final BlockState state;
	@Nullable
	public final IntValue xp;

	public BlockBreakEventJS(ServerPlayer entity, Level world, BlockPos pos, BlockState state, @Nullable IntValue xp)
	{
		this.entity = entity;
		this.world = world;
		this.pos = pos;
		this.state = state;
		this.xp = xp;
	}

	@Override
	public boolean canCancel()
	{
		return true;
	}

	@Override
	public EntityJS getEntity()
	{
		return entityOf(entity);
	}

	public BlockContainerJS getBlock()
	{
		return new BlockContainerJS(world, pos)
		{
			@Override
			public BlockState getBlockState()
			{
				return state;
			}
		};
	}

	public int getXp()
	{
		if (xp == null)
		{
			return 0;
		}
		return xp.getAsInt();
	}

	public void setXp(int xp)
	{
		if (this.xp != null)
		{
			this.xp.accept(xp);
		}
	}
}