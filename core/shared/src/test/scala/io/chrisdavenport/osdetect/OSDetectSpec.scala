package io.chrisdavenport.osdetect

import munit.CatsEffectSuite
import cats.effect._

class OSDetectSpec extends CatsEffectSuite {

  test("Should pull the current operating system succesfully") {
    OSDetect.impl[IO].detect.attempt.map(e => 
      assertEquals(e.isRight, true, "Detecting Operating System Failed")
    )
  }

}
