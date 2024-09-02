package net.keops57.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.keops57.tutorialmod.TutorialMod;
import net.keops57.tutorialmod.block.custom.MagicBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block SUS_BLOCK =registerBlock("sus_block",
            new Block(AbstractBlock.Settings.create().strength(8.0F, 12.0F)
                    .requiresTool().sounds(BlockSoundGroup.CHAIN).luminance(state -> 15 )));

    public static final Block CASINO_CARPET_BLOCK =registerBlock("casino_carpet_block",
            new Block(AbstractBlock.Settings.create().strength(0.3F, 1.0F)
                    .sounds(BlockSoundGroup.WOOL)));

    public static final Block JOAQUINITE_BLOCK =registerBlock("joaquinite_block",
            new Block(AbstractBlock.Settings.create().strength(2.0F, 1.0F)
                    .requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE)));

    public static final Block JOAQUINITE_ORE =registerBlock("joaquinite_ore",
            new Block(AbstractBlock.Settings.create().strength(1.5F, 1.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block DEEPSLATE_JOAQUINITE_ORE =registerBlock("deepslate_joaquinite_ore",
            new Block(AbstractBlock.Settings.create().strength(3.0F, 1.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK =registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1.0F, 1.0F)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registrando bloques para el mod" + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(SUS_BLOCK);
            entries.add(CASINO_CARPET_BLOCK);
            entries.add(JOAQUINITE_ORE);
            entries.add(DEEPSLATE_JOAQUINITE_ORE);
            entries.add(JOAQUINITE_BLOCK);
        });
    }
}
