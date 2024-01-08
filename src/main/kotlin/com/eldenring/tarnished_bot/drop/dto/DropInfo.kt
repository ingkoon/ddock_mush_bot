package com.eldenring.tarnished_bot.drop.dto

import com.eldenring.tarnished_bot.drop.entity.Drop


data class DropInfo(
    val monster_name:String?,
    val item_name:String?,
    val drop_rate:String?
    ){
    fun fromEntity(drop: Drop): DropInfo{
        return DropInfo(drop.monsterName, drop.itemName, drop.dropRate)
    }
}