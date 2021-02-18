package superdopesquad.superdopejedimod.faction;

//import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
//import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ClassCapabilityProvider  implements ICapabilitySerializable<INBT> {

	
	@CapabilityInject(ClassCapabilityInterface.class)
	 public static final Capability<ClassCapabilityInterface> ClassCapability = null;

	 private ClassCapabilityInterface instance = ClassCapability.getDefaultInstance();

	
//	@Override
//	public boolean hasCapability(Capability<?> capability, Direction direction) {
//
//		//System.out.println("Inside hasCapability");
//		return capability == ClassCapability;
//	}
//

	@Override
	//public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
	public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction direction) {

		return null;
		//return capability == ClassCapability ? ClassCapability.<T> getClass(this.instance) : null;
	}

	
	@Override
	public INBT serializeNBT() {

		 return ClassCapability.getStorage().writeNBT(ClassCapability, this.instance, null);
	}


	@Override
	public void deserializeNBT(INBT nbt) {

		ClassCapability.getStorage().readNBT(ClassCapability, this.instance, null, nbt);
	}
}