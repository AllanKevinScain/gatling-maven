package com.gatling.tests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ComputedDatabase2 extends Simulation {

	val httpProtocol = http
		.baseUrl("https://reqres.in")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.disableAutoReferer

	val headers_1 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6",
		"referer" -> "https://reqres.in/",
		"sec-ch-ua" -> """Google Chrome";v="105", "Not)A;Brand";v="8", "Chromium";v="105""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows",
		"sec-fetch-dest" -> "script",
		"sec-fetch-mode" -> "no-cors",
		"sec-fetch-site" -> "cross-site",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36")

	val scn = scenario("ComputedDatabase2")
		.exec(http("request_0")
			.get("/api/users?page=2")
			.headers(headers_1))
			.pause(1)
		.exec(http("request_4")
			.post("/api/users")
			.body(RawFileBody("com/gatling/tests/computeddatabase2/0004_request.json"))
			.headers(headers_1))
			.pause(2)
		.exec(http("request_6")
			.put("/api/users/2")
			.body(RawFileBody("com/gatling/tests/computeddatabase2/0006_request.json"))
			.headers(headers_1))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}