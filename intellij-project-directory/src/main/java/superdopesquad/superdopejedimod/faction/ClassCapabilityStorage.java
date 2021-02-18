package superdopesquad.superdopejedimod.faction;


import net.minecraft.nbt.INBT;
//import net.minecraft.nbt.NBTBase;
//import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.IntNBT;
//import net.minecraft.nbt.NBTTagString;
import net.minecraft.nbt.NBTTypes;
import net.minecraft.util.Direction;
//import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.util.Constants;


public class ClassCapabilityStorage implements IStorage<ClassCapabilityInterface> {


	@Override
	public INBT writeNBT(Capability<ClassCapabilityInterface> capability, ClassCapabilityInterface instance, Direction direction) {

		////return NBT.
		//return new NBTTagInt(instance.get());
		return null;
	}


	@Override
	public void readNBT(Capability<ClassCapabilityInterface> capability, ClassCapabilityInterface instance, Direction direction, INBT nbt) {
	
		// Did we accumulate unexpected crud in there?  Deal with it!  Error handling is your friend.
		if (nbt.getClass() != IntNBT.class) {
			System.out.println("Bad value found via ClassCapabilityStorage:readNBT");
			instance.set(0);
			return;
		}
	
		instance.set(((IntNBT) nbt).getInt());
	}
}