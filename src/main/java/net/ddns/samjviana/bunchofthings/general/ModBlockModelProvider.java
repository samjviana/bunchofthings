package net.ddns.samjviana.bunchofthings.general;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.state.properties.Colors;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BunchOfThings.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (Colors color : Colors.values()) {
            String name = color.toString() + "_sticky_piston";
            getBuilder(name)
                .parent(getExistingFile(modLoc("block/colored_sticky_piston")));
        }
    }
}