package com.mipke.starter.common.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "starter.config")
class StarterConfig {
    var someProperty: String = ""
}
