package com.sinkillerj.peaether;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class CoinMillModel extends ModelBase
{
	private IModelCustom coinMillModel;

	private static final ResourceLocation texture = new ResourceLocation("peaether:models/coinmill.png");
	
	public CoinMillModel()
	{
		coinMillModel = AdvancedModelLoader.loadModel(new ResourceLocation("peaether:models/coinmill.obj"));
	}
	
	public void render()
	{
		coinMillModel.renderAll();
	}
	
	public void render(TileCoinMill tile, double x, double y, double z)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5f, (float)y + 0.0f, (float)z + 0.5f);
		GL11.glScalef(1.0f, 1.0f, 1.0f);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.texture);
		this.render();
		GL11.glPopMatrix();
	}
}
