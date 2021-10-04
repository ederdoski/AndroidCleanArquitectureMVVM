package com.adrena.basearchitect.core.analytics

interface IBaseAnalytics {
    fun trackScreen()
    fun trackError(typeEnum: AnalyticsErrorEventTypeEnum, detail: String?, code: String, className: String?)
    fun trackEvent(actionType: AnalyticsEventsPrefixEnum, actionName: String)
}