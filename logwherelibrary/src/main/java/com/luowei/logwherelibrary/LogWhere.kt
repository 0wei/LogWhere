package com.luowei.logwherelibrary

import android.util.Log

fun Any.logd(vararg msg: String) {
    Log.d(location(javaClass.simpleName), msg.joinToString(":"))
}

fun Any.logi(vararg msg: String) {
    Log.i(location(javaClass.simpleName), msg.joinToString(":"))
}

fun Any.logw(vararg msg: String) {
    Log.w(location(javaClass.simpleName), msg.joinToString(":"))
}

fun Any.loge(vararg msg: String) {
    Log.e(location(javaClass.simpleName), msg.joinToString(":"))
}

private fun location(simpleName: String): String {
    val stackTraceElement = Thread.currentThread().stackTrace[4]
    val clazz = if (simpleName == stackTraceElement.fileName.substringBefore(".")) "" else "$simpleName#"
    return "(${stackTraceElement.fileName}:${stackTraceElement.lineNumber})[$clazz${stackTraceElement.methodName}]"
}
