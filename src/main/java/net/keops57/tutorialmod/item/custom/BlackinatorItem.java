package net.keops57.tutorialmod.item.custom;
//Presionar ctrl + h en Item nos deja ver todos los items de Mc, asi podemos experimentar
import net.keops57.tutorialmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PotionItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

public class BlackinatorItem extends Item {

    public BlackinatorItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient()){
            BlockPos playerPos = user.getBlockPos();
            healtDeleter(user,world,playerPos);
        }
        return super.use(world, user, hand);
    }

    private void healtDeleter(PlayerEntity player,World world,BlockPos playerPos){
        StatusEffectInstance hungerEffect = new StatusEffectInstance(StatusEffects.HUNGER, 600, 250);
        StatusEffectInstance slownessEffect = new StatusEffectInstance(StatusEffects.SLOWNESS, 600, 100);

        player.sendMessage(Text.literal("Ahora estas en: " + world.getDifficulty()),true);
        player.setHealth(1.0f);
        player.addStatusEffect(hungerEffect);
        player.addStatusEffect(slownessEffect);

        CreeperEntity creeper = EntityType.CREEPER.create(world);
        creeper.refreshPositionAndAngles(playerPos, 0.0F, 0.0F);
        world.spawnEntity(creeper);
    }
}
