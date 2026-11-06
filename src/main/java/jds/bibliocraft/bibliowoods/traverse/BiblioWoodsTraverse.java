package jds.bibliocraft.bibliowoods.traverse;

import jds.bibliocraft.blocks.BlockBookcase;
import jds.bibliocraft.helpers.BiblioWoodHelperTab;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

public class BiblioWoodsTraverse {

    public static CreativeTabs creativeTab;

    public static void init()
    {
        if (Loader.isModLoaded("traverse"))
        {
            // bn only has 1 wood type lol

            Block Plank = Block.REGISTRY.getObject(new ResourceLocation("traverse:fir_plank"));
            Block Slab = Block.REGISTRY.getObject(new ResourceLocation("traverse:fir_slab"));

            if (Plank == null || Slab == null) return;

            String[] Texture = { "traverse:block/planks/fir_planks" };

            ItemStack icon = new ItemStack(BlockBookcase.instance, 1, 6);
            NBTTagCompound tags = new NBTTagCompound();
            tags.setString("renderTexture", Texture[0]);
            icon.setTagCompound(tags);
            creativeTab = new BiblioWoodHelperTab("bibliowoodtraversetab", Texture, icon);
        }
    }
}
