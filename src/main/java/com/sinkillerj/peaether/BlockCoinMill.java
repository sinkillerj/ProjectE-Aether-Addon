package com.sinkillerj.peaether;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.block.ITileEntityProvider;

import net.minecraft.world.IBlockAccess;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.EntityItem;

import net.minecraft.util.ChatComponentText;

import net.aetherteam.aether.player.PlayerAether;

public class BlockCoinMill extends Block implements ITileEntityProvider
{

	public BlockCoinMill()
	{
		super(Material.iron);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("gold_block");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData)
	{
		return new TileCoinMill(); 
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			PlayerAether playerAether = PlayerAether.get(player);

			if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemAlchemicalCoin)
			{
				if (!player.capabilities.isCreativeMode)
				{
					player.getHeldItem().stackSize--;
				}
				playerAether.setAetherCoins(playerAether.getAetherCoins() + PEAConfig.aetherCoinTotal);
				world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "aether:aemisc.coin", 1.0F, 1.0F);
			}
			else
			{
				if (playerAether.getAetherCoins() >= PEAConfig.aetherCoinTotal)
				{
					EntityItem coinDropEntity = new EntityItem(world, x, y + 1.5D, z, new ItemStack(peaether.alchemicalCoin, 1));
					world.spawnEntityInWorld(coinDropEntity);
					playerAether.setAetherCoins(playerAether.getAetherCoins() - PEAConfig.aetherCoinTotal);
					world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "aether:aemisc.coin", 1.0F, 1.0F);
				}
				else
				{
					player.addChatComponentMessage(new ChatComponentText(PEAConfig.aetherCoinTotal + " Aether Coins are required to create a Alchemical Coin. You currently have " + playerAether.getAetherCoins() + "."));
				}
			}
		}

		return true;
	}

}
