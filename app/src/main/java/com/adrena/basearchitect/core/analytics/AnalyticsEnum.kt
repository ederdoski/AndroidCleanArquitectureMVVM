package com.adrena.basearchitect.core.analytics

enum class AnalyticsEventsPrefixEnum(val value: String){
    SCREEN("screen"),
    BUTTON("buttom"),
    CHECK("check"),
    LINK("link")
}

enum class AnalyticsErrorEventTypeEnum(val value: String){
    GENERIC("back-end-genericos"),
    FRONT("front-end"),
    BACKEND("back-end")
}