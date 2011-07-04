package glmf.gradle

import akka.actor.Actor

class GreetingActor extends Actor {
    def receive = {
        case msg => {
            self.reply("Hello, " + msg + "!")
        }
    }
}
