package com.adrena.basearchitect.core.analytics

import android.os.Bundle

class AnalyticsBundleBuilder {
    
    var bundle: Bundle = Bundle()

    fun addCategory(appCategory: String): AnalyticsBundleBuilder {
        bundle.putString(APP_CATEGORY, appCategory)
        return this
    }

    fun addSubCategory(appSubcategory: String): AnalyticsBundleBuilder {
        bundle.putString(APP_SUBCATEGORY, appSubcategory)
        return this
    }

    fun addAppScreenName(screenName: String): AnalyticsBundleBuilder {
        bundle.putString(APP_SCREEN_NAME, screenName)
        return this
    }

    fun addActionName(appActionName: String): AnalyticsBundleBuilder {
        bundle.putString(APP_ACTION_NAME, appActionName)
        return this
    }

    fun addErrorDetail(errorDetail: String): AnalyticsBundleBuilder {
        bundle.putString(APP_ERROR_DETAIL, errorDetail)
        return this
    }

    fun addErrorLabelName(errorLabelName: String): AnalyticsBundleBuilder {
        bundle.putString(ERROR_LABEL_NAME, errorLabelName)
        return this
    }

    fun addErrorType(errorType: String): AnalyticsBundleBuilder {
        bundle.putString(ERROR_TYPE, errorType)
        return this
    }

    fun addStatus(status: String): AnalyticsBundleBuilder {
        bundle.putString(APP_STATUS, status)
        return this
    }

    fun addErrorCode(errorCode: String): AnalyticsBundleBuilder {
        bundle.putString(ERROR_CODE, errorCode)
        return this
    }

    fun addClassName(className: String): AnalyticsBundleBuilder {
        bundle.putString(APP_CLASS_NAME, className)
        return this
    }
}