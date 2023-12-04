package org.acme

import io.quarkus.runtime.Startup
import io.quarkus.runtime.annotations.RegisterForReflection
import jakarta.enterprise.context.ApplicationScoped
import org.jobrunr.scheduling.JobScheduler

@RegisterForReflection(lambdaCapturingTypes = ["org.acme.MyService"])
@ApplicationScoped
class MyService(
    private val jobScheduler: JobScheduler
) {

    @Startup
    fun runOnStartup() {
        jobScheduler.enqueue { myMethod() }
    }

    fun myMethod() {
        throw RuntimeException()
    }
}
