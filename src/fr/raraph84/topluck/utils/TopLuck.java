package fr.raraph84.topluck.utils;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;

public class TopLuck {

	private static HashMap<UUID, TopLuck> toplucks = new HashMap<>();

	private int minedBlocks = 0;
	private HashMap<Material, Integer> blocks = new HashMap<>();

	public TopLuck(UUID playerUuid) {

		toplucks.put(playerUuid, this);
	}

	public void addBlock(Material block) {

		minedBlocks++;

		if (block == Material.IRON_ORE || block == Material.GOLD_ORE || block == Material.DIAMOND_ORE) {

			blocks.put(block, blocks.containsKey(block) ? blocks.get(block) + 1 : 1);
		}
	}

	public float getPercentage(Material block) {

		if (minedBlocks < 1 || !blocks.containsKey(block))
			return 0;

		float percentage = (float) blocks.get(block) / minedBlocks * 100;

		return (float) Math.round(percentage * 100) / 100;
	}

	public static HashMap<UUID, TopLuck> getToplucks() {
		return toplucks;
	}
}
