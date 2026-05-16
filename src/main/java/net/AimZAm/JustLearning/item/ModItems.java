package net.AimZAm.JustLearning.item;

import net.AimZAm.JustLearning.LearningMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    //DeferredRegister sert a ce que la liste d'items soient enregistré en temps voulu
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LearningMod.MOD_ID);

    //ici on enregistre notre ITEM en istanciant un nouvel item
    public static final RegistryObject<Item> NEODIUM = ITEMS.register("neodium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INGOT_NEODIUM = ITEMS.register("ingot_neodium",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
