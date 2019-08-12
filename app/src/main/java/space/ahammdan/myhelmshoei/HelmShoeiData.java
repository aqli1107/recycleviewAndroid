package space.ahammdan.myhelmshoei;

import java.util.ArrayList;

public class HelmShoeiData {
    private static String[][] data = new String[][]{
            {"https://www.cyclegear.com/_a/product_images/0224/4057/shoei_x14_laverty_tc4_750x750.jpg","Shoei X14 Laverty","Helm Full Face with Aerodynamic Desain","9500000"},
            {"https://www.revzilla.com/product_images/0350/6014/shoei_x14_brink_helmet_750x750.jpg","Shoei X-Fourteen Brink TC5", "Helm Full Face with Aerodynamic Desain","9000000"},
            {"https://www.cyclegear.com/_a/product_images/0396/1607/shoei_x14_marquez5_helmet_750x750.jpg","Shoei X-Fourteen Marquez 5 TC1", "Helm Full Face with Aerodynamic Desain","9300000"},
            {"https://www.cyclegear.com/_a/product_images/0306/1479/shoei_x14_marquez_motegi_tc1_red_white_black_gold_750x750.jpg","Shoei X-14 Marquez Motegi ", "Helm Full Face with Aerodynamic Desain","9300000"},
            {"https://www.cyclegear.com/_a/product_images/0898/9859/shoei_x14_power_rush_tc8_orange_green_750x750.jpg","Shoei X-14 Power Rush Helmet", "Helm Full Face with Aerodynamic Desain","9300000"},
    };

    public static ArrayList<HelmShoei> getListData() {
        ArrayList<HelmShoei> list = new ArrayList<>();
        for (String[] aData: data) {
            HelmShoei helmShoei = new HelmShoei();
            helmShoei.setPhoto(aData[0]);
            helmShoei.setName(aData[1]);
            helmShoei.setFeature(aData[2]);
            helmShoei.setPrice(Integer.parseInt(aData[3]));
            list.add(helmShoei);
        }
        return list;
    }
}
