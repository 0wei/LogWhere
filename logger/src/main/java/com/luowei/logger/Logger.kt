package com.luowei.logger

import android.util.Log

private val FILE_NAME = Thread.currentThread().stackTrace[2].fileName

private fun buildMessage(className: String, msg: Array<out String>): Pair<String, String> {
    fun location(simpleName: String): String {
        var offset = 0
        val stackTrace = Thread.currentThread().stackTrace
        while (stackTrace[offset].fileName != FILE_NAME) offset++
        while (stackTrace[offset].fileName == FILE_NAME) offset++
        val stackTraceElement = stackTrace[offset]
        val clazz = if (simpleName == stackTraceElement.fileName.substringBefore(".")) "" else "$simpleName#"
        return "(${stackTraceElement.fileName}:${stackTraceElement.lineNumber})[$clazz${stackTraceElement.methodName}]"
    }

    val location = location(className)
    val tag = location
    val txt =  msg.joinToString(":")
    return Pair(tag, txt)
}

fun Any.logDebug(vararg msg: String) {
    val (tag, txt) = buildMessage(javaClass.simpleName, msg)
    Log.d(tag, txt)
}

fun Any.logInfo(vararg msg: String) {
    val (tag, txt) = buildMessage(javaClass.simpleName, msg)
    Log.i(tag, txt)
}

fun Any.logWarn(vararg msg: String) {
    val (tag, txt) = buildMessage(javaClass.simpleName, msg)
    Log.w(tag, txt)
}

fun Any.logError(vararg msg: String) {
    val (tag, txt) = buildMessage(javaClass.simpleName, msg)
    Log.e(tag, txt)
}