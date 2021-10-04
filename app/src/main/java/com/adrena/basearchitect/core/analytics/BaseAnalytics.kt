package com.adrena.basearchitect.core.analytics

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.FirebaseAnalytics.Event.SCREEN_VIEW
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import java.util.*

open class BaseAnalytics (
    private val appScreenName: String,
    private val appCategory: String,
    private val appSubcategory: String
) : IBaseAnalytics {

    private var mFirebaseAnalytics: FirebaseAnalytics = Firebase.analytics

    override fun trackScreen() {
        val screenName = formatScreenName(screenName = appScreenName)
        val bundleBuilder = AnalyticsBundleBuilder()
            .addAppScreenName(screenName)
        mFirebaseAnalytics.logEvent(SCREEN_VIEW, bundleBuilder.bundle)
    }

    override fun trackEvent(actionType: AnalyticsEventsPrefixEnum, actionName: String) {
        val bundleBuilder = AnalyticsBundleBuilder()
            .addAppScreenName(formatScreenName(appScreenName))
            .addActionName(formatEventName(actionType, appScreenName, actionName))
            .addCategory(appCategory)
            .addSubCategory(appSubcategory)
        mFirebaseAnalytics.logEvent(APP_ACTION_EVENT, bundleBuilder.bundle)
    }

    override fun trackError(typeEnum: AnalyticsErrorEventTypeEnum, detail: String?, code: String, className: String?) {
        val screenName = formatScreenName(screenName = appScreenName)
        val bundleBuilder = AnalyticsBundleBuilder()
            .addAppScreenName(screenName)
            .addErrorType(errorType = typeEnum.value)

        detail?.let {
            if (it.isNotEmpty()) {
                bundleBuilder.addErrorDetail(it)
            }
        }

        code.let {
            if (it.isNotEmpty()) {
                bundleBuilder.addErrorCode(it)
            }
        }

        className?.let {
            if (it.isNotEmpty()) {
                bundleBuilder.addClassName(it)
            }
        }

        mFirebaseAnalytics.logEvent(ERROR_EVENT, bundleBuilder.bundle)
    }

    private fun formatScreenName(screenName: String): String {
        return AnalyticsEventsPrefixEnum.SCREEN.value + "_" + screenName
    }

    private fun formatEventName(
        prefixEnum: AnalyticsEventsPrefixEnum,
        screenName: String,
        actionName: String
    ): String {
        return prefixEnum.value + "_" + screenName + "_" + actionName
    }

}