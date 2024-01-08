package com.eldenring.tarnished_bot.drop.service

import com.eldenring.tarnished_bot.drop.dto.DropInfo


interface DropService {
    fun readAllByMonstername(monsterName:String) : String
    fun readAllByItemName(itemName:String) : String
}