package superdopesquad.superdopejedimod.material;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BiomeLoadingEvent;


public class MaterialManager {

    // Beskar, used to create heavy weapons and heavy armor.
    public final Beskar BESKAR = new Beskar("beskar");
    public static final BeskarOre BESKAR_ORE = new BeskarOre("beskar_ore");
    public static final BeskarIngot BESKAR_INGOT = new BeskarIngot("beskar_ingot");

    // Quadanium, used to create vehicles and other big things.
    public static final Quadanium QUADANIUM = new Quadanium("quadanium");
    public static final QuadaniumOre QUADANIUM_ORE = new QuadaniumOre("quadanium_ore");
    public static final QuadaniumIngot QUADANIUM_INGOT = new QuadaniumIngot("quadanium_ingot");

    // Plastoid, used to create medium weapons and medium armor.
    public static final Plastoid PLASTOID = new Plastoid("plastoid");
    public static final PlastoidScraps PLASTOID_SCRAPS = new PlastoidScraps("plastoid_scraps");
    public static final PlastoidSheet PLASTOID_SHEET = new PlastoidSheet("plastoid_sheet");


    public MaterialManager() {
    }


    public void GenerateOre(final BiomeLoadingEvent event) {

        if (!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND))) {

            MaterialManager.BESKAR_ORE.GenerateOre(event);
            MaterialManager.QUADANIUM_ORE.GenerateOre(event);
            MaterialManager.PLASTOID_SCRAPS.GenerateOre(event);
        }
    }
}
