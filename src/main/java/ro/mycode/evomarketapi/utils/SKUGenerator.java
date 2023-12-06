package ro.mycode.evomarketapi.utils;

import ro.mycode.evomarketapi.product.repo.ProductRepo;
import ro.mycode.evomarketapi.product.services.ProductCommandServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SKUGenerator {

    private final static List<String> skuList = new ArrayList<>();

    public static String generateUniqueSKU() {
        int randomNumber = new Random().nextInt((999999 - 100000) + 1) + 100000;
        String staticPrefix = "SKU";
        String potentialSKU = staticPrefix + randomNumber;

        if (potentialSKU.length() >= 8 && potentialSKU.length() <= 12) {
            if(!skuList.contains(potentialSKU)){
                skuList.add(potentialSKU);
                return potentialSKU;
            } else {
                return generateUniqueSKU();
            }
        } else {
            return generateUniqueSKU();
        }
    }
}
