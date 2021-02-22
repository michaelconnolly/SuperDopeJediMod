package superdopesquad.superdopejedimod.material;

public class MaterialManager {

    // Beskar, used to create heavy weapons and heavy armor.
    public static final Beskar BESKAR = new Beskar("beskar");
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
}
