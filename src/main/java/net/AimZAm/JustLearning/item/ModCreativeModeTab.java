package net.AimZAm.JustLearning.item;

import com.mojang.brigadier.LiteralMessage;
import net.AimZAm.JustLearning.LearningMod;
import net.AimZAm.JustLearning.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LearningMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NEODIUM_ITEMS_TAB = CREATIVE_MODE_TAB.register("neodium_items_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.NEODIUM.get())).
                    title(Component.translatable("creativetab.aimzammodding.neodium_items"))
                    .displayItems((itemDisplayParameters,output) -> {
                        output.accept(ModItems.NEODIUM.get());
                        output.accept(ModItems.INGOT_NEODIUM.get());
                        output.accept(ModBlocks.RAW_NEODIUM_BLOCK.get());
                        output.accept(ModBlocks.NEODIUM_BLOCK.get());

                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
