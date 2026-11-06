package jds.bibliocraft.bibliowoods.aether;

import jds.bibliocraft.blocks.BlockBookcase;
import jds.bibliocraft.helpers.BiblioWoodHelperTab;
import jds.bibliocraft.helpers.RegisterCustomFramedBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

public class BiblioWoodsAether {
    public static CreativeTabs creativeTab;

    public static void init()
    {
        if (Loader.isModLoaded("aether_legacy")) {
            // bn only has 1 wood type lol

            //TODO fix recipe
            Block Plank = Block.REGISTRY.getObject(new ResourceLocation("aether_legacy:skyroot_plank"));
            Block Slab = Block.REGISTRY.getObject(new ResourceLocation("aether_legacy:skyroot_slab"));

            if (Plank == null || Slab == null) return;

            String[] Texture = {"aether_legacy:blocks/skyroot_plank"};

            ItemStack icon = new ItemStack(BlockBookcase.instance, 1, 6);
            NBTTagCompound tags = new NBTTagCompound();
            tags.setString("renderTexture", Texture[0]);
            icon.setTagCompound(tags);
            creativeTab = new BiblioWoodHelperTab("bibliowoodaethertab", Texture, icon);

            RegisterCustomFramedBlocks reg = new RegisterCustomFramedBlocks(Texture[0]);
            reg.registerRecipies(new ItemStack(Plank, 1), new ItemStack(Slab, 1));
        }
    }
}
