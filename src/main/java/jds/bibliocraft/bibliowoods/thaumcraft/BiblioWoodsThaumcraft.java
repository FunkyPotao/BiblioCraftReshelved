package jds.bibliocraft.bibliowoods.thaumcraft;

import jds.bibliocraft.blocks.BlockBookcase;
import jds.bibliocraft.helpers.BiblioWoodHelperTab;
import jds.bibliocraft.helpers.RegisterCustomFramedBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

public class BiblioWoodsThaumcraft {
    public static CreativeTabs creativeTab;

    public static void init()
    {
            Block[] ThaumPlanks =  {
                    Block.REGISTRY.getObject(new ResourceLocation("thaumcraft:plank_silverwood")),
                    Block.REGISTRY.getObject(new ResourceLocation("thaumcraft:plank_greatwood"))
            };

            Block[] ThaumSlabs =  {
                    Block.REGISTRY.getObject(new ResourceLocation("thaumcraft:plank_silverwood")),
                    Block.REGISTRY.getObject(new ResourceLocation("thaumcraft:plank_greatwood"))
            };

            String[] textures = {
                    "thaumcraft:blocks/plank_silverwood",
                    "thaumcraft:blocks/plank_greatwood",
            };

            ItemStack icon = new ItemStack(BlockBookcase.instance, 1, 6);
            NBTTagCompound tags = new NBTTagCompound();
            tags.setString("renderTexture", "thaumcraft:blocks/plank_greatwood");
            icon.setTagCompound(tags);
            creativeTab = new BiblioWoodHelperTab("bibliowoodthaumcrafttab", textures, icon);
            for (int i = 0; i < textures.length; i++)
            {
                RegisterCustomFramedBlocks reg = new RegisterCustomFramedBlocks(textures[i]);
                reg.registerRecipies(new ItemStack(ThaumPlanks[i], 1), new ItemStack(ThaumSlabs[i], 1));
            }

    }
}
