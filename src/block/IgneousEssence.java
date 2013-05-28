package synergymod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import synergymod.SynergyMod;


public class IgneousEssence extends Block
{
 public IgneousEssence(int id, int texture)
 {
  super(id, Material.rock);
  this.setCreativeTab(CreativeTabs.tabBlock);
  
  
}
 public int idDropped(int par1, Random random, int zero) {
     return SynergyMod.IgneousRuneDust.itemID;
}
 public int quantityDropped(Random random)
 {
	 return 4;
 }
 
}