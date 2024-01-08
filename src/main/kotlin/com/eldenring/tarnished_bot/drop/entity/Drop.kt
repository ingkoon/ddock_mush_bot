package com.eldenring.tarnished_bot.drop.entity

import lombok.Builder
import lombok.Getter
import javax.persistence.*

@Entity
@Getter
@Builder
@Table(name = "tb_drop")
class Drop(
    @Column(name = "monster_name")
    var monsterName: String,
    @Column(name = "item_name")
    var itemName: String,
    @Column(name = "drop_rate")
    var dropRate: String,
) {
    @Id
    @Column(name = "drop_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}