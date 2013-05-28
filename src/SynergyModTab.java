package synergymod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;

public class SynergyModTab extends CreativeTabs {
public SynergyModTab(int position, String tabID) {
super(position, tabID);
}
@SideOnly(Side.CLIENT)
public int getTabIconItemIndex()
{
return SynergyMod.EngravingTable.blockID; //this is the item that is displayed on your tab's icon
}
public String getTranslatedTabLabel()
{
return "Runic Synergy Mod"; //the name that shows up in-game
}
}