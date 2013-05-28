package synergymod.engravingtable;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemEngravingTableRenderer implements IItemRenderer {

private ModelEngravingTable EngravingTableModel;

public ItemEngravingTableRenderer() {

EngravingTableModel = new ModelEngravingTable();
}

@Override
public boolean handleRenderType(ItemStack item, ItemRenderType type) {

return true;
}

@Override
public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

return true;
}

@Override
public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
TileEntityRenderer.instance.renderTileEntityAt(new TileEntityEngravingTable(), -0.45D, -0.55D, -0.5D, 0.0F);
}
}