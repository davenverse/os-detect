package io.chrisdavenport.osdetect

import cats.effect._

private[osdetect] trait OSDetectCompanionPlatform {
  def getRawOS[F[_]: Sync]: F[String] = {
    Sync[F].delay(System.getProperty("os.name"))
  }

  def getRawVersion[F[_]: Sync]: F[String] = {
    Sync[F].delay(System.getProperty("os.version"))
  }

  def getRawArch[F[_]: Sync]: F[String] = {
    Sync[F].delay(System.getProperty("os.arch"))
  }
}