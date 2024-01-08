package com.eldenring.tarnished_bot.drop.repository

import com.eldenring.tarnished_bot.drop.entity.Drop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface DropRepository : JpaRepository<Drop, Long>{

    @Query("select distinct d from Drop d where d.monsterName = :monsterName group by d.itemName order by d.dropRate desc")
    fun findByMonsterName(@Param("monsterName") monsterName: String) : List<Drop>

    @Query("select d from Drop d where d.itemName = :itemName order by d.monsterName")
    fun findByItemName(@Param("itemName") itemName: String) : List<Drop>
}