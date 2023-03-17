package com.coka.base_mvp.Utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.SharedPreferences


@Suppress("UNCHECKED_CAST")
class PreferenceUtils private constructor() {
    operator fun <T> get(key: String?, anonymousClass: Class<T>): T? {
        if (anonymousClass == String::class.java) {
            return mSharedPreferences.getString(key, "") as T
        } else if (anonymousClass == Boolean::class.java) {
            return java.lang.Boolean.valueOf(mSharedPreferences.getBoolean(key, false)) as T
        } else if (anonymousClass == Float::class.java) {
            return java.lang.Float.valueOf(mSharedPreferences.getFloat(key, 0f)) as T
        } else if (anonymousClass == Int::class.java) {
            return Integer.valueOf(mSharedPreferences!!.getInt(key, 0)) as T
        } else if (anonymousClass == Long::class.java) {
            return java.lang.Long.valueOf(mSharedPreferences!!.getLong(key, 0)) as T
        }

        return null
    }

    @SuppressLint("CommitPrefEdits")
    fun <T> put(key: String?, data: T) {
        val editor = mSharedPreferences.edit()
        when (data) {
            is String -> {
                editor.putString(key, data)
            }
            is Boolean -> {
                editor.putBoolean(key, (data as Boolean))
            }
            is Float -> {
                editor.putFloat(key, (data as Float))
            }
            is Int -> {
                editor.putInt(key, (data as Int))
            }
            is Long -> {
                editor.putLong(key, (data as Long))
            }
        }
        editor.apply()
    }

    fun clear() {
        mSharedPreferences.edit().clear().apply()
    }

    companion object {
        private lateinit var mSharedPreferences: SharedPreferences
        @SuppressLint("StaticFieldLeak")
        var mInstance: PreferenceUtils? = null
        @SuppressLint("StaticFieldLeak")
        var mContext: Context? = null
        val instance: PreferenceUtils
            get() {
                if (mContext == null) {
                    throw (Throwable("Preference not init ->need init"))
                }
                if (mInstance == null) {
                    mInstance = PreferenceUtils()
                }
                return mInstance as PreferenceUtils
            }

        fun initPreference(context: Context, prefName: String) {
            mContext = context
            mSharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

        }
    }

}