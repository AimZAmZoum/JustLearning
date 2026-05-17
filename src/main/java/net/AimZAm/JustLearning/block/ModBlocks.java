package net.AimZAm.JustLearning.block;

import net.AimZAm.JustLearning.AimzamModding;
import net.AimZAm.JustLearning.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    //pareil que pour les items on fait une liste des blocs qui seront ajoutés dans le mod
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AimzamModding.MOD_ID);

    //ici on déclare notre block de neodium
    public static final RegistryObject<Block> NEODIUM_BLOCK = registerBlock("neodium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_NEODIUM_BLOCK = registerBlock("raw_neodium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    //La méthode reçoit un nom et un fournisseur (Supplier) capable de créer une instance d'une sous-classe de Block. Elle déclare cet enregistrement auprès du DeferredRegister, déclare aussi en parallèle l'item associé via registerBlockItem, et renvoie un RegistryObject typé qui servira de référence vers le futur bloc enregistré.
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    //on doit évidemment créer un item pour ce bloc afin qu'il soit présent en jeu car un bloc est un item
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    //Encore pareil que pour les items
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
