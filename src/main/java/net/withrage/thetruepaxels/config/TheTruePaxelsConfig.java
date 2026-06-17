package net.withrage.thetruepaxels.config;

import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TheTruePaxelsConfig {
    private static final Path PATH =
            FMLPaths.CONFIGDIR.get().resolve("thetruepaxels.toml");

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

            Map<String, String> values = readSimpleToml(PATH);

            woodStripping = getBoolean(values, "general.woodStripping", woodStripping);
            pathMaking = getBoolean(values, "general.pathMaking", pathMaking);
            farmlandMaking = getBoolean(values, "general.farmlandMaking", farmlandMaking);

            woodenDurability = getInt(values, "durability.wooden", woodenDurability);
            stoneDurability = getInt(values, "durability.stone", stoneDurability);
            copperDurability = getInt(values, "durability.copper", copperDurability);
            goldenDurability = getInt(values, "durability.golden", goldenDurability);
            ironDurability = getInt(values, "durability.iron", ironDurability);
            diamondDurability = getInt(values, "durability.diamond", diamondDurability);
            netheriteDurability = getInt(values, "durability.netherite", netheriteDurability);

        } catch (Exception e) {
            e.printStackTrace();

            try {
                writeDefaultFile();
            } catch (Exception ignored) {
            }
        }
    }

    private static Map<String, String> readSimpleToml(Path path) throws Exception {
        Map<String, String> values = new HashMap<>();
        String section = "";

        for (String rawLine : Files.readAllLines(path)) {
            String line = rawLine.trim();

            if (line.isEmpty() || line.startsWith("#")) continue;

            int commentIndex = line.indexOf("#");
            if (commentIndex >= 0) {
                line = line.substring(0, commentIndex).trim();
            }

            if (line.startsWith("[") && line.endsWith("]")) {
                section = line.substring(1, line.length() - 1).trim();
                continue;
            }

            int equalsIndex = line.indexOf("=");
            if (equalsIndex < 0) continue;

            String key = line.substring(0, equalsIndex).trim();
            String value = line.substring(equalsIndex + 1).trim();

            values.put(section + "." + key, value);
        }

        return values;
    }

    private static boolean getBoolean(Map<String, String> values,
                                      String key,
                                      boolean def) {

        String value = values.get(key);
        if (value == null) return def;

        return Boolean.parseBoolean(value);
    }

    private static int getInt(Map<String, String> values,
                              String key,
                              int def) {

        String value = values.get(key);
        if (value == null) return def;

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return def;
        }
    }

    private static void writeDefaultFile() throws Exception {
        String content = """
                # The True Paxels Configuration
                
                [general]
                
                # If true, paxels can strip wooden logs.
                woodStripping = true
                
                # If true, paxels can make dirt paths.
                pathMaking = true
                
                # If true, paxels can make farmland.
                farmlandMaking = true
                
                
                [durability]
                
                # You can change the durability for each Paxel here.
                wooden = 108
                stone = 262
                copper = 380
                golden = 64
                iron = 506
                diamond = 3122
                netherite = 4062
                """;

        Files.createDirectories(PATH.getParent());
        Files.writeString(PATH, content);
    }
}
