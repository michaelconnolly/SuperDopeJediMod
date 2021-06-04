package superdopesquad.superdopejedimod.material;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import superdopesquad.superdopejedimod.DopeBlock;
import superdopesquad.superdopejedimod.DopeItem;
import superdopesquad.superdopejedimod.building.SithTowerBlueprint;

import java.util.ArrayList;


public class MaterialManager {

    // Cache the list of blocks that we need to generate; we'll need this later.
    public static ArrayList<DopeBlockGeneratable> generatableBlocks = new ArrayList<DopeBlockGeneratable>();

    // Beskar, used to create heavy weapons and heavy armor.
    public static final DopeBlock BESKAR = new DopeBlock("beskar", Material.HEAVY_METAL);
    public static final DopeBlockGeneratable BESKAR_ORE = new DopeBlockGeneratable("beskar_ore", Material.HEAVY_METAL);
    public static final DopeItem BESKAR_INGOT = new DopeItem("beskar_ingot", ItemGroup.TAB_MATERIALS);

    // Quadanium, used to create vehicles and other big things.
    public static final DopeBlock QUADANIUM = new DopeBlock("quadanium", Material.HEAVY_METAL);
    public static final DopeBlockGeneratable QUADANIUM_ORE = new DopeBlockGeneratable("quadanium_ore", Material.HEAVY_METAL);
    public static final DopeItem QUADANIUM_INGOT = new DopeItem("quadanium_ingot", ItemGroup.TAB_MATERIALS);

    // Plastoid, used to create medium weapons and medium armor.
    public static final DopeBlock PLASTOID = new DopeBlock("plastoid", Material.HEAVY_METAL);
    public static final DopeBlockGeneratable PLASTOID_SCRAPS = new DopeBlockGeneratable("plastoid_scraps", Material.HEAVY_METAL);
    public static final DopeItem PLASTOID_SHEET = new DopeItem("plastoid_sheet", ItemGroup.TAB_MATERIALS);

    // KyberCrystal, used to create lightsabers.
    public static final DopeBlock KYBER_CRYSTAL_CHUNK = new DopeBlock("kyber_crystal_chunk", Material.HEAVY_METAL);
    public static final DopeBlockGeneratable KYBER_CRYSTAL_ORE = new DopeBlockGeneratable("kyber_crystal_ore", Material.HEAVY_METAL);
    public static final DopeItem KYBER_CRYSTAL = new DopeItem("kyber_crystal", ItemGroup.TAB_MATERIALS);

    // Autoblocks!
    public static final SithTowerBlueprint SITH_MARK = new SithTowerBlueprint("sith_mark");


    public void GenerateOre(final BiomeLoadingEvent event) {

        if (!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND))) {

            for (int i=0; i<this.generatableBlocks.size(); i++) {
                this.generatableBlocks.get(i).GenerateOre(event);
            }
        }
    }
}
