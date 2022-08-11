package com.foodtracker.foodtrackerapi.services;

import java.util.ArrayList;
import java.util.Optional;

import com.foodtracker.foodtrackerapi.models.CurrentShoppingList;
import com.foodtracker.foodtrackerapi.models.OldShoppingList;
import com.foodtracker.foodtrackerapi.models.Product;

public interface ShoppingListService {

    Integer createProductForCurrentShoppingList(Integer userId, Product product);

    Integer addProductInCurrentShoppingList(Integer userId, Integer productId);

    Integer addProductInOldShoppingList(Integer userId, Integer productId);

    Optional<CurrentShoppingList> getCurrentShoppingListByID(Integer userId);

    Optional<OldShoppingList> getOldShoppingListByID(Integer userId);

    Integer updateAllItemsOldShoppingList(Integer userId, ArrayList<Product> oldShoppingList);

    Integer updateAllItemsCurrentShoppingList(Integer userId, ArrayList<Product> currentShoppingList);

    Integer updateProductInCurrentShoppingList(Integer userId, Product newProduct);

    Integer updateProductInOldShoppingList(Integer userId, Product newProduct);

    Integer removeProductInCurrentShoppingList(Integer userId, Integer productId);

    Integer removeProductInOldShoppingList(Integer userId, Integer productId);

    Integer deleteProductInCurrentShoppingList(Integer userId, Integer productId);

    Integer deleteProductInOldShoppingList(Integer userId, Integer productId);

}
