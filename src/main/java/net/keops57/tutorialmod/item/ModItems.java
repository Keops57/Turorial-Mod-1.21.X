package net.keops57.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.keops57.tutorialmod.TutorialMod;
import net.keops57.tutorialmod.item.custom.BlackinatorItem;
import net.keops57.tutorialmod.item.custom.ChiselItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;



public class ModItems {
    public static final Item ACE_OF_SPADES =registerItem("ace_of_spades", new Item(new Item.Settings()));
    public static final Item SUS =registerItem("sus", new Item(new Item.Settings()));
    public static final Item RAW_JOAQUINITE =registerItem("raw_joaquinite", new Item(new Item.Settings()));
    public static final Item JOAQUINITE =registerItem("joaquinite", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32).maxCount(1)));
    public static final Item BLACKINATOR = registerItem("blackinator", new BlackinatorItem(new Item.Settings().maxDamage(64).maxCount(1)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registrando items para el mod" + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_JOAQUINITE);
            entries.add(JOAQUINITE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(SUS);
        });
    }
}
