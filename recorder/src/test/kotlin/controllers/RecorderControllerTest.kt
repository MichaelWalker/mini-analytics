package controllers

import com.github.kittinunf.fuel.httpPut
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import spark.Spark.awaitInitialization
import spark.Spark.stop

object RecorderControllerTest : Spek({

    given("a Recorder Controller") {

        beforeGroup {
            val recorderController = RecorderController()
            recorderController.createRoutes()
            awaitInitialization()
        }

        on("receiving a page hit request") {
            val response = "http://localhost:4567/pageHit".httpPut()

            it("returns an 'accepted' status code") {
                assertThat(response.response().second.statusCode).isEqualTo(202)
            }
        }

        afterGroup {
            stop()
        }
    }
})