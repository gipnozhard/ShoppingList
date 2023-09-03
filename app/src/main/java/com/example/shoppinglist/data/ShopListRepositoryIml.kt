package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository

object ShopListRepositoryIml: ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    //private val shopList = mutableListOf<ShopItem>()
    private val shopList = sortedSetOf<ShopItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
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
        //shopItem.id = autoIncrementId++
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        //TODO("Not yet implemented")
        shopList.remove(shopItem)
        updateList()
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

    override fun getShopList(): LiveData<List<ShopItem>> {
        //TODO("Not yet implemented")
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}