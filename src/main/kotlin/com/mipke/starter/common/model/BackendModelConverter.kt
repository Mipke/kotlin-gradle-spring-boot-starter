package com.mipke.starter.common.model

import com.mipke.starter.common.service.ServiceCoordinatorConsumer


abstract class BackendModelConverter<T, V> : ServiceCoordinatorConsumer() {

    abstract fun toData(model: T): V
}
