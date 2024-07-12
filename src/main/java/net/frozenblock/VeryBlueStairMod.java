package net.frozenblock;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VeryBlueStairMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("very_blue_stair_mod");
	public static final Block VERY_BLUE_STAIR = new StairsBlock(
			Blocks.AIR.getDefaultState(),
			Block.Settings.create()
					.strength(2.0F, 6.0F)
					.mapColor(MapColor.BLUE)
	);
	public static final RegistryKey<ItemGroup> VERY_BLUE_STAIR_MOD_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of("very_blue_stair_mod", "item_group"));
	public static final ItemGroup VERY_BLUE_STAIR_MOD_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(VERY_BLUE_STAIR))
			.displayName(Text.translatable("itemGroup.very_blue_stair_mod"))
			.build();
	@Override
	public void onInitialize() {
		Registry.register(
				Registries.BLOCK,
				Identifier.of("very_blue_stair_mod", "very_blue_stair"),
				VERY_BLUE_STAIR
		);
		Registry.register(
				Registries.ITEM,
				Identifier.of("very_blue_stair_mod","very_blue_stair"),
				new BlockItem(VERY_BLUE_STAIR, new Item.Settings())
		);
		Registry.register(Registries.ITEM_GROUP, VERY_BLUE_STAIR_MOD_GROUP_KEY, VERY_BLUE_STAIR_MOD_GROUP);
		ItemGroupEvents.modifyEntriesEvent(VERY_BLUE_STAIR_MOD_GROUP_KEY).register(itemGroup -> {
			itemGroup.add(VERY_BLUE_STAIR);
		});
		LOGGER.info("Very Blue Stair Mod Loaded!");
	}
}