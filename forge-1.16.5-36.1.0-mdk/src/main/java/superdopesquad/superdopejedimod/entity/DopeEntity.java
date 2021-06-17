package superdopesquad.superdopejedimod.entity;


import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import superdopesquad.superdopejedimod.entity.critter.CritterEntity;
import superdopesquad.superdopejedimod.entity.critter.JawaEntity;
import superdopesquad.superdopejedimod.entity.critter.JawaModel;
import superdopesquad.superdopejedimod.entity.droid.AssassinDroidEntity;


public abstract class DopeEntity extends MonsterEntity {

    protected static double MAX_HEALTH = 16.0D;
    protected static double MOVEMENT_SPEED = 0.3D;


    public DopeEntity(EntityType<? extends DopeEntity> type, World worldIn) {
        super(type, worldIn);
    }


    public interface IFactory<T extends Entity> extends EntityType.IFactory<T> {
        T create(EntityType<T> p_create_1_, World p_create_2_);
    }



    public static <T extends Entity> EntityType<T> createEntity(DopeEntity.IFactory<T> factory, String name, EntityClassification classification) {

        // I'm getting a warning when using our private namespace for registering these entities.
        // Switching to use 'minecraft', although i bet some bug crops up in this area at some point.
        String namespace = "minecraft"; //  MC: I feel like this should be: SuperDopeJediMod.MODID;
        //EntityClassification classification = EntityClassification.MONSTER;
        //String name = "jawa";

        // Create the entity.
        EntityType<T> entityType = (EntityType<T>) EntityType.Builder.of(factory, classification)
                .sized(0.6F, 1.7F).setTrackingRange(8).build(name)
                .setRegistryName(new ResourceLocation(namespace, name));

        // Add this to our list, since we will have to do stuff to it.
        EntityManager.EntityTypes.add(entityType);

        return entityType;
    }

//    public static  class  RenderFactory implements IRenderFactory<DopeEntity> {
//        //public static  class  RenderFactory implements IRenderFactory<DopeEntity> {
//   //public static  class  RenderFactory implements IRenderFactory<DopeEntity> {
//
//        @Override
//       public EntityRenderer<? super DopeEntity> createRenderFor(EntityRendererManager manager) {
//        //public <T extends DopeEntity> EntityRenderer<T> createRenderFor(EntityRendererManager manager) {
//
//            return new Renderer(manager, DopeEntity.GetModel(), "textures/entity/jawa.png");
//            //return new Renderer(manager, new JawaModel<>(), "textures/entity/jawa.png");
//            //return new Renderer(manager, T.GetModel(), "textures/entity/jawa.png");
//
//        }
//
//        @Override
//        public EntityRenderer<? super DopeEntity> createRenderFor(EntityRendererManager manager) {
//            return null;
//        }
//
////        @Override
////        public EntityRenderer<? super DopeEntity> createRenderFor(EntityRendererManager manager) {
////            return null;
////        }
//    }

//    public static SegmentedModel<MonsterEntity> GetModel() {
//
//        return new JawaModel<>();
//    }
//
//        // I'm getting a warning when using our private namespace for registering these entities.
//        // Switching to use 'minecraft', although i bet some bug crops up in this area at some point.
//        String namespace = "minecraft"; //  MC: I feel like this should be: SuperDopeJediMod.MODID;
//
//        // Create the entity.
//        EntityType<? extends Entity> entity = EntityType.Builder.of(factory, classification)
//                .sized(0.6F, 1.7F).setTrackingRange(8).build(name)
//                .setRegistryName(new ResourceLocation(namespace, name));
//
//        // Add this to our list, since we will have to do stuff to it.
//        EntityManager.Entities.add(entity);
//
//        return entity;
    }
//

//
//    public static <T extends DopeEntity> EntityType<T> GetEntityType(Class<T> dopeEntityClass) {
//
//        // I'm getting a warning when using our private namespace for registering these entities.
//        // Switching to use 'minecraft', although i bet some bug crops up in this area at some point.
//        String namespace = "minecraft"; //  MC: I feel like this should be: SuperDopeJediMod.MODID;
//        EntityClassification classification = EntityClassification.MONSTER;
//        String name = "jawa";
//
//        // Create the entity.
//        EntityType<T> entity = (EntityType<T>) EntityType.Builder.of((DopeEntity.IFactory<T>, classification)
//                .sized(0.6F, 1.7F).setTrackingRange(8).build(name)
//                .setRegistryName(new ResourceLocation(namespace, name));
//
//        // Add this to our list, since we will have to do stuff to it.
//        EntityManager.Entities.add(entity);
//
//        return entity;
//
//
////        return (EntityType<JawaEntity>) EntityManager.createEntity(JawaEntity::new,
////                "jawa", EntityClassification.MONSTER);
//
//    }



//    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
//
//        return MonsterEntity.createMonsterAttributes()
//                .add(Attributes.MAX_HEALTH, AssassinDroidEntity.MAX_HEALTH)
//                .add(Attributes.MOVEMENT_SPEED, (double)AssassinDroidEntity.MOVEMENT_SPEED)
//                .add(Attributes.ATTACK_DAMAGE, AssassinDroidEntity.ATTACK_DAMAGE);
//    }

