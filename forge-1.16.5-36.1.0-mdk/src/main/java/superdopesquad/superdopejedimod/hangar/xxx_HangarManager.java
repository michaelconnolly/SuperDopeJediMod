//package superdopesquad.superdopejedimod.hangar;
//
//
//import net.minecraft.block.Block;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import superdopesquad.superdopejedimod.SuperDopeJediMod;
//import superdopesquad.superdopejedimod.entity.EntityManager;
//
//
//public class HangarManager {
//
//	public static int HANGARPAD_DEFAULT_WIDTH = 15;
//	public static int HANGARPAD_EMPIRE_WIDTH = 13;
//	public static int HANGARPAD_REPUBLIC_WIDTH = 17;
//
//	public static xxx_HangarParts hangarParts = new xxx_HangarParts("hangarParts");
//	public static HangarWrench hangarWrench = new HangarWrench("hangarWrench");
//
//	public static HangarPadBlock hangarPadBlock = new HangarPadBlock("hangarPadBlock");
//	public static HangarPadBlock imperialHangarPadBlock = new HangarPadBlock("imperialHangarPadBlock",
//			SuperDopeJediMod.classManager.getImperialFactions());
//	public static HangarPadBlock republicHangarPadBlock = new HangarPadBlock("republicHangarPadBlock",
//			SuperDopeJediMod.classManager.getRepublicFactions());
//
//	public static HangarPadKit hangarPadKit = new HangarPadKit("hangarPadKit", HangarManager.hangarPadBlock,
//			HangarManager.hangarParts);
//	public static HangarPadKit imperialHangarPadKit = new HangarPadKit("imperialHangarPadKit",
//			HangarManager.imperialHangarPadBlock, Items.BONE, SuperDopeJediMod.classManager.getImperialFactions(),
//			HangarManager.HANGARPAD_EMPIRE_WIDTH);
//	public static HangarPadKit republicHangarPadKit = new HangarPadKit("republicHangarPadKit",
//			HangarManager.republicHangarPadBlock, Items.FEATHER, SuperDopeJediMod.classManager.getRepublicFactions(),
//			HangarManager.HANGARPAD_REPUBLIC_WIDTH);
//
//	public static ShipKit testShipKit = new ShipKit("testShipKit", EntityChicken.class, null);
//	public static ShipKit shuttleKit = new ShipKit("shuttleKit", ShuttleEntity.class, Items.COAL);
//	public static ShipKit tieFighterKit = new ShipKit("tieFighterKit", TieFighterEntity.class, Items.FLINT, SuperDopeJediMod.classManager.getImperialFactions());
//	public static ShipKit xWingFighterKit = new ShipKit("xWingFighterKit", XWingFighterEntity.class, Items.WHEAT, SuperDopeJediMod.classManager.getRepublicFactions());
//	public static ShipKit imperialShuttleKit = new ShipKit("imperialShuttleKit", ImperialShuttleEntity.class, Items.APPLE, SuperDopeJediMod.classManager.getImperialFactions());
//
//
//	public HangarManager() {}
//
//
//	public static boolean createShip(EntityPlayer player, World world, BlockPos blockPos, EnumFacing facing) { //, ShipKit shipKit) {
//
//		boolean isWorldServer = (!world.isRemote);
//		IBlockState blockStateClicked = world.getBlockState(blockPos);
//    	Block blockClicked = blockStateClicked.getBlock();
//    	boolean isShipKit = (blockClicked instanceof ShipKit);
//
//    	BlockPos blockPosShouldBeHangarPad = blockPos.offset(EnumFacing.DOWN);
//    	IBlockState blockStateShouldBeHangarPad = world.getBlockState(blockPosShouldBeHangarPad);
//    	Block blockShouldBeHangarPad = blockStateShouldBeHangarPad.getBlock();
//    	boolean onValidHangarPad = (blockShouldBeHangarPad instanceof HangarPadBlock);
//
//    	// If we are on the server, and we are being held in the main hand, and this is actually a shipkit , ...
//    	if ((isWorldServer) && (isShipKit)) {
//
//    		// Bail if we are not on a valid hangar pad.
//    		if (!(onValidHangarPad)) {
//    			player.sendMessage(new TextComponentString("Put a ship kit on top of a valid hangar pad to create the desired ship."));
//    			return false;
//    		}
//
//    		// Interesting information we need to do a couple more checks.
//     		ShipKit shipKit = (ShipKit) blockClicked;
//    		HangarPadBlock hangarPadBlock = (HangarPadBlock) blockShouldBeHangarPad;
//    		boolean canUseShipKit = SuperDopeJediMod.classManager.canPlayerUse(player, shipKit);
//
//    		// Is the player allowed to use this ship kit?
//    		if (!canUseShipKit) {
//       			player.sendMessage(new TextComponentString("You can't build this ship, due to your faction allegiance."));
//    			return false;
//    		}
//
//    		// MC-TODO: make sure the ship kit is on top of a valid faction-affiliated hangar.
//    		if (!(hangarPadBlock.CanBuildThisShipKit(shipKit))) {
//      			player.sendMessage(new TextComponentString("You can't build this ship on this particular hangar, due to faction issues."));
//    			return false;
//    		}
//
//    		// Destroy the existing block.
//    		world.setBlockToAir(blockPos);
//
//    		// Create the new entity.
//    		Class classToMake = ((ShipKit) blockClicked).getEntityToMake();
//    		EntityLiving entity = (EntityLiving) EntityManager.createEntity(classToMake, world, blockPos);
//
//    		return true;
//    	}
//
//		return false;
//	}
//
//
//	public static boolean createHangerPad(EntityPlayer player, World world, BlockPos blockPos, EnumFacing facing, HangarPadKit hangarPadKit) {
//
//		// What is the perfect sized rectangle we want want to create?
//		int diameter = hangarPadKit.getHangarDiameter();
//		int radius = (hangarPadKit.getHangarDiameter() - 1) / 2;
//		HangarPadBlock hangarPadBlock = hangarPadKit.getHangarPadBlock();
//
//		BlockPos northWestCorner = blockPos.north(-radius).west(-radius);
//		IBlockState blockStateHangarPadBlock = hangarPadBlock.getDefaultState();
//
//		// Faction check.
//		boolean canBuildHangar = SuperDopeJediMod.classManager.canPlayerUse(player, hangarPadKit);
//		if (!canBuildHangar) {
//   			player.sendMessage(new TextComponentString("You can't build this hangar, due to your faction allegiance."));
//			return false;
//		}
//
//		// Can we legally put one here?
//		if (GeometryUtil.checkIfPlaneWouldBeDestructive(world, northWestCorner, diameter,
//					diameter, EnumFacing.WEST, EnumFacing.NORTH, blockStateHangarPadBlock, blockPos)) {
//
//			player.sendMessage(new TextComponentString("Not enough space to build a Hanger Pad here."));
//			return false;
//		}
//
//		// Let's do this.
//		GeometryUtil.buildPlaneDestructive(world, northWestCorner, diameter,
//				diameter, EnumFacing.WEST, EnumFacing.NORTH, blockStateHangarPadBlock);
//
//		// MC-TODO: using a variant blockstate, make the edges look different.
////		IBlockState blockStateHangarPadBlockEdge = SuperDopeJediMod.hangarManager.hangarPadBlock.
////		world.setBlockState(blockPos, state)
////		IBlockState blockStateHangarPadBlockEdge = SuperDopeJediMod.hangarManager.hangarPadBlock.
////
//		return true;
//	}
//}
