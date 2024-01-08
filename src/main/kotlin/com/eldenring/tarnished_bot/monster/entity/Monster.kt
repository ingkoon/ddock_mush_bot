package com.eldenring.tarnished_bot.monster.entity

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor
import javax.persistence.*


@Entity
@Getter
@Builder
@NoArgsConstructor
@Table(name = "tb_monster")
class Monster(
    @Column(name = "name", nullable = false, length = 30)
    var name: String,
    @Column(name = "level", nullable = false)
    var level: Int,
    @Column(name = "hp", nullable = false)
    var hp: Int,
    @Column(name = "mp", nullable = false)
    var mp: Int,
    @Column(name = "exp", nullable = false)
    var exp: Int,
    @Column(name = "max_meso", nullable = false)
    var maxMeso: Int,
    @Column(name = "min_meso", nullable = false)
    var minMeso: Int,
    @Column(name = "def", nullable = false)
    var def: Int,
    @Column(name = "mr", nullable = false)
    var mr: Int,
    @Column(name = "agi", nullable = false)
    var agi: Int,
    @Column(name = "req_hit", nullable = false)
    var reqHit: Int,
    @Column(name = "respawn", nullable = false, length = 1024)
    var respawn: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monster_id", nullable = false, unique = true)
    private val id: Long = 0
}