package com.eldenring.tarnished_bot.monster.service

import com.eldenring.tarnished_bot.drop.dto.DropInfo

interface MonsterService {
    public fun readByName(name: String) : String
    public fun readById(id: Long) : String
}