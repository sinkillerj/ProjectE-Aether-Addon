package com.sinkillerj.peaether;

import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.StatCollector;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

public class ItemAlchemicalCoin extends Item
{
	public ItemAlchemicalCoin()
	{
		maxStackSize = 64;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon("peaether:alchemicalcoin");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		list.add(StatCollector.translateToLocal("peaether.alchemicalcoin.tooltip1"));
		list.add(StatCollector.translateToLocal("peaether.alchemicalcoin.tooltip2"));
		list.add(StatCollector.translateToLocal("peaether.alchemicalcoin.tooltip3"));
	}

}
