package com.eldenring.tarnished_bot.item.Entity

import lombok.Getter
import lombok.NoArgsConstructor
import javax.persistence.*

@Getter
@Entity
@NoArgsConstructor
@Table(name = "tb_item")
class Item(
    @Column(name = "req_level")
    var reqLevel: Int,
    @Column(name = "item_name")
    var name:String,
    @Column(nullable = true)
    var stat: String,
    @Column(nullable = true)
    var power: Int,
    @Column(nullable = true)
    var def: Int,
    @Column(nullable = true)
    var etc: String,
    @Column(nullable = true)
    var upgrade: Int
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}