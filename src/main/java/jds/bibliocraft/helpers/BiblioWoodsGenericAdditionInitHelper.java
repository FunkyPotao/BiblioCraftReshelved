package jds.bibliocraft.helpers;

import jds.bibliocraft.blocks.BlockBookcase;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Loader;

public class BiblioWoodsGenericAdditionInitHelper {
    public static CreativeTabs creativeTab;


    /*
        String Mod  ->  used to check if that mod is loaded
        Block[] Planks  ->  definition for planks, will be used for recipes
        Block[] Slabs  ->  definition for planks, will be used for recipes
        String[] Textures  ->  definition for textures, will be used for rendering
        String CreativeTabMaterial  ->  the material you want the creative tab to have
        String TabName  ->  the name of the tab
     */
    //TODO, finish and use it

    public void BiblioWoodInitialize(String Mod,
                                     Block[] Planks,
                                     Block[] Slabs,
                                     String[] Textures,
                                     String CreativeTabMaterial,
                                     String TabName) {

        if (Loader.isModLoaded(Mod))
        {

            for (int i = 0; i < Planks.length; i++)
                if (Planks[i] == null || Slabs[i] == null) return;


            ItemStack icon = new ItemStack(BlockBookcase.instance, 1, 6);
            NBTTagCompound tags = new NBTTagCompound();
            tags.setString("renderTexture", CreativeTabMaterial);
            icon.setTagCompound(tags);
            creativeTab = new BiblioWoodHelperTab(TabName, Textures, icon);
            for (int i = 0; i < Textures.length; i++)
            {
                RegisterCustomFramedBlocks reg = new RegisterCustomFramedBlocks(Textures[i]);
                reg.registerRecipies(new ItemStack(Planks[i], 1), new ItemStack(Slabs[i], 1));
            }
        }

    }
}
