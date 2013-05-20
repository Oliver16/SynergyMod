package synergymod;

import synergymod.block.CobaltEssence;
import synergymod.block.SynergiteBlock;
import synergymod.item.CobaltRune;
import synergymod.item.CobaltRuneDust;
import synergymod.item.SynergiteDust;
import synergymod.runekiln.GuiHandler;
import synergymod.runekiln.RuneKiln;
import synergymod.runekiln.TileEntityRuneKiln;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.common.MinecraftForge;
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
	
	public static Block SynergiteBlock;
	
	public static Block CobaltEssence;
	
	public static Block RuneKilnIdle;
	public static Block RuneKilnActive;
	
	
	public static final Item SynergiteDust = new SynergiteDust(5001).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("SynergiteDust");
	public static final Item CobaltRuneDust = new CobaltRuneDust(5002).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("CobaltRuneDust");
	public static final Item CobaltRune = new CobaltRune(5003).setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("CobaltRune");
 @Init
 public void load(FMLInitializationEvent event) 
 {
	 SynergiteBlock = new SynergiteBlock(250, 0) .setUnlocalizedName("SynergiteBlock") .setHardness(3) .setStepSound(Block.soundStoneFootstep);
	 CobaltEssence = new CobaltEssence(251, 0) .setUnlocalizedName("CobaltEssence") .setHardness(2) .setStepSound(Block.soundStoneFootstep);
	 RuneKilnActive = new RuneKiln(252, true) .setUnlocalizedName("RuneKilnActive") .setHardness(1) .setStepSound(Block.soundWoodFootstep) ;
	 RuneKilnIdle = new RuneKiln(253, false) .setUnlocalizedName("RuneKilnIdle") .setHardness(1) .setStepSound(Block.soundWoodFootstep) .setCreativeTab(CreativeTabs.tabBlock);
	 GameRegistry.registerBlock(SynergiteBlock);
	 GameRegistry.registerBlock(CobaltEssence);
	 GameRegistry.registerBlock(RuneKilnIdle);
	 GameRegistry.registerBlock(RuneKilnActive);
	 GameRegistry.registerTileEntity(TileEntityRuneKiln.class, "tileentityrunekiln");
	 NetworkRegistry.instance().registerGuiHandler(this, guihandler);
	 MinecraftForge.setBlockHarvestLevel(SynergiteBlock, "pickaxe", 3);
	 MinecraftForge.setBlockHarvestLevel(CobaltEssence, "pickaxe", 2);
	 LanguageRegistry.addName(RuneKilnIdle, "Rune Kiln");
	 LanguageRegistry.addName(RuneKilnActive, "Rune Kiln");
	 LanguageRegistry.addName(CobaltEssence, "Cobalt Essence");
	 LanguageRegistry.addName(SynergiteBlock, "Synergite Block");
	 LanguageRegistry.addName(SynergiteDust, "Synergite Dust");
	 LanguageRegistry.addName(CobaltRuneDust, "Cobaltic Rune Dust");
	 LanguageRegistry.addName(CobaltRune, "Cobalt Rune");
	 ItemStack brickStack = new ItemStack(Block.brick);
	 ItemStack stonebrickStack = new ItemStack(Block.stoneBrick);

	 GameRegistry.addRecipe(new ItemStack(SynergyMod.RuneKilnIdle), "xxx", "x x", "yyy", 
	         'x', brickStack, 'y', stonebrickStack);
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
 }
}
 

