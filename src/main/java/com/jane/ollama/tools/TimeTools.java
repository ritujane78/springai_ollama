package com.jane.ollama.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.ZoneId;

@Component
public class TimeTools {
    private static Logger LOGGER = LoggerFactory.getLogger(TimeTools.class);
    @Tool(name = "getCurrentTime", description = "Get the current time anywhere around the world")
    public String getCurrentTime(@ToolParam(description = "Value representing thr time zone") String timeZone) {
        LOGGER.info("Returning the current time in the time zone {} ", timeZone);
        return LocalTime.now(ZoneId.of(timeZone)).toString();
    }
}
