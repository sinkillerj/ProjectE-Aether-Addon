package com.sinkillerj.peaether;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.common.config.Configuration;

import net.minecraftforge.oredict.ShapedOreRecipe;

import net.aetherteam.aether.blocks.AetherBlocks;
import net.aetherteam.aether.items.AetherItems;
import moze_intel.projecte.gameObjs.ObjHandler;
import moze_intel.projecte.api.ProjectEAPI;

@Mod(modid="peaether", name="ProjectE Aether Addon", version="@VERSION@", dependencies="required-after:aether;"+"required-after:ProjectE;")
public class peaether
{

	public static CreativeTabs peaetherCTab = new CreativeTabs("peaetherCTab")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return peaether.alchemicalCoin;
		}
	};

	public static Item alchemicalCoin = new ItemAlchemicalCoin().setUnlocalizedName("alchemicalcoin").setCreativeTab(peaetherCTab);

	public static Block coinMill = new BlockCoinMill().setBlockName("coinmill").setHardness(1.5F).setResistance(10.0F).setCreativeTab(peaetherCTab);

	@Instance(value = "peaether")
	public static peaether instance;

	@SidedProxy(clientSide="com.sinkillerj.peaether.ClientProxy", serverSide="com.sinkillerj.peaether.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		PEAConfig.init(new Configuration(event.getSuggestedConfigurationFile()));

		ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(peaether.alchemicalCoin, 1), PEAConfig.alchemicalCoinEMC);

		if (PEAConfig.addAetherEMC)
		{
			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.GreenSkyrootSapling, 1), 32);
			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.BlueSkyrootSapling, 1), 32);
			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.DarkBlueSkyrootSapling, 1), 32);

			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.GreenSkyrootLeaves, 1, 1), 1);
			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.BlueSkyrootLeaves, 1, 1), 1);
			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.DarkBlueSkyrootLeaves, 1, 1), 1);

			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.WhiteRose, 1), 16);
			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.PurpleFlower, 1), 16);

			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.AetherDirt, 1), 1);
			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.AetherGrass, 1), 2);

			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.TallAetherGrass, 1), 1);

			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.AetherLog, 1, 0), 32);
			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.AetherLog, 1, 2), 32);

			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.Holystone, 1, 1), 1);
			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherBlocks.Holystone, 1, 3), 2);

			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherItems.AmbrosiumShard, 1), 14);

			ProjectEAPI.getEMCProxy().registerCustomEMC(new ItemStack(AetherItems.ZaniteGemstone, 1), 256);
		}


		GameRegistry.registerItem(alchemicalCoin, "alchemicalCoinItem");

		GameRegistry.registerBlock(coinMill, "coinMillBlock");

		GameRegistry.registerTileEntity(TileCoinMill.class, "coinMillTile");

		GameRegistry.addRecipe(new ShapedOreRecipe(coinMill, "x x", "zyz", "xxx", 'x', "ingotGold", 'y', new ItemStack(ObjHandler.covalence, 1, 0), 'z', "ingotIron"));

		GameRegistry.addRecipe(new ShapedOreRecipe(coinMill, "x x", "zyz", "xxx", 'x', "ingotGold", 'y', new ItemStack(ObjHandler.covalence, 1, 1), 'z', "ingotIron"));

		GameRegistry.addRecipe(new ShapedOreRecipe(coinMill, "x x", "zyz", "xxx", 'x', "ingotGold", 'y', new ItemStack(ObjHandler.covalence, 1, 2), 'z', "ingotIron"));

		if (PEAConfig.addPERecipes)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(ObjHandler.covalence, 40, 0), AetherBlocks.Holystone, AetherBlocks.Holystone, AetherBlocks.Holystone, AetherBlocks.Holystone, AetherBlocks.Holystone, AetherBlocks.Holystone, AetherBlocks.Holystone, AetherBlocks.Holystone, AetherItems.AmbrosiumShard);
		}

	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init();
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderers();
	}

}
