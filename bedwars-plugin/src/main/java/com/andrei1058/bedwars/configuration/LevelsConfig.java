/*
 * BedWars1058 - A bed wars mini-game.
 * Copyright (C) 2021 Andrei Dascălu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * Contact e-mail: andrew.dascalu@gmail.com
 */

package com.andrei1058.bedwars.configuration;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.configuration.ConfigManager;
import org.jetbrains.annotations.NotNull;

public class LevelsConfig extends ConfigManager {

    public static LevelsConfig levels;

    private LevelsConfig() {
        super(BedWars.plugin, "levels", BedWars.plugin.getDataFolder().toString());
    }

    /**
     * Initialize levels config.
     */
    public static void init() {
        levels = new LevelsConfig();
        levels.getYml().options().copyDefaults(true);
        if (levels.isFirstTime()) {

            levels.getYml().addDefault("levels.1-99.name", "&7[&7{number}✩] ");
            levels.getYml().addDefault("levels.1-99.rankup-cost", 1000);

            levels.getYml().addDefault("levels.100-199.name", "&f[&f{number}✩] ");
            levels.getYml().addDefault("levels.100-199.rankup-cost", 1000);

            levels.getYml().addDefault("levels.200-299.name", "&6[&6{number}✩] ");
            levels.getYml().addDefault("levels.200-299.rankup-cost", 1000);

            levels.getYml().addDefault("levels.300-399.name", "&b[&b{number}✩] ");
            levels.getYml().addDefault("levels.300-399.rankup-cost", 1000);

            levels.getYml().addDefault("levels.400-499.name", "&2[&2{number}✩] ");
            levels.getYml().addDefault("levels.400-499.rankup-cost", 1000);

            levels.getYml().addDefault("levels.500-599.name", "&3[&3{number}✩] ");
            levels.getYml().addDefault("levels.500-599.rankup-cost", 1000);

            levels.getYml().addDefault("levels.600-699.name", "&4[&4{number}✩] ");
            levels.getYml().addDefault("levels.600-699.rankup-cost", 1000);

            levels.getYml().addDefault("levels.700-799.name", "&d[&d{number}✩] ");
            levels.getYml().addDefault("levels.700-799.rankup-cost", 1000);

            levels.getYml().addDefault("levels.800-899.name", "&9[&9{number}✩] ");
            levels.getYml().addDefault("levels.800-899.rankup-cost", 1000);

            levels.getYml().addDefault("levels.900-999.name", "&5[&5{number}✩] ");
            levels.getYml().addDefault("levels.900-999.rankup-cost", 1000);

            levels.getYml().addDefault("levels.1000.name", "&c[&61&e0&a0&b0&d✫&5] ");
            levels.getYml().addDefault("levels.1000.rankup-cost", 1500);

            levels.getYml().addDefault("levels.1001.name", "&c[&61&e0&a0&b1&d✫&5] ");
            levels.getYml().addDefault("levels.1001.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1002.name", "&c[&61&e0&a0&b2&d✫&5] ");
            levels.getYml().addDefault("levels.1002.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1003.name", "&c[&61&e0&a0&b3&d✫&5] ");
            levels.getYml().addDefault("levels.1003.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1004.name", "&c[&61&e0&a0&b4&d✫&5] ");
            levels.getYml().addDefault("levels.1004.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1005.name", "&c[&61&e0&a0&b5&d✫&5] ");
            levels.getYml().addDefault("levels.1005.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1006.name", "&c[&61&e0&a0&b6&d✫&5] ");
            levels.getYml().addDefault("levels.1006.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1007.name", "&c[&61&e0&a0&b7&d✫&5] ");
            levels.getYml().addDefault("levels.1007.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1008.name", "&c[&61&e0&a0&b8&d✫&5] ");
            levels.getYml().addDefault("levels.1008.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1009.name", "&c[&61&e0&a0&b9&d✫&5] ");
            levels.getYml().addDefault("levels.1009.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1010.name", "&c[&61&e0&a1&b0&d✫&5] ");
            levels.getYml().addDefault("levels.1010.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1011.name", "&c[&61&e0&a1&b1&d✫&5] ");
            levels.getYml().addDefault("levels.1011.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1012.name", "&c[&61&e0&a1&b2&d✫&5] ");
            levels.getYml().addDefault("levels.1012.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1013.name", "&c[&61&e0&a1&b3&d✫&5] ");
            levels.getYml().addDefault("levels.1013.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1014.name", "&c[&61&e0&a1&b4&d✫&5] ");
            levels.getYml().addDefault("levels.1014.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1015.name", "&c[&61&e0&a1&b5&d✫&5] ");
            levels.getYml().addDefault("levels.1015.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1016.name", "&c[&61&e0&a1&b6&d✫&5] ");
            levels.getYml().addDefault("levels.1016.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1017.name", "&c[&61&e0&a1&b7&d✫&5] ");
            levels.getYml().addDefault("levels.1017.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1018.name", "&c[&61&e0&a1&b8&d✫&5] ");
            levels.getYml().addDefault("levels.1018.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1019.name", "&c[&61&e0&a1&b9&d✫&5] ");
            levels.getYml().addDefault("levels.1019.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1020.name", "&c[&61&e0&a2&b0&d✫&5] ");
            levels.getYml().addDefault("levels.1020.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1021.name", "&c[&61&e0&a2&b1&d✫&5] ");
            levels.getYml().addDefault("levels.1021.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1022.name", "&c[&61&e0&a2&b2&d✫&5] ");
            levels.getYml().addDefault("levels.1022.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1023.name", "&c[&61&e0&a2&b3&d✫&5] ");
            levels.getYml().addDefault("levels.1023.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1024.name", "&c[&61&e0&a2&b4&d✫&5] ");
            levels.getYml().addDefault("levels.1024.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1025.name", "&c[&61&e0&a2&b5&d✫&5] ");
            levels.getYml().addDefault("levels.1025.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1026.name", "&c[&61&e0&a2&b6&d✫&5] ");
            levels.getYml().addDefault("levels.1026.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1027.name", "&c[&61&e0&a2&b7&d✫&5] ");
            levels.getYml().addDefault("levels.1027.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1028.name", "&c[&61&e0&a2&b8&d✫&5] ");
            levels.getYml().addDefault("levels.1028.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1029.name", "&c[&61&e0&a2&b9&d✫&5] ");
            levels.getYml().addDefault("levels.1029.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1030.name", "&c[&61&e0&a3&b0&d✫&5] ");
            levels.getYml().addDefault("levels.1030.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1031.name", "&c[&61&e0&a3&b1&d✫&5] ");
            levels.getYml().addDefault("levels.1031.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1032.name", "&c[&61&e0&a3&b2&d✫&5] ");
            levels.getYml().addDefault("levels.1032.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1033.name", "&c[&61&e0&a3&b3&d✫&5] ");
            levels.getYml().addDefault("levels.1033.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1034.name", "&c[&61&e0&a3&b4&d✫&5] ");
            levels.getYml().addDefault("levels.1034.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1035.name", "&c[&61&e0&a3&b5&d✫&5] ");
            levels.getYml().addDefault("levels.1035.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1036.name", "&c[&61&e0&a3&b6&d✫&5] ");
            levels.getYml().addDefault("levels.1036.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1037.name", "&c[&61&e0&a3&b7&d✫&5] ");
            levels.getYml().addDefault("levels.1037.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1038.name", "&c[&61&e0&a3&b8&d✫&5] ");
            levels.getYml().addDefault("levels.1038.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1039.name", "&c[&61&e0&a3&b9&d✫&5] ");
            levels.getYml().addDefault("levels.1039.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1040.name", "&c[&61&e0&a4&b0&d✫&5] ");
            levels.getYml().addDefault("levels.1040.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1041.name", "&c[&61&e0&a4&b1&d✫&5] ");
            levels.getYml().addDefault("levels.1041.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1042.name", "&c[&61&e0&a4&b2&d✫&5] ");
            levels.getYml().addDefault("levels.1042.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1043.name", "&c[&61&e0&a4&b3&d✫&5] ");
            levels.getYml().addDefault("levels.1043.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1044.name", "&c[&61&e0&a4&b4&d✫&5] ");
            levels.getYml().addDefault("levels.1044.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1045.name", "&c[&61&e0&a4&b5&d✫&5] ");
            levels.getYml().addDefault("levels.1045.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1046.name", "&c[&61&e0&a4&b6&d✫&5] ");
            levels.getYml().addDefault("levels.1046.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1047.name", "&c[&61&e0&a4&b7&d✫&5] ");
            levels.getYml().addDefault("levels.1047.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1048.name", "&c[&61&e0&a4&b8&d✫&5] ");
            levels.getYml().addDefault("levels.1048.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1049.name", "&c[&61&e0&a4&b9&d✫&5] ");
            levels.getYml().addDefault("levels.1049.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1050.name", "&c[&61&e0&a5&b0&d✫&5] ");
            levels.getYml().addDefault("levels.1050.rankup-cost", 1500);
            // Half way done! phew
            levels.getYml().addDefault("levels.1051.name", "&c[&61&e0&a5&b1&d✫&5] ");
            levels.getYml().addDefault("levels.1051.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1052.name", "&c[&61&e0&a5&b2&d✫&5] ");
            levels.getYml().addDefault("levels.1052.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1053.name", "&c[&61&e0&a5&b3&d✫&5] ");
            levels.getYml().addDefault("levels.1053.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1054.name", "&c[&61&e0&a5&b4&d✫&5] ");
            levels.getYml().addDefault("levels.1054.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1055.name", "&c[&61&e0&a5&b5&d✫&5] ");
            levels.getYml().addDefault("levels.1055.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1056.name", "&c[&61&e0&a5&b6&d✫&5] ");
            levels.getYml().addDefault("levels.1056.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1057.name", "&c[&61&e0&a5&b7&d✫&5] ");
            levels.getYml().addDefault("levels.1057.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1058.name", "&c[&61&e0&a5&b8&d✫&5] ");
            levels.getYml().addDefault("levels.1058.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1059.name", "&c[&61&e0&a5&b9&d✫&5] ");
            levels.getYml().addDefault("levels.1059.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1060.name", "&c[&61&e0&a6&b0&d✫&5] ");
            levels.getYml().addDefault("levels.1060.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1061.name", "&c[&61&e0&a6&b1&d✫&5] ");
            levels.getYml().addDefault("levels.1061.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1062.name", "&c[&61&e0&a6&b2&d✫&5] ");
            levels.getYml().addDefault("levels.1062.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1063.name", "&c[&61&e0&a6&b3&d✫&5] ");
            levels.getYml().addDefault("levels.1063.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1064.name", "&c[&61&e0&a6&b4&d✫&5] ");
            levels.getYml().addDefault("levels.1064.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1065.name", "&c[&61&e0&a6&b5&d✫&5] ");
            levels.getYml().addDefault("levels.1065.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1066.name", "&c[&61&e0&a6&b6&d✫&5] ");
            levels.getYml().addDefault("levels.1066.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1067.name", "&c[&61&e0&a6&b7&d✫&5] ");
            levels.getYml().addDefault("levels.1067.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1068.name", "&c[&61&e0&a6&b8&d✫&5] ");
            levels.getYml().addDefault("levels.1068.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1069.name", "&c[&61&e0&a6&b9&d✫&5] ");
            levels.getYml().addDefault("levels.1069.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1070.name", "&c[&61&e0&a7&b0&d✫&5] ");
            levels.getYml().addDefault("levels.1070.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1071.name", "&c[&61&e0&a7&b1&d✫&5] ");
            levels.getYml().addDefault("levels.1071.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1072.name", "&c[&61&e0&a7&b2&d✫&5] ");
            levels.getYml().addDefault("levels.1072.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1073.name", "&c[&61&e0&a7&b3&d✫&5] ");
            levels.getYml().addDefault("levels.1073.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1074.name", "&c[&61&e0&a7&b4&d✫&5] ");
            levels.getYml().addDefault("levels.1074.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1075.name", "&c[&61&e0&a7&b5&d✫&5] ");
            levels.getYml().addDefault("levels.1075.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1076.name", "&c[&61&e0&a7&b6&d✫&5] ");
            levels.getYml().addDefault("levels.1076.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1077.name", "&c[&61&e0&a7&b7&d✫&5] ");
            levels.getYml().addDefault("levels.1077.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1078.name", "&c[&61&e0&a7&b8&d✫&5] ");
            levels.getYml().addDefault("levels.1078.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1079.name", "&c[&61&e0&a7&b9&d✫&5] ");
            levels.getYml().addDefault("levels.1079.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1080.name", "&c[&61&e0&a8&b0&d✫&5] ");
            levels.getYml().addDefault("levels.1080.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1081.name", "&c[&61&e0&a8&b1&d✫&5] ");
            levels.getYml().addDefault("levels.1081.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1082.name", "&c[&61&e0&a8&b2&d✫&5] ");
            levels.getYml().addDefault("levels.1082.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1083.name", "&c[&61&e0&a8&b3&d✫&5] ");
            levels.getYml().addDefault("levels.1083.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1084.name", "&c[&61&e0&a8&b4&d✫&5] ");
            levels.getYml().addDefault("levels.1084.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1085.name", "&c[&61&e0&a8&b5&d✫&5] ");
            levels.getYml().addDefault("levels.1085.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1086.name", "&c[&61&e0&a8&b6&d✫&5] ");
            levels.getYml().addDefault("levels.1086.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1087.name", "&c[&61&e0&a8&b7&d✫&5] ");
            levels.getYml().addDefault("levels.1087.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1088.name", "&c[&61&e0&a8&b8&d✫&5] ");
            levels.getYml().addDefault("levels.1088.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1089.name", "&c[&61&e0&a8&b9&d✫&5] ");
            levels.getYml().addDefault("levels.1089.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1090.name", "&c[&61&e0&a9&b0&d✫&5] ");
            levels.getYml().addDefault("levels.1090.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1091.name", "&c[&61&e0&a9&b1&d✫&5] ");
            levels.getYml().addDefault("levels.1091.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1092.name", "&c[&61&e0&a9&b2&d✫&5] ");
            levels.getYml().addDefault("levels.1092.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1093.name", "&c[&61&e0&a9&b3&d✫&5] ");
            levels.getYml().addDefault("levels.1093.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1094.name", "&c[&61&e0&a9&b4&d✫&5] ");
            levels.getYml().addDefault("levels.1094.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1095.name", "&c[&61&e0&a9&b5&d✫&5] ");
            levels.getYml().addDefault("levels.1095.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1096.name", "&c[&61&e0&a9&b6&d✫&5] ");
            levels.getYml().addDefault("levels.1096.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1097.name", "&c[&61&e0&a9&b7&d✫&5] ");
            levels.getYml().addDefault("levels.1097.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1098.name", "&c[&61&e0&a9&b8&d✫&5] ");
            levels.getYml().addDefault("levels.1098.rankup-cost", 1500);
            levels.getYml().addDefault("levels.1099.name", "&c[&61&e0&a9&b9&d✫&5] ");
            levels.getYml().addDefault("levels.1099.rankup-cost", 1500);

            // Finally, completed it :D

            levels.getYml().addDefault("levels.1100-1199.name", "&7[&f{number}&7✪&7] ");
            levels.getYml().addDefault("levels.1100-1199.rankup-cost", 2500);

            levels.getYml().addDefault("levels.1200-1299.name", "&7[&e{number}&6✪&7] ");
            levels.getYml().addDefault("levels.1200-1299.rankup-cost", 2500);

            levels.getYml().addDefault("levels.1300-1399.name", "&7[&b{number}&3✪&7] ");
            levels.getYml().addDefault("levels.1300-1399.rankup-cost", 2500);

            levels.getYml().addDefault("levels.1400-1499.name", "&7[&a{number}&2✪&7] ");
            levels.getYml().addDefault("levels.1400-1499.rankup-cost", 2500);

            levels.getYml().addDefault("levels.1500-1599.name", "&7[&3{number}&9✪&7] ");
            levels.getYml().addDefault("levels.1500-1599.rankup-cost", 2500);

            levels.getYml().addDefault("levels.1600-1699.name", "&7[&c{number}&4✪&7] ");
            levels.getYml().addDefault("levels.1600-1699.rankup-cost", 2500);

            levels.getYml().addDefault("levels.1700-1799.name", "&7[&d{number}&5✪&7] ");
            levels.getYml().addDefault("levels.1700-1799.rankup-cost", 2500);

            levels.getYml().addDefault("levels.1800-1899.name", "&7[&9{number}&1✪&7] ");
            levels.getYml().addDefault("levels.1800-1899.rankup-cost", 2500);

            levels.getYml().addDefault("levels.1900-1999.name", "&7[&5{number}&8✪&7] ");
            levels.getYml().addDefault("levels.1900-1999.rankup-cost", 2500);

            levels.getYml().addDefault("levels.2000.name", "&8[&72&f00&70✪&8] ");
            levels.getYml().addDefault("levels.2000.rankup-cost", 2000);

            // I ain't doing anything more than this...

            levels.getYml().addDefault("levels.others.name", "&7[{number}✩] ");
            levels.getYml().addDefault("levels.others.rankup-cost", 5000);
        }

        levels.getYml().addDefault("xp-rewards.per-minute", 10);
        levels.getYml().addDefault("xp-rewards.per-teammate", 5);
        levels.getYml().addDefault("xp-rewards.game-win", 100);
        levels.getYml().addDefault("xp-rewards.bed-destroyed", 15);
        levels.getYml().addDefault("xp-rewards.regular-kill", 10);
        levels.getYml().addDefault("xp-rewards.final-kill", 15);

        levels.getYml().addDefault("progress-bar.symbol", "■");
        levels.getYml().addDefault("progress-bar.unlocked-color", "&b");
        levels.getYml().addDefault("progress-bar.locked-color", "&7");
        levels.getYml().addDefault("progress-bar.format", "&8 [{progress}&8]");

        levels.save();
    }

