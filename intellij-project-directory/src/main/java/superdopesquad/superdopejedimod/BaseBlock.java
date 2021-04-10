package superdopesquad.superdopejedimod;

import java.util.Random;

//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.RenderItem;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.entity.Entity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
//import net.minecraft.item.ItemBlock;
//import net.minecraft.world.World;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.RegistryObject;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.SuperDopeObjectGeneratable;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;



public class BaseBlock extends Block implements SuperDopeObjectGeneratable {


	public BaseBlock(String name, Block.Properties properties) {

		super(properties);

		SuperDopeJediMod.BLOCKS.register(name, () -> this);
		SuperDopeJediMod.ITEMS.register(name, () -> new BlockItem(this,
				new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	}

	public BaseBlock(String name) {

		this(name, Properties.create(Material.IRON));


		//this(name, new Item.Properties().group(ItemGroup.MISC).
	}



	public BaseBlock(Material material, String name) {

		this(material, name, true);
	}
	
	//MC-TODO: why is this not calling register code?
	public BaseBlock(Material material, String name, boolean showUpInCreativeTab) {

		//super (new Properties().gr
		//super(Properties.create(material).);
		super(Properties.create(material));

		//super(new Properties(material, material.getColor()));
		// Call our super class constructor, "Block".
		//super(material);
		//super(new Properties());

//		// Stash our internal name that we'll use for this block.
//		this._name = name;
//
//		// I don't know what happens if you don't call this, but it is in every tutorial :-)
//		this.setUnlocalizedName(name);
//
//		// We'll need to keep this value around.
//		this._showUpInCreativeTab = showUpInCreativeTab;
//
//		// By default, we'll put all new blocks in the blocks tab.
//		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
//
		// Insert this object into our collection of custom blocks, so we 
		// can send separate events to it for lifecycle management.
		//SuperDopeJediMod.customObjects.add(this);
	}
	

	@Override // from SuperDopeObject
	public void registerBlocks(RegistryEvent.Register<Block> event) {

		event.getRegistry().register(this);

//		public void registerBlocks(RegistryEvent.Register<Block> event) {
//			event.getRegistry().registerAll(new Block(...), new Block(...), ...);
//
//		public static final RegistryObject<Block> ROCK_BLOCK = BLOCKS.register("rock", () -> new Block(Block.Properties.create(Material.ROCK)));
//
//public ExampleMod() {
//			BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
//		}
//
//		// System.out.println("Inside BaseBlock:registerBlocks: this.getName(): " + (this.getName() == null ? "null" : this.getName()));
//		// System.out.println("Inside BaseBlock:registerBlocks: this.getFullName(): " + this.getFullName());
//		// System. out.println("Inside BaseBlock:registerBlocks: this.getRegistryName(): " + (this.getRegistryName() == null ? "null" : this.getRegistryName().toString()));
//
//		this.setRegistryName(this.getName());
//		event.getRegistry().register(this);

		// System.out.println("Inside BaseBlock:registerBlocks: this.getRegistryName(): " + (this.getRegistryName() == null ? "null" : this.getRegistryName().toString()));
	}
//
//
//	@Override // from SuperDopeObject
//    public void registerItems(RegistryEvent.Register<Item> event) {
//
//		// System.out.println("Inside BaseBlock:registerItems: this.getName(): " + (this.getName() == null ? "null" : this.getName()));
//		// System.out.println("Inside BaseBlock:registerItems: this.getFullName(): " + this.getFullName());
//		// System.out.println("Inside BaseBlock:registerItems: this.getRegistryName(): " + (this.getRegistryName() == null ? "null" : this.getRegistryName().toString()));
//
//		event.getRegistry().register(new ItemBlock(this).setRegistryName(this.getName()));
//	}

	
	@Override // from SuperDopeObject
	public void blockBreakEvent(BreakEvent e)
	{
		//System.out.println("Inside BaseBlock:blockBreakEvent");
		return;
	}
	
//
//	@Override
//	public void registerRecipe() {
//		return;
//	}
//
//
//	@Override
//	public void registerModel() {
//		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
//		String location = SuperDopeJediMod.MODID + ":" + ((BaseBlock) this).getName();
//	    renderItem.getItemModelMesher().register(Item.getItemFromBlock(this), 0, new ModelResourceLocation(location));
//	}
}
