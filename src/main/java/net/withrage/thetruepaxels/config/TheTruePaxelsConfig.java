package net.withrage.thetruepaxels.config;

import net.fabricmc.loader.api.FabricLoader;
import org.tomlj.Toml;
import org.tomlj.TomlParseResult;

import java.nio.file.Files;
import java.nio.file.Path;

public class TheTruePaxelsConfig {
    private static final Path PATH = FabricLoader.getInstance().getConfigDir().resolve("thetruepaxels.toml");

    public static boolean woodStripping = true;
    public static boolean pathMaking = true;
    public static boolean farmlandMaking = true;

    public static int woodenDurability = 108;
    public static int stoneDurability = 262;
    public static int copperDurability = 380;
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

            woodStripping = getBoolean(toml, "general.woodStripping", woodStripping);
            pathMaking = getBoolean(toml, "general.pathMaking", pathMaking);
            farmlandMaking = getBoolean(toml, "general.farmlandMaking", farmlandMaking);

            woodenDurability = getInt(toml, "durability.wooden", woodenDurability);
            stoneDurability = getInt(toml, "durability.stone", stoneDurability);
            copperDurability = getInt(toml, "durability.copper", copperDurability);
            goldenDurability = getInt(toml, "durability.golden", goldenDurability);
            ironDurability = getInt(toml, "durability.iron", ironDurability);
            diamondDurability = getInt(toml, "durability.diamond", diamondDurability);
            netheriteDurability = getInt(toml, "durability.netherite", netheriteDurability);

        } catch (Exception e) {
            try { writeDefaultFile(); } catch (Exception ignored) {}
        }
    }

    private static boolean getBoolean(TomlParseResult toml, String key, boolean def) {
        Boolean v = toml.getBoolean(key);
        return v != null ? v : def;
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
                + "[general]\n"
                + "# If true, paxels can strip wooden logs.\n"
                + "woodStripping = " + woodStripping + "\n"
                + "# If true, paxels can make dirt paths.\n"
                + "pathMaking = " + pathMaking + "\n"
                + "# If true, paxels can make farmland.\n"
                + "farmlandMaking = " + farmlandMaking + "\n\n"
                + "[durability]\n"
                + "# You can change the durability for each Paxel here.\n"
                + "wooden = " + woodenDurability + "\n"
                + "stone = " + stoneDurability + "\n"
                + "copper = " + copperDurability + "\n"
                + "golden = " + goldenDurability + "\n"
                + "iron = " + ironDurability + "\n"
                + "diamond = " + diamondDurability + "\n"
                + "netherite = " + netheriteDurability + "\n";

        Files.writeString(PATH, content);
    }
}
