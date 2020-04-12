package com.mipke.starter.common.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy

abstract class ServiceCoordinatorConsumer {

    @Autowired
    @Lazy
    protected lateinit var serviceCoordinator: ServiceCoordinator
        private set
}
