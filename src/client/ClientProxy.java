package synergymod.client;

import net.minecraftforge.client.MinecraftForgeClient;
import synergymod.CommonProxy;
import synergymod.SynergyMod;
import synergymod.engravingtable.ItemEngravingTableRenderer;
import synergymod.engravingtable.TileEntityEngravingTable;
import synergymod.engravingtable.TileEntityEngravingTableRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;


public class ClientProxy extends CommonProxy
{
 @Override
    public void registerRenderThings()
    {
	 ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEngravingTable.class, new TileEntityEngravingTableRenderer());
	 MinecraftForgeClient.registerItemRenderer(SynergyMod.EngravingTable.blockID, new ItemEngravingTableRenderer());

    }
}