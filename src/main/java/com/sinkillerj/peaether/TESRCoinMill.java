package com.sinkillerj.peaether;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TESRCoinMill extends TileEntitySpecialRenderer
{

	private CoinMillModel coinMillModel = new CoinMillModel();

	public TESRCoinMill()
	{

	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float tick)
	{
		coinMillModel.render((TileCoinMill)tile, x, y, z);
	}

}
