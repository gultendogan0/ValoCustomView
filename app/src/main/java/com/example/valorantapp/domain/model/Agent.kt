package com.example.valorantapp.domain.model

data class Agent(
    val abilities: List<Ability>? = null,
    val assetPath: String? = null,
    val background: String? = null,
    val backgroundGradientColors: List<String>? = null,
    val bustPortrait: String? = null,
    val characterTags: List<String>? = null,
    val description: String? = null,
    val developerName: String? = null,
    val displayIcon: String? = null,
    val displayIconSmall: String? = null,
    val displayName: String? = null,
    val fullPortrait: String? = null,
    val fullPortraitV2: String? = null,
    val isAvailableForTest: Boolean? = null,
    val isBaseContent: Boolean? = null,
    val isFullPortraitRightFacing: Boolean? = null,
    val isPlayableCharacter: Boolean? = null,
    val killfeedPortrait: String? = null,
    val role: Role? = null,
    val uuid: String? = null,
    val voiceLine: VoiceLine? = null
)