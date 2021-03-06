package views

import model.MessageConstants.{EnglishMessageConstants, WelshMessageConstants}
import model.{JourneyConfigDefaults, JourneyConfigV2, JourneyDataV2, JourneyOptions}
import org.jsoup.Jsoup
import play.api.i18n.Messages.Implicits._
import play.api.i18n.MessagesApi
import play.api.mvc.AnyContentAsEmpty
import play.api.test.FakeRequest
import play.twirl.api.Html
import utils.TestConstants._

class TooManyResultsViewSpec extends ViewSpec {
  implicit val testRequest: FakeRequest[AnyContentAsEmpty.type] = FakeRequest()
  implicit val messages = app.injector.instanceOf[MessagesApi]

  val testHtml = Html("")

  object tooManyResultsMessages {
    val title = "No results found"
    val heading1 = "There are too many results"
    val heading2 = "We couldn't find any results for that property name or number"

    def bullet1(postcode: String) = s"$postcode for postcode"

    val bullet2NoFilter = "nothing for property name or number"

    def bullet2WithFilter(filter: String) = s"'$filter' for name or number"

    val line1 = "You entered:"
    val button = "Try a new search"
    val back = "Back"
  }

  object welshTooManyResultsMessages {
    val title = "Dim canlyniadau wedi’u darganfod"
    val heading1 = "Mae yna ormod o ganlyniadau"
    val heading2 = "Ni allem ddod o hyd i unrhyw ganlyniadau ar gyfer enw neu rif yr eiddo hwnnw"

    def bullet1(postcode: String) = s"$postcode am y cod post"

    val bullet2NoFilter = "ddim byd ar gyfer enw neu rif eiddo"

    def bullet2WithFilter(filter: String) = s"'$filter' ar gyfer enw neu rif"

    val line1 = "Nodoch:"
    val button = "Rhowch gynnig ar chwiliad newydd"
    val back = "Yn ôl"
  }

  def journeyData(showBackButtons: Boolean) = JourneyDataV2(
    JourneyConfigV2(
      2,
      JourneyOptions(
        continueUrl = testContinueUrl,
        showBackButtons = Some(showBackButtons)
      )
    )
  )

  "The English 'Too Many Results' page" should {
    "be rendered" when {
      "the back buttons are enabled in the journey config" when {
        "no filter has been entered" when {
          "there are too many addresses" in {
            val doc = Jsoup.parse(views.html.v2.too_many_results(
              id = testJourneyId,
              journeyData = journeyData(showBackButtons = true),
              lookup = model.Lookup(
                None,
                testPostCode
              ),
              firstLookup = true,
              isWelsh = false
            ).body)

            doc.getBackLinkText shouldBe tooManyResultsMessages.back
            doc.title shouldBe tooManyResultsMessages.title
            doc.getH1ElementAsText shouldBe tooManyResultsMessages.heading1
            doc.paras.get(1).text shouldBe tooManyResultsMessages.line1
            doc.bulletPointList.select("li").first.text shouldBe tooManyResultsMessages.bullet1(testPostCode)
            doc.bulletPointList.select("li").last.text shouldBe tooManyResultsMessages.bullet2NoFilter
            doc.getButtonContentAsText shouldBe tooManyResultsMessages.button
            doc.getALinkText("enterManual") shouldBe JourneyConfigDefaults.EnglishConstants.EDIT_LINK_TEXT
          }
        }

        "a filter has been entered" when {
          "there are too many addresses" in {
            val doc = Jsoup.parse(views.html.v2.too_many_results(
              id = testJourneyId,
              journeyData = journeyData(showBackButtons = true),
              lookup = model.Lookup(
                Some(testFilterValue),
                testPostCode
              ),
              firstLookup = false,
              isWelsh = false
            ).body)

            doc.getBackLinkText shouldBe tooManyResultsMessages.back
            doc.title shouldBe tooManyResultsMessages.title
            doc.getH1ElementAsText shouldBe tooManyResultsMessages.heading2
            doc.paras.get(1).text shouldBe tooManyResultsMessages.line1
            doc.bulletPointList.select("li").first.text shouldBe tooManyResultsMessages.bullet1(testPostCode)
            doc.bulletPointList.select("li").last.text shouldBe tooManyResultsMessages.bullet2WithFilter(testFilterValue)
            doc.getButtonContentAsText shouldBe tooManyResultsMessages.button
            doc.getALinkText("enterManual") shouldBe JourneyConfigDefaults.EnglishConstants.EDIT_LINK_TEXT
          }
        }
      }

      "the back buttons are not enabled in the journey config" when {
        "no filter has been entered" when {
          "there are too many addresses" in {
            val doc = Jsoup.parse(views.html.v2.too_many_results(
              id = testJourneyId,
              journeyData = journeyData(showBackButtons = false),
              lookup = model.Lookup(
                None,
                testPostCode
              ),
              firstLookup = true,
              isWelsh = false
            ).body)

            doc.getBackLinkText shouldBe empty
            doc.title shouldBe tooManyResultsMessages.title
            doc.getH1ElementAsText shouldBe tooManyResultsMessages.heading1
            doc.paras.get(1).text shouldBe tooManyResultsMessages.line1
            doc.bulletPointList.select("li").first.text shouldBe tooManyResultsMessages.bullet1(testPostCode)
            doc.bulletPointList.select("li").last.text shouldBe tooManyResultsMessages.bullet2NoFilter
            doc.getButtonContentAsText shouldBe tooManyResultsMessages.button
            doc.getALinkText("enterManual") shouldBe JourneyConfigDefaults.EnglishConstants.EDIT_LINK_TEXT
          }
        }

        "a filter has been entered" when {
          "there are too many addresses" in {
            val doc = Jsoup.parse(views.html.v2.too_many_results(
              id = testJourneyId,
              journeyData = journeyData(showBackButtons = false),
              lookup = model.Lookup(
                Some(testFilterValue),
                testPostCode
              ),
              firstLookup = false,
              isWelsh = false
            ).body)

            doc.getBackLinkText shouldBe empty
            doc.title shouldBe tooManyResultsMessages.title
            doc.getH1ElementAsText shouldBe tooManyResultsMessages.heading2
            doc.paras.get(1).text shouldBe tooManyResultsMessages.line1
            doc.bulletPointList.select("li").first.text shouldBe tooManyResultsMessages.bullet1(testPostCode)
            doc.bulletPointList.select("li").last.text shouldBe tooManyResultsMessages.bullet2WithFilter(testFilterValue)
            doc.getButtonContentAsText shouldBe tooManyResultsMessages.button
            doc.getALinkText("enterManual") shouldBe JourneyConfigDefaults.EnglishConstants.EDIT_LINK_TEXT
          }
        }
      }
    }
  }

