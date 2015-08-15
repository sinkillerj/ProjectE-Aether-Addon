package com.sinkillerj.peaether;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public final class PEAConfig 
{

	public static int aetherCoinTotal;

	public static int alchemicalCoinEMC;
	
	public static void init(Configuration config)
	{
		try
		{
			config.load();

			aetherCoinTotal = config.getInt("aetherCoinTotal", "general", 100, 1, Integer.MAX_VALUE, "How many Aether Coins equal one Alchemical Coin.");

			alchemicalCoinEMC = config.getInt("alchemicalCoinEMC", "general", 100, 1, Integer.MAX_VALUE, "The default EMC value of the Alchemical Coin.");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (config.hasChanged())
			{
				config.save();
			}
		}
	}
}
