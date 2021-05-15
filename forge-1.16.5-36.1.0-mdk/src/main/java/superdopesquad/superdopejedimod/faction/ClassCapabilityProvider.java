package superdopesquad.superdopejedimod.faction;

//import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
//import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
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


//	public SimpleCapabilityProvider(final Capability<HANDLER> capability, @Nullable final Direction facing, @Nullable final HANDLER instance) {
//		this.capability = capability;
//		this.facing = facing;
//
//		this.instance = instance;
//
//		if (this.instance != null) {
//			lazyOptional = LazyOptional.of(() -> this.instance);
//		} else {
//			lazyOptional = LazyOptional.empty();
//		}
//	}

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









//
//
//public class ClassCapabilityProvider  implements ICapabilitySerializable<INBT> {
//
//	protected final LazyOptional<ClassCapability> lazyOptional;
//
//
//	@CapabilityInject(ClassCapabilityInterface.class)
//	 public static final Capability<ClassCapabilityInterface> ClassCapability = null;
//
//	 //private ClassCapabilityInterface instance = ClassCapability.getDefaultInstance();
//	private ClassCapabilityInterface instance = ClassCapability.getDefaultInstance();


//	public ClassCapabilityProvider(final Capability<HANDLER> capability, @Nullable final Direction facing, @Nullable final HANDLER instance) {
//		this.capability = capability;
//		this.facing = facing;
//
//		this.instance = instance;
//
//		if (this.instance != null) {
//			lazyOptional = LazyOptional.of(() -> this.instance);
//		} else {
//			lazyOptional = LazyOptional.empty();
//		}
//	}


	
//	@Override
//	public boolean hasCapability(Capability<?> capability, Direction direction) {
//
//		//System.out.println("Inside hasCapability");
//		return capability == ClassCapability;
//	}
//
//
//	@Override
//	//public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
//	public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction direction) {
//
//		return getCapability().orEmpty(capability, lazyOptional);
//
//		//return null;
//		return capability == ClassCapability ? ClassCapability.<T> getClass(this.instance) : null;
//	}

//
//	@Override
//	public INBT serializeNBT() {
//
//		 return ClassCapability.getStorage().writeNBT(ClassCapability, this.instance, null);
//	}
//
//
//	@Override
//	public void deserializeNBT(INBT nbt) {
//
//		ClassCapability.getStorage().readNBT(ClassCapability, this.instance, null, nbt);
//	}
//}