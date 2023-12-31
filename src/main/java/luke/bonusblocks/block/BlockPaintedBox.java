package luke.bonusblocks.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class BlockPaintedBox extends Block {
    public static final int[] texCoords = new int[16];

    public static int TEX_COORD_OFFSET = 3;
    public BlockPaintedBox(String key, int id, Material material) {
        super(key, id, material.wood);
    }

    public int getBlockTextureFromSideAndMetadata(Side side, int meta) {
        return texCoords[meta & 15];
    }

    public static int getMetadataForColour(int i) {
        return ~i & 15;
    }

    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        return new ItemStack[]{new ItemStack(this, 1, meta)};
    }

    static {
        texCoords[0] = Block.texCoordToIndex(29, 29);

        for(int i = 1; i < 16; ++i) {
            texCoords[i] = texCoords[0] - (i % 4 * 32 * TEX_COORD_OFFSET + i / 4 * TEX_COORD_OFFSET);
        }

    }

}
