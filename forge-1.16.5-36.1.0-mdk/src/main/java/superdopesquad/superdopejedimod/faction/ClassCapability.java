package superdopesquad.superdopejedimod.faction;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class ClassCapability implements ClassCapabilityInterface {

	private Integer _classId = 0; // don't let this be null, pain and suffering will follow.
	private LivingEntity entity = null;


	public ClassCapability(LivingEntity playerEntity) {
		this.entity = playerEntity;
	}


	public boolean setClassId(Integer classId) {
		
		this._classId = classId;
		
		return true;
	}


	public Integer getClassId() {
		
		return this._classId;
	}
}