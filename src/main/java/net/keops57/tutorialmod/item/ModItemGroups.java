package net.keops57.tutorialmod.item;

import net.keops57.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.keops57.tutorialmod.TutorialMod;
import net.keops57.tutorialmod.block.custom.MagicBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CASINO_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "casino_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ACE_OF_SPADES))
                    .displayName(Text.translatable("itemgroup.tutorialmod.casino_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ACE_OF_SPADES);
                        entries.add(ModItems.SUS);
                        
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.BLACKINATOR);
                    }).build());

    public static final ItemGroup CASINO_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "casino_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.CASINO_CARPET_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.casino_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CASINO_CARPET_BLOCK);
                        entries.add(ModBlocks.SUS_BLOCK);
                    }).build());
    public static final ItemGroup JOAQUINITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "joaquinite"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.JOAQUINITE))
                    .displayName(Text.translatable("itemgroup.tutorialmod.joaquinite"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.JOAQUINITE);
                        entries.add(ModItems.RAW_JOAQUINITE);
                        entries.add(ModBlocks.JOAQUINITE_BLOCK);
                        entries.add(ModBlocks.JOAQUINITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_JOAQUINITE_ORE);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                    }).build());




    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registrando grupos de items para el mod" + TutorialMod.MOD_ID);
    }
}
