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
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:tower_wood")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:canopy_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:mangrove_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:dark_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:time_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:trans_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:mine_planks")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:sort_planks"))
            };

            Block[] TFSlabs =  {
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:tower_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:canopy_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:mangrove_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:dark_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:time_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:trans_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:mine_slab")),
                    Block.REGISTRY.getObject(new ResourceLocation("twilightforest:sort_slab"))
            };

            for (int i = 0; i < TFPlanks.length; i++)
                if (TFPlanks[i] == null || TFSlabs[i] == null) return;

            //twilight forest actually has multiple texture variants but idk how one could implement that randomization
            String[] textures = {
                    "twilightforest:blocks/towerwood_planks",
                    "twilightforest:blocks/wood/planks_canopy_0",
                    "twilightforest:blocks/wood/planks_mangrove_0",
                    "twilightforest:blocks/wood/planks_darkwood_0",
                    "twilightforest:blocks/wood/planks_time_0",
                    "twilightforest:blocks/wood/planks_trans_0",
                    "twilightforest:blocks/wood/planks_mine_0",
                    "twilightforest:blocks/wood/planks_sort_0"
            };

            ItemStack icon = new ItemStack(BlockBookcase.instance, 1, 6);
            NBTTagCompound tags = new NBTTagCompound();
            tags.setString("renderTexture", "twilightforest:blocks/wood/planks_canopy_0");
            icon.setTagCompound(tags);
            creativeTab = new BiblioWoodHelperTab("bibliowoodtftab", textures, icon);
            for (int i = 0; i < textures.length; i++)
            {
                RegisterCustomFramedBlocks reg = new RegisterCustomFramedBlocks(textures[i]);
                reg.registerRecipies(new ItemStack(TFPlanks[i], 1), new ItemStack(TFSlabs[i], 1));
            }

        }
    }

}
