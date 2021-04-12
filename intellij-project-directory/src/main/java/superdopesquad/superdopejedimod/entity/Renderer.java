package superdopesquad.superdopejedimod.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superdopesquad.superdopejedimod.SuperDopeJediMod;


@OnlyIn(Dist.CLIENT)
public class Renderer extends MobRenderer<MonsterEntity, SegmentedModel<MonsterEntity>> {

    String texturePath;


  public Renderer(EntityRendererManager manager, SegmentedModel<MonsterEntity> model, String texturePath) {

        super(manager, model, 0F);

        this.texturePath = texturePath;
    }


    @Override
    public ResourceLocation getEntityTexture(MonsterEntity entity) {

        return new ResourceLocation(SuperDopeJediMod.MODID, this.texturePath);
    }
}