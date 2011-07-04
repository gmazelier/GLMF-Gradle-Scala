package glmf.gradle

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{WordSpec, BeforeAndAfterAll}
import akka.actor.Actor._
import akka.util.duration._
import akka.testkit.TestKit
import akka.actor.{ActorRef, Actor}

@RunWith(classOf[JUnitRunner])
class GreetingActorSpec extends WordSpec
        with BeforeAndAfterAll with ShouldMatchers with TestKit {
    val greetingRef = actorOf(new GreetingActor).start

    override protected def afterAll(): scala.Unit = {
        stopTestActor
        greetingRef.stop
    }

    "A GreetingActor" should {
        "respond with 'Hello' and the same message it receives" in {
            within(100 millis) {
                greetingRef ! "test"
                expectMsg("Hello, test!")
            }
        }
    }

}
