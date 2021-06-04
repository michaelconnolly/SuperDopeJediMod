package superdopesquad.superdopejedimod.faction;


import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import javax.annotation.Nullable;


public class ClassCapabilityProvider<ClassCapability>  implements ICapabilityProvider, ICapabilitySerializable<INBT> {

	protected final Capability<ClassCapability> capability;
	protected final Direction facing;
	protected final ClassCapability instance;
	protected final LazyOptional<ClassCapability> lazyOptional;


	public ClassCapabilityProvider(final Capability<ClassCapability> capability, @Nullable final Direction facing) {
		this(capability, facing, capability.getDefaultInstance());
	}

	public ClassCapabilityProvider(final Capability<ClassCapability> capability, @Nullable final Direction facing, @Nullable final ClassCapability instance) {
		//super(capability, facing, instance);

		this.capability = capability;
		this.facing = facing;

		this.instance = instance;

		if (this.instance != null) {
			lazyOptional = LazyOptional.of(() -> this.instance);
		} else {
			lazyOptional = LazyOptional.empty();
		}
	}

	@Nullable
	@Override
	public INBT serializeNBT() {
		final ClassCapability instance = getInstance();

		if (instance == null) {
			return null;
		}

		return getCapability().writeNBT(instance, getFacing());
	}

	@Override
	public void deserializeNBT(final INBT nbt) {
		final ClassCapability instance = getInstance();

		if (instance == null) {
			return;
		}

		getCapability().readNBT(instance, getFacing(), nbt);
	}


	@Override
	public <T> LazyOptional<T> getCapability(final Capability<T> capability, @Nullable final Direction facing) {
		return getCapability().orEmpty(capability, lazyOptional);
	}

	public final Capability<ClassCapability> getCapability() {
		return capability;
	}

	@Nullable
	public Direction getFacing() {
		return facing;
	}

	@Nullable
	public final ClassCapability getInstance() {
		return instance;
	}
}
