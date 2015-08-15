package com.sinkillerj.peaether;

import com.sinkillerj.peaether.CommonProxy;
import cpw.mods.fml.client.registry.ClientRegistry;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{

	@Override
	public void init()
	{

	}

	@Override
	public void registerRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileCoinMill.class, new TESRCoinMill());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(peaether.coinMill), new ItemRenderCoinMill());
	}

}
