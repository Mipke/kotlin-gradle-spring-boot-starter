package com.mipke.starter.common.service

import com.mipke.starter.common.model.BackendModelConverter
import mu.KotlinLogging

abstract class BaseService<R, T>(
        protected val modelConverter: BackendModelConverter<R, T>
) : ServiceCoordinatorConsumer() {

    protected val logger by lazy { KotlinLogging.logger(this::class.java.name) }

    abstract val name: String
}
