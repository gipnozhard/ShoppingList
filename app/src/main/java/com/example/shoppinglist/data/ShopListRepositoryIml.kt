package com.example.shoppinglist.data

import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository

object ShopListRepositoryIml: ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }
    override fun addShopItem(shopItem: ShopItem) {
        //TODO("Not yet implemented")
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopItem.id = autoIncrementId++
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        //TODO("Not yet implemented")
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        //TODO("Not yet implemented")
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        //TODO("Not yet implemented")
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id.$shopItemId not found")
    }

    override fun getShopList(): List<ShopItem> {
        //TODO("Not yet implemented")
        return shopList.toList()
    }
}