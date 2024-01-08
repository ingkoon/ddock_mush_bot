package com.eldenring.tarnished_bot.item.repository

import com.eldenring.tarnished_bot.item.Entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository: JpaRepository<Item, Long> {
}