package com.mipke.starter.common.service

import com.mipke.starter.jobs.JobService
import org.springframework.stereotype.Component

@Component
class ServiceCoordinator(
    val jobService: JobService
)
