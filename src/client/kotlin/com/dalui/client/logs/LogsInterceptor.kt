package com.dalui.client.logs

import org.apache.logging.log4j.core.Filter
import org.apache.logging.log4j.core.Layout
import org.apache.logging.log4j.core.LogEvent
import org.apache.logging.log4j.core.appender.AbstractAppender
import java.io.Serializable

class LogsInterceptor(
    name: String,
    filter: Filter?,
    layout: Layout<out Serializable>?
): AbstractAppender(name,filter,layout,true,null) {
    override fun append(event: LogEvent?) {
        if (event == null) return

        val message = event.message.formattedMessage
        TODO("Implementar armazenamento de logs quando preciso")

    }
}