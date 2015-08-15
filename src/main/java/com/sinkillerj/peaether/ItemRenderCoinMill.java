package com.sinkillerj.peaether;

import net.minecraft.client.renderer.tileentity.TileEntityRendererChestHelper;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.client.FMLClientHandler;

public class ItemRenderCoinMill implements IItemRenderer
{

	private static final ResourceLocation texture = new ResourceLocation("peaether:models/coinmill.png");

	private CoinMillModel coinMillModel = new CoinMillModel();

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch(type)
		{
			case ENTITY:
			{
				//GL11.glRotatef(90, 0, 0, 1);
				renderCondensor(0.0F, 0.0F, 0.0F);
				return;
			}
			case EQUIPPED:
			{
				//GL11.glRotated(180, 0, 1, 0);
				//GL11.glTranslatef(0.5F, 0.0F, 0.0F);
				renderCondensor(0.5F, 0.0F, 0.5F);
				return;
			}
			case EQUIPPED_FIRST_PERSON:
			{
				//GL11.glRotated(180, 0, 1, 0);
				renderCondensor(0.5F, 0.0F, 0.5F);
				return;
			}
			case INVENTORY:
			{
				renderCondensor(-0.01F, -0.5F, 0.0F);
				return;
			}
			default:
				return;
	}

}

	private void renderCondensor(float x, float y, float z)
	{
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.texture);
		GL11.glPushMatrix(); // start
		GL11.glScalef(1.0F, 1F, 1.1F);
		GL11.glTranslatef(x, y, z); // size
		//GL11.glRotatef(180, 1, 0, 0);
		GL11.glRotatef(-90, 0, 1, 0);
		coinMillModel.render();
		GL11.glPopMatrix(); // end
	}
}
