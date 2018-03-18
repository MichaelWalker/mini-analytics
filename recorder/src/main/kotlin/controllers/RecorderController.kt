package controllers

import spark.Response
import spark.Spark
import javax.servlet.http.HttpServletResponse

class RecorderController {

    fun createRoutes() {
        Spark.put("/pageHit") { _, response -> recordPageHit(response) }
    }

    private fun recordPageHit(response: Response): Response {
        response.status(HttpServletResponse.SC_ACCEPTED)
        return response
    }
}