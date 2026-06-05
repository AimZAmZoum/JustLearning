package net.AimZAm.JustLearning.item;

import net.AimZAm.JustLearning.AimzamModding;
import net.AimZAm.JustLearning.item.custom.ChiselItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    //DeferredRegister sert a ce que la liste d'items soient enregistré en temps voulu
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AimzamModding.MOD_ID);

    //ici on enregistre notre ITEM en istanciant un nouvel item
    public static final RegistryObject<Item> NEODIUM = ITEMS.register("neodium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INGOT_NEODIUM = ITEMS.register("ingot_neodium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NEODIUM_CHISEL = ITEMS.register("neodium_chisel",
            () -> new ChiselItem(new Item.Properties().durability(3500)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