    @NotNull
    public static String getLevelName(int level) {
        String name = levels.getYml().getString("levels." + level + ".name");
        if (name != null) return name;
        for (String key : levels.getYml().getConfigurationSection("levels").getKeys(false)) {
            if (key.contains("-")) {
                String[] nrs = key.split("-");
                if (nrs.length != 2) continue;
                int nr1, nr2;
                try {
                    nr1 = Integer.parseInt(nrs[0]);
                    nr2 = Integer.parseInt(nrs[1]);
                } catch (Exception ex) {
                    continue;
                }
                if (nr1 <= level && level <= nr2) {
                    return levels.getYml().getString("levels." + key + ".name");
                }
            }
        }
        return levels.getYml().getString("levels.others.name");
    }

    public static int getNextCost(int level) {
        if (levels.getYml().get("levels." + level + ".rankup-cost") != null) return levels.getYml().getInt("levels." + level + ".rankup-cost");
        for (String key : levels.getYml().getConfigurationSection("levels").getKeys(false)) {
            if (key.contains("-")) {
                String[] nrs = key.split("-");
                if (nrs.length != 2) continue;
                int nr1, nr2;
                try {
                    nr1 = Integer.parseInt(nrs[0]);
                    nr2 = Integer.parseInt(nrs[1]);
                } catch (Exception ex) {
                    continue;
                }
                if (nr1 <= level && level <= nr2) {
                    return levels.getYml().getInt("levels." + key + ".rankup-cost");
                }
            }
        }
        return levels.getYml().getInt("levels.others.rankup-cost");
    }
}
