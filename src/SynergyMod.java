package synergymod;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "SynergyMod", name = "SynergyMod", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class SynergyMod 
{
	@SidedProxy(clientSide = "synergymod.client.ClientProxy", serverSide = "synergymod.CommonProxy")
	public static CommonProxy proxy;
	
	public static Block SynergiteBlock;
	
	public static Block CobaltEssence;
	
	
	public static final Item SynergiteDust = new SynergiteDust(5001).setMaxStackSize(16).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("SynergiteDust");
	

 @Init
 public void load(FMLInitializationEvent event) 
 {
	 SynergiteBlock = new SynergiteBlock(250, 0) .setUnlocalizedName("SynergiteBlock") .setHardness(3) .setStepSound(Block.soundStoneFootstep);
	 CobaltEssence = new CobaltEssence(251, 0) .setUnlocalizedName("CobaltEssence") .setHardness(2) .setStepSound(Block.soundStoneFootstep);
	 GameRegistry.registerBlock(SynergiteBlock);
	 GameRegistry.registerBlock(CobaltEssence);
	 MinecraftForge.setBlockHarvestLevel(SynergiteBlock, "pickaxe", 3);
	 MinecraftForge.setBlockHarvestLevel(CobaltEssence, "pickaxe", 2);
	 LanguageRegistry.addName(CobaltEssence, "Cobalt Essence");
	 LanguageRegistry.addName(SynergiteBlock, "Synergite Block");
	 LanguageRegistry.addName(SynergiteDust, "Synergite Dust");
	 GameRegistry.registerWorldGenerator(new ModifiedWorldGen());

	 proxy.registerRenderThings();

 }
 public void registerIcons(IconRegister iconRegister)
 {
          Icon SynergiteBlockIcon = iconRegister.registerIcon("SynergyMod:SynergiteBlock.png");
          Icon CobaltEssenceIcon = iconRegister.registerIcon("SynergyMod:CobaltEssence.png");
          Icon SynergiteDustIcon = iconRegister.registerIcon("SynergyMod:SynergiteDust.png");
 }
}
 

