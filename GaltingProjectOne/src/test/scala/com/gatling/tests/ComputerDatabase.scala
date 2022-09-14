package com.gatling.tests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ComputerDatabase extends Simulation {

	// Aqui ficam as configurações do gatling recorder, os protocolos
	val httpProtocol = http
		.baseUrl("https://computer-database.gatling.io")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36")

	// Aqui são os scenários de teste, Importante apagar os MAPS e os HEADERS
	// Podemos também alterar o nome das classes, dos requests
	val scn = scenario("ComputerDatabase")
		.exec(http("ComputerDatabasePage")
			.get("/computers"))
		.pause(7) //Esta é uma pausa, podemos aumentar ou dominuir ela
		.exec(http("NewComputerDatabase")
			.get("/computers/new"))
		.pause(48) //Esta é uma pausa, podemos aumentar ou dominuir ela
		.exec(http("CreateComputerDatabase")
			.post("/computers")
			.formParam("name", "MeyComputador1")
			.formParam("introduced", "2022-01-01")
			.formParam("discontinued", "2022-01-01")
			.formParam("company", "2")
			.check(status.is(400)))
		.pause(44) //Esta é uma pausa, podemos aumentar ou dominuir ela
		.exec(http("UpdateComputerDatabase")
			.post("/computers")
			.formParam("name", "MeyComputador1")
			.formParam("introduced", "2022-01-01")
			.formParam("discontinued", "2022-09-14")
			.formParam("company", "2"))
		.pause(15) //Esta é uma pausa, podemos aumentar ou dominuir ela
		.exec(http("FilterComputerDatabase")
			.get("/computers?f=MeuComputador1"))

	//A simulação acontece aqui
	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}