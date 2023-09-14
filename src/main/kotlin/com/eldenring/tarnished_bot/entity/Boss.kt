package com.eldenring.tarnished_bot.entity

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Boss(
    private var id: String,
    private var name: String,
    private var image: String,
    private var description: String?,
    private var location: String?,
    private var drops: List<String>,
    private var healthPoints: String?
) {

    override fun toString(): String {
        return "id: $id \n" +
                "이름: $name \n" +
                "$image \n"+
                "설명: $description \n" +
                "출몰 장소: $location \n" +
                "드랍 아이템: $drops \n " +
                "체력: $healthPoints"
    }
}