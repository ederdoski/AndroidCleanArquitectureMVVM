package com.adrena.basearchitect.features.flows.users.analytics

import com.adrena.basearchitect.core.analytics.BaseAnalytics

class UsersAnalytics : BaseAnalytics {

    companion object {
        private const val APP_SCREEN_NAME = ""
        private const val APP_CATEGORY_NAME = ""
        private const val APP_SUBCATEGORY_NAME = ""
    }

    constructor() : this(
    appScreenName = APP_SCREEN_NAME,
    appCategory = APP_CATEGORY_NAME,
    appSubcategory = APP_SUBCATEGORY_NAME
    )

    private constructor(
            appScreenName: String,
            appCategory: String,
            appSubcategory: String
    ) : super(appScreenName, appCategory, appSubcategory)


    // ----------------------------- Actions events -----------------------------

    fun trackSomeEvent(){
        //trackEvent(actionType = AnalyticsEventsPrefixEnum.BUTTON, actionName = "press_on_btn")
    }
}