package jds.bibliocraft.bibliowoods.twilightforest;

import jds.bibliocraft.blocks.BlockBookcase;
import jds.bibliocraft.helpers.BiblioWoodHelperTab;
import jds.bibliocraft.helpers.RegisterCustomFramedBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

public class BiblioWoodsTF {
    public static CreativeTabs creativeTab;

    public static void init()
    {


        if (Loader.isModLoaded("twilightforest"))
        {

            Block[] TFPlanks =  {
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:autumnal_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:bald_cypress_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:cypress_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:douglas_fir_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:japanese_maple_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:peach_sakura_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:rainbow_eucalyptus_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:scalewood_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:wattle_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:white_fir_planks"))
            };

            Block[] TFSlabs =  {
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:autumnal_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:bald_cypress_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:cypress_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:douglas_fir_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:japanese_maple_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:peach_sakura_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:rainbow_eucalyptus_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:scalewood_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:wattle_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("ebt:white_fir_slab"))
            };

            for (int i = 0; i < EBTPlanks.length; i++)
                if (EBTPlanks[i] == null || EBTSlabs[i] == null) return;

            String[] textures = {
                    "ebt:blocks/autumnal_planks",
                    "ebt:blocks/bald_cypress_planks",
                    "ebt:blocks/cypress_planks",
                    "ebt:blocks/douglas_fir_planks",
                    "ebt:blocks/japanese_maple_planks",
                    "ebt:blocks/peach_sakura_planks",
                    "ebt:blocks/rainbow_eucalyptus_planks",
                    "ebt:blocks/scalewood_planks",
                    "ebt:blocks/wattle_planks",
                    "ebt:blocks/white_fir_planks",
            };

            ItemStack icon = new ItemStack(BlockBookcase.instance, 1, 6);
            NBTTagCompound tags = new NBTTagCompound();
            tags.setString("renderTexture", "ebt:blocks/autumnal_planks");
            icon.setTagCompound(tags);
            creativeTab = new BiblioWoodHelperTab("bibliowoodebttab", textures, icon);
            for (int i = 0; i < textures.length; i++)
            {
                RegisterCustomFramedBlocks reg = new RegisterCustomFramedBlocks(textures[i]);
                reg.registerRecipies(new ItemStack(EBTPlanks[i], 1), new ItemStack(EBTSlabs[i], 1));
            }

        }
    }

}