  "The Welsh 'Too Many Results' page" should {
    "be rendered" when {
      "the back buttons are enabled in the journey config" when {
        "no filter has been entered" when {
          "there are too many addresses" in {
            val doc = Jsoup.parse(views.html.v2.too_many_results(
              id = testJourneyId,
              journeyData = journeyData(showBackButtons = true),
              lookup = model.Lookup(
                None,
                testPostCode
              ),
              firstLookup = true,
              isWelsh = true
            ).body)

            doc.getBackLinkText shouldBe welshTooManyResultsMessages.back
            doc.title shouldBe welshTooManyResultsMessages.title
            doc.getH1ElementAsText shouldBe welshTooManyResultsMessages.heading1
            doc.paras.get(1).text shouldBe welshTooManyResultsMessages.line1
            doc.bulletPointList.select("li").first.text shouldBe welshTooManyResultsMessages.bullet1(testPostCode)
            doc.bulletPointList.select("li").last.text shouldBe welshTooManyResultsMessages.bullet2NoFilter
            doc.getButtonContentAsText shouldBe welshTooManyResultsMessages.button
            doc.getALinkText("enterManual") shouldBe JourneyConfigDefaults.WelshConstants.EDIT_LINK_TEXT
          }
        }

        "a filter has been entered" when {
          "there are too many addresses" in {
            val doc = Jsoup.parse(views.html.v2.too_many_results(
              id = testJourneyId,
              journeyData = journeyData(showBackButtons = true),
              lookup = model.Lookup(
                Some(testFilterValue),
                testPostCode
              ),
              firstLookup = false,
              isWelsh = true
            ).body)

            doc.getBackLinkText shouldBe welshTooManyResultsMessages.back
            doc.title shouldBe welshTooManyResultsMessages.title
            doc.getH1ElementAsText shouldBe welshTooManyResultsMessages.heading2
            doc.paras.get(1).text shouldBe welshTooManyResultsMessages.line1
            doc.bulletPointList.select("li").first.text shouldBe welshTooManyResultsMessages.bullet1(testPostCode)
            doc.bulletPointList.select("li").last.text shouldBe welshTooManyResultsMessages.bullet2WithFilter(testFilterValue)
            doc.getButtonContentAsText shouldBe welshTooManyResultsMessages.button
            doc.getALinkText("enterManual") shouldBe JourneyConfigDefaults.WelshConstants.EDIT_LINK_TEXT
          }
        }
      }

      "the back buttons are not enabled in the journey config" when {
        "no filter has been entered" when {
          "there are too many addresses" in {
            val doc = Jsoup.parse(views.html.v2.too_many_results(
              id = testJourneyId,
              journeyData = journeyData(showBackButtons = false),
              lookup = model.Lookup(
                None,
                testPostCode
              ),
              firstLookup = true,
              isWelsh = true
            ).body)

            doc.getBackLinkText shouldBe empty
            doc.title shouldBe welshTooManyResultsMessages.title
            doc.getH1ElementAsText shouldBe welshTooManyResultsMessages.heading1
            doc.paras.get(1).text shouldBe welshTooManyResultsMessages.line1
            doc.bulletPointList.select("li").first.text shouldBe welshTooManyResultsMessages.bullet1(testPostCode)
            doc.bulletPointList.select("li").last.text shouldBe welshTooManyResultsMessages.bullet2NoFilter
            doc.getButtonContentAsText shouldBe welshTooManyResultsMessages.button
            doc.getALinkText("enterManual") shouldBe JourneyConfigDefaults.WelshConstants.EDIT_LINK_TEXT
          }
        }

        "a filter has been entered" when {
          "there are too many addresses" in {
            val doc = Jsoup.parse(views.html.v2.too_many_results(
              id = testJourneyId,
              journeyData = journeyData(showBackButtons = false),
              lookup = model.Lookup(
                Some(testFilterValue),
                testPostCode
              ),
              firstLookup = false,
              isWelsh = true
            ).body)

            doc.getBackLinkText shouldBe empty
            doc.title shouldBe welshTooManyResultsMessages.title
            doc.getH1ElementAsText shouldBe welshTooManyResultsMessages.heading2
            doc.paras.get(1).text shouldBe welshTooManyResultsMessages.line1
            doc.bulletPointList.select("li").first.text shouldBe welshTooManyResultsMessages.bullet1(testPostCode)
            doc.bulletPointList.select("li").last.text shouldBe welshTooManyResultsMessages.bullet2WithFilter(testFilterValue)
            doc.getButtonContentAsText shouldBe welshTooManyResultsMessages.button
            doc.getALinkText("enterManual") shouldBe JourneyConfigDefaults.WelshConstants.EDIT_LINK_TEXT
          }
        }
      }
    }
  }

}
