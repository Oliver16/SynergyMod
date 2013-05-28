package synergymod;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.common.MinecraftForge;
import synergymod.block.*;
import synergymod.engravingtable.EngravingTable;
import synergymod.engravingtable.TileEntityEngravingTable;
import synergymod.engravingtable.gui.GuiHandlerEngravingTable;
import synergymod.item.*;
import synergymod.runekiln.GuiHandler;
import synergymod.runekiln.RuneKiln;
import synergymod.runekiln.TileEntityRuneKiln;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "SynergyMod", name = "SynergyMod", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = "SynergyMod", packetHandler = SynergyModPacketHandler.class)
public class SynergyMod 
{
	@SidedProxy(clientSide = "synergymod.client.ClientProxy", serverSide = "synergymod.CommonProxy")
	public static CommonProxy proxy;
	
	
	@Instance
	public static SynergyMod instance = new SynergyMod();
	
	private GuiHandler guihandler = new GuiHandler();
	private GuiHandlerEngravingTable guihandlerengravingtable = new GuiHandlerEngravingTable();
	public static CreativeTabs tabSynergyMod = new SynergyModTab(CreativeTabs.getNextID(),"SynergyMod"); 
	
 
	
	public static Block SynergiteBlock;
	
	public static Block CobaltEssence;
	public static Block AlabasterEssence;
	public static Block ViridianEssence;
	public static Block IgneousEssence;
	
	public static Block RuneKilnIdle;
	public static Block RuneKilnActive;
	public static Block EngravingTable;
	
	
	public static final Item SynergiteDust = new SynergiteDust(5001).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("SynergiteDust");
	public static final Item CobaltRuneDust = new CobaltRuneDust(5002).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("CobaltRuneDust");
	public static final Item CobaltRune = new CobaltRune(5010).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("CobaltRune");
	public static final Item AlabasterRuneDust = new AlabasterRuneDust(5003).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("AlabasterRuneDust");
	public static final Item AlabasterRune = new AlabasterRune(5011).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("AlabasterRune");
	public static final Item ViridianRune = new ViridianRune(5012).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("ViridianRune");
	public static final Item ViridianRuneDust = new ViridianRuneDust(5004).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("ViridianRuneDust");
	public static final Item IgneousRuneDust = new IgneousRuneDust(5005).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("IgneousRuneDust");
	public static final Item IgneousRune = new IgneousRune(5013).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("IgneousRune");

