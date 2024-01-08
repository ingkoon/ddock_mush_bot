package com.eldenring.tarnished_bot.monster.repository

import com.eldenring.tarnished_bot.monster.entity.Monster
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MonsterRepository: JpaRepository<Monster, Long>{
//    fun findByName(): List<Monster>

    @Query("select m from Monster m where m.name = :monsterName")
    fun findByMonstername(@Param("monsterName") monsterName: String): Monster
}