package superdopesquad.superdopejedimod.faction;


import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;


public class ClassCapabilityStorage implements IStorage<ClassCapabilityInterface> {


	@Override
	public INBT writeNBT(Capability<ClassCapabilityInterface> capability, ClassCapabilityInterface instance, Direction direction) {


		CompoundNBT props = new CompoundNBT();
		props.putInt("classId", instance.getClassId());

		return props;
	}


	@Override
	public void readNBT(Capability<ClassCapabilityInterface> capability, ClassCapabilityInterface instance, Direction direction, INBT nbt) {

		CompoundNBT props = (CompoundNBT) nbt;
		instance.setClassId(props.getInt("classId"));
	}
}
