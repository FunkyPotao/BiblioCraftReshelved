package jds.bibliocraft.bibliowoods.betternether;

import jds.bibliocraft.blocks.BlockBookcase;
import jds.bibliocraft.helpers.BiblioWoodHelperTab;
import jds.bibliocraft.helpers.RegisterCustomFramedBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

public class BiblioWoodsBN {
    public static CreativeTabs creativeTab;

    public static void init()
    {
        if (Loader.isModLoaded("betternether"))
        {
            // bn only has 1 wood type lol

            Block Plank = Block.REGISTRY.getObject(new ResourceLocation("betternether:stalagnate_planks"));
            Block Slab = Block.REGISTRY.getObject(new ResourceLocation("betternether:stalagnate_planks_slab_half"));

            if (Plank == null || Slab == null) return;

            String[] Texture = { "betternether:blocks/stalagnate_planks" };

            ItemStack icon = new ItemStack(BlockBookcase.instance, 1, 6);
            NBTTagCompound tags = new NBTTagCompound();
            tags.setString("renderTexture", Texture[0]);
            icon.setTagCompound(tags);
            creativeTab = new BiblioWoodHelperTab("bibliowoodbntab", Texture, icon);

            RegisterCustomFramedBlocks reg = new RegisterCustomFramedBlocks(Texture[0]);
            reg.registerRecipies(new ItemStack(Plank, 1), new ItemStack(Slab, 1));
        }
    }

}
