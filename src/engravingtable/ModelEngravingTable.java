package synergymod.engravingtable;

import net.minecraft.client.model.ModelBase;
//Exported java file
//Keep in mind that you still need to fill in some blanks
//- ZeuX
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEngravingTable extends ModelBase
{
  
  public ModelEngravingTable()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Tabletop = new ModelRenderer(this, 0, 12);
      Tabletop.addBox(0F, 0F, 0F, 16, 3, 17);
      Tabletop.setRotationPoint(-8F, 8F, -9F);
      Tabletop.setTextureSize(64, 32);
      Tabletop.mirror = true;
      setRotation(Tabletop, 0F, 0F, 0F);
      Leg = new ModelRenderer(this, 0, 0);
      Leg.addBox(0F, 0F, 0F, 3, 15, 3);
      Leg.setRotationPoint(4F, 9F, 4F);
      Leg.setTextureSize(64, 32);
      Leg.mirror = true;
      setRotation(Leg, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 0, 0);
      Leg1.addBox(0F, 0F, 0F, 3, 15, 3);
      Leg1.setRotationPoint(-7F, 9F, -7F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 0, 0);
      Leg2.addBox(0F, 0F, 0F, 3, 15, 3);
      Leg2.setRotationPoint(4F, 9F, -7F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 0, 0);
      Leg3.addBox(0F, 0F, 0F, 3, 15, 3);
      Leg3.setRotationPoint(-7F, 9F, 4F);
      Leg3.setTextureSize(64, 32);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Tabletop.render(f5);
    Leg.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

	
	
	//fields
	public ModelRenderer Tabletop;
	public ModelRenderer Leg;
	public ModelRenderer Leg1;
	public ModelRenderer Leg2;
	public ModelRenderer Leg3; 

public void renderAll() {
	Tabletop.render(0.0625F);
	Leg.render(0.0625F);
	Leg1.render(0.0625F);
	Leg2.render(0.0625F);
	Leg3.render(0.0625F);
}
}
