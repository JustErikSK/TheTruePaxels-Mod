package net.withrage.thetruepaxels.config;

import net.fabricmc.loader.api.FabricLoader;
import org.tomlj.Toml;
import org.tomlj.TomlParseResult;

import java.nio.file.Files;
import java.nio.file.Path;

public class TheTruePaxelsConfig {
    private static final Path PATH = FabricLoader.getInstance().getConfigDir().resolve("thetruepaxels.toml");

    public static int woodenDurability = 108;
    public static int stoneDurability = 262;
    public static int goldenDurability = 64;
    public static int ironDurability = 506;
    public static int diamondDurability = 3122;
    public static int netheriteDurability = 4062;

    public static void load() {
        try {
            if (!Files.exists(PATH)) {
                writeDefaultFile();
                return;
            }

            TomlParseResult toml = Toml.parse(Files.readString(PATH));

            if (toml.hasErrors()) {
                writeDefaultFile();
                return;
            }

            woodenDurability = getInt(toml, "durability.wooden", woodenDurability);
            stoneDurability = getInt(toml, "durability.stone", stoneDurability);
            goldenDurability = getInt(toml, "durability.golden", goldenDurability);
            ironDurability = getInt(toml, "durability.iron", ironDurability);
            diamondDurability = getInt(toml, "durability.diamond", diamondDurability);
            netheriteDurability = getInt(toml, "durability.netherite", netheriteDurability);

        } catch (Exception e) {
            try { writeDefaultFile(); } catch (Exception ignored) {}
        }
    }

    private static int getInt(TomlParseResult toml, String key, int def) {
        Long v = toml.getLong(key);
        if (v == null) return def;
        if (v > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (v < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return v.intValue();
    }

    private static void writeDefaultFile() throws Exception {
        Files.createDirectories(PATH.getParent());

        String content = ""
                + "# ================================\n"
                + "# The True Paxels Configuration\n"
                + "# ================================\n\n"
                + "[durability]\n"
                + "# You can change the durability for each Paxel here.\n"
                + "wooden = " + woodenDurability + "\n"
                + "stone = " + stoneDurability + "\n"
                + "golden = " + goldenDurability + "\n"
                + "iron = " + ironDurability + "\n"
                + "diamond = " + diamondDurability + "\n"
                + "netherite = " + netheriteDurability + "\n";

        Files.writeString(PATH, content);
    }
}
