package synergymod.block;

import java.util.Random;

import synergymod.SynergyMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;


public class AlabasterEssence extends Block
{
 public AlabasterEssence(int id, int texture)
 {
  super(id, Material.rock);
  this.setCreativeTab(CreativeTabs.tabBlock);
  
  
}
 public int idDropped(int par1, Random random, int zero) {
     return SynergyMod.AlabasterRuneDust.itemID;
}
 public int quantityDropped(Random random)
 {
	 return 4;
 }
 
}