 @Init
 public void load(FMLInitializationEvent event) 
 {
	 SynergiteBlock = new SynergiteBlock(500, 0) .setUnlocalizedName("SynergiteBlock") .setHardness(3) .setStepSound(Block.soundStoneFootstep);
	 CobaltEssence = new CobaltEssence(501, 0) .setUnlocalizedName("CobaltEssence") .setHardness(2) .setStepSound(Block.soundStoneFootstep);
	 AlabasterEssence = new AlabasterEssence(502, 0) .setUnlocalizedName("AlabasterEssence") .setHardness(2) .setStepSound(Block.soundStoneFootstep).setCreativeTab(this.tabSynergyMod);
	 ViridianEssence = new ViridianEssence(503, 0) .setUnlocalizedName("ViridianEssence") .setHardness(2) .setStepSound(Block.soundStoneFootstep).setCreativeTab(this.tabSynergyMod);
	 IgneousEssence = new IgneousEssence(504, 0) .setUnlocalizedName("IgneousEssence") .setHardness(2) .setStepSound(Block.soundStoneFootstep).setCreativeTab(this.tabSynergyMod);
	 RuneKilnActive = new RuneKiln(505, true) .setUnlocalizedName("RuneKilnActive") .setHardness(1) .setStepSound(Block.soundWoodFootstep) ;
	 RuneKilnIdle = new RuneKiln(506, false) .setUnlocalizedName("RuneKilnIdle") .setHardness(1) .setStepSound(Block.soundWoodFootstep) .setCreativeTab(CreativeTabs.tabBlock);
	 EngravingTable = new EngravingTable(507, 0) .setUnlocalizedName("EngravingTable").setCreativeTab(this.tabSynergyMod);
	 GameRegistry.registerBlock(SynergiteBlock);
	 GameRegistry.registerBlock(CobaltEssence);
	 GameRegistry.registerBlock(AlabasterEssence);
	 GameRegistry.registerBlock(ViridianEssence);
	 GameRegistry.registerBlock(IgneousEssence);
	 GameRegistry.registerBlock(RuneKilnIdle);
	 GameRegistry.registerBlock(RuneKilnActive);
	 GameRegistry.registerTileEntity(TileEntityRuneKiln.class, "tileentityrunekiln");
	 GameRegistry.registerTileEntity(TileEntityEngravingTable.class, "tileentityengravingtable");
	 NetworkRegistry.instance().registerGuiHandler(this, guihandler);
	 NetworkRegistry.instance().registerGuiHandler(this, guihandlerengravingtable);
	 MinecraftForge.setBlockHarvestLevel(SynergiteBlock, "pickaxe", 3);
	 MinecraftForge.setBlockHarvestLevel(CobaltEssence, "pickaxe", 3);
	 MinecraftForge.setBlockHarvestLevel(AlabasterEssence, "pickaxe", 3);
	 MinecraftForge.setBlockHarvestLevel(ViridianEssence, "pickaxe", 3);
	 MinecraftForge.setBlockHarvestLevel(IgneousEssence, "pickaxe", 3);
	 LanguageRegistry.addName(RuneKilnIdle, "Rune Kiln");
	 LanguageRegistry.addName(RuneKilnActive, "Rune Kiln");
	 LanguageRegistry.addName(CobaltEssence, "Cobalt Essence");
	 LanguageRegistry.addName(AlabasterEssence, "Alabaster Essence");
	 LanguageRegistry.addName(ViridianEssence, "Viridian Essence");
	 LanguageRegistry.addName(IgneousEssence, "Igneous Essence");
	 LanguageRegistry.addName(SynergiteBlock, "Synergite Block");
	 LanguageRegistry.addName(SynergiteDust, "Synergite Dust");
	 LanguageRegistry.addName(CobaltRuneDust, "Cobaltic Rune Dust");
	 LanguageRegistry.addName(AlabasterRuneDust, "Alabastic Rune Dust");
	 LanguageRegistry.addName(ViridianRuneDust, "Viridic Rune Dust");
	 LanguageRegistry.addName(IgneousRuneDust, "Ignitic Rune Dust");
	 LanguageRegistry.addName(CobaltRune, "Cobalt Rune");
	 LanguageRegistry.addName(AlabasterRune, "Alabaster Rune");
	 LanguageRegistry.addName(ViridianRune, "Viridian Rune");
	 LanguageRegistry.addName(IgneousRune, "Igneous Rune");
	 LanguageRegistry.addName(EngravingTable, "Engraving Table");
	 GameRegistry.registerBlock(EngravingTable);

	 ItemStack brickStack = new ItemStack(Block.brick);
	 ItemStack stonebrickStack = new ItemStack(Block.stoneBrick);
	 ItemStack stoneStack = new ItemStack(Block.stone);
	 ItemStack synergiteDust = new ItemStack(SynergyMod.SynergiteDust);
	 CobaltEssence.setCreativeTab(this.tabSynergyMod);
	 SynergiteBlock.setCreativeTab(this.tabSynergyMod);
	 RuneKilnIdle.setCreativeTab(this.tabSynergyMod);
	 CobaltRuneDust.setCreativeTab(this.tabSynergyMod);
	 SynergiteDust.setCreativeTab(this.tabSynergyMod);
	 AlabasterRuneDust.setCreativeTab(this.tabSynergyMod);
	 ViridianEssence.setCreativeTab(this.tabSynergyMod);
	 ViridianRuneDust.setCreativeTab(this.tabSynergyMod);
	 IgneousEssence.setCreativeTab(this.tabSynergyMod);
	 IgneousRuneDust.setCreativeTab(this.tabSynergyMod);
	 CobaltRune.setCreativeTab(this.tabSynergyMod);
	 AlabasterRune.setCreativeTab(this.tabSynergyMod);
	 ViridianRune.setCreativeTab(this.tabSynergyMod);
	 IgneousRune.setCreativeTab(this.tabSynergyMod);
	 LanguageRegistry.instance().addStringLocalization("SynergyMod","Synergy Mod");
	 

	 GameRegistry.addRecipe(new ItemStack(SynergyMod.RuneKilnIdle), "xxx", "x x", "yyy", 
	         'x', brickStack, 'y', stonebrickStack);
	 GameRegistry.addRecipe(new ItemStack(SynergyMod.EngravingTable), "xxx", "yyy", "y y", 'x', synergiteDust, 'y', stoneStack);
	 GameRegistry.registerWorldGenerator(new ModifiedWorldGen());

	 proxy.registerRenderThings();

 }
 public void registerIcons(IconRegister iconRegister)
 {
          Icon SynergiteBlockIcon = iconRegister.registerIcon("SynergyMod:SynergiteBlock.png");
          Icon CobaltEssenceIcon = iconRegister.registerIcon("SynergyMod:CobaltEssence.png");
          Icon SynergiteDustIcon = iconRegister.registerIcon("SynergyMod:SynergiteDust.png");
          Icon CobaltRuneDustIcon = iconRegister.registerIcon("SynergyMod:CobaltRuneDust.png");
          Icon CobaltRuneIcon = iconRegister.registerIcon("SynergyMod:CobaltRune.png");
          Icon AlabasterEssenceIcon = iconRegister.registerIcon("SynergyMod:AlabasterEssence.png");
          Icon AlabasterRuneDustIcon = iconRegister.registerIcon("SynergyMod:AlabasterRuneDust.png");
          Icon AlabasterRune = iconRegister.registerIcon("SynergyMod:AlabasterRune.png");
          Icon ViridianEssence = iconRegister.registerIcon("SynergyMod:ViridianEssence.png");
          Icon ViridianRuneDust = iconRegister.registerIcon("SynergyMod:ViridianRuneDust.png");
          Icon ViridianRune = iconRegister.registerIcon("SynergyMod:ViridianRune.png");
          Icon IgneousEssence = iconRegister.registerIcon("SynergyMod:IgneousEssence.png");
          Icon IgneousRuneDust = iconRegister.registerIcon("SynergyMod:IgneousRuneDust.png");
          Icon IgneousRune = iconRegister.registerIcon("SynergyMod:IgneousRune.png");
 }
}
 

