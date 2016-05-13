import org.scalatestplus.play.{OneServerPerSuite, PlaySpec}
import play.api.libs.ws._
import play.mvc.Http.Status._

class APISpec extends PlaySpec with OneServerPerSuite {

	implicit val ws = app.injector.instanceOf[WSClient]

	val baseURL: String = s"http://localhost:$port/api/"

	val channelID: String = "UCboMX_UNgaPBsUOIgasn3-Q"

	"API" must {

		//TODO better define tests

		"return a random video on /api/getRandomVideo/:channelID" in {
			Util.getResponse(baseURL + "getRandomVideo/" + channelID) { res =>
				res.status mustBe OK
				assert(!res.body.isEmpty)
			}
		}

		"return a random video on /api/getRandomPlaylist/:channelID" in {
			Util.getResponse(baseURL + "getRandomPlaylist/" + channelID) { res =>
				res.status mustBe OK
				assert(!res.body.isEmpty)
			}
		}

		"return a random queue on /api/getQueue/:channelID?filters=all" in {
			Util.getResponse(baseURL + "getQueue/" + channelID + "?filters=all") { res =>
				res.status mustBe OK
				assert(!res.body.isEmpty)
			}
		}

	}
}
