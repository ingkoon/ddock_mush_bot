package com.eldenring.tarnished_bot.enums

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class Bosses (val bossName: String, val bossId: String){
    BeastmanOfFarumAzula("파름아즈라의수인", "17f69d7fe72l0i1ultk418yedh25s7"),
    BellBearingHunter("방울사냥꾼", "17f69c4aacel0i1uluegh15idblimv"),
    BlackKnifeAssassin("검은칼날의자객", "17f69bd3c06l0i1ulx2jxbiogta1i"),
    BloodhoundKnightDarriwil("사냥개기사대리윌","17f69637e92l0i1um8wqsflgk3i9yr"),
    CrucibleKnight("도가니의기사","17f69a6fae3l0i1uq63au7m71cs8mh"),
    Deathbird("죽음의새","17f69e151d8l0i1uo19hl8r6l0snmo"),
    Demi_HumanChief("아인두목", "17f6961da46l0i1uoh7hemoben3dtg"),
    ErdtreeBurialWatchdog("환수의파수견", "17f697f48d5l0i1umdbu7v5phffgq"),
    FlyingDragonAgheel("비룡아길","17f69725115l0i1urx3t47u0gfs43"),
    GodricktheGrafted("접목의고드릭","17f6953f0d5l0i1uthl5j30bc50wdo"),
    GraftedScion("접목의귀공자","17f69bf253bl0i1uuma3733w2zwodm"),
    GraveWardenDuelist("묘지기투사", "17f699ad704l0i1uzmqfup4jxyto7"),
    GuardianGolem("가디언골렘", "17f69cbe6cbl0i1uvgek1x2hoimz99"),
    MadPumpkinHead("호박머리광병", "17f69a078e0l0i1uwdp4xqjq6cpbxl"),
//    Margit_theFellOmen("끔찍한흉조멀기트", ""),
    NightsCavalry("밤기병","17f69a6c3fcl0i1uyzw7a7ssn0qlpp"),
//    Patches("패치"),
    SoldierOfGodrick("고드릭의군병","17f6982dbf7l0i1v1r3i4p5cy7kvcs"),
//    StonediggerTroll("채석꾼트롤"),
    TibiaMariner("티비아의배","17f6968dcfal0i1v1y8dnaop27j5qg"),
    TreeSentinel("트리가드","17f6992d42bl0i1v2mmti9t0qkl5yj"),
    UlceratedTreeSpirit("문드러진나무령", "17f69cfaee3l0i1uzongoyxg1dptid");


    fun getName():String{
        return this.bossName
    }
    fun getId():String{
        return this.bossId
    }

    fun nameOf(name : String): String? {
        for (boss in Bosses.values()) {
            if(boss.getName()==name){
                return boss.getId()
            }
        }
        return null
    }
}