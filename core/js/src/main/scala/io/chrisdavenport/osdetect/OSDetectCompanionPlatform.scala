package io.chrisdavenport.osdetect

import cats.syntax.all._
import cats.effect._
import scala.util.Try
import scala.scalajs.js



private[osdetect] trait OSDetectCompanionPlatform {
  private[this] val osT = Try(js.Dynamic.global.require("os"))

  def getRawOS[F[_]: Sync]: F[String] = {
    Sync[F].defer(platformOS.liftTo[F])
  }

  private[this] def platformOS: Try[String] = {
    osT.flatMap(os => Try(os.platform().asInstanceOf[String]))
  }

  def getRawArch[F[_]: Sync]: F[String] = {
    Sync[F].defer(platformArch.liftTo[F])
  }

  private[this] def platformArch: Try[String] = {
    osT.flatMap(os => Try(os.arch().asInstanceOf[String]))
  }

  def getRawVersion[F[_]: Sync]: F[String] = {
    Sync[F].defer(platformVersion.liftTo[F])
  }

  private[this] def platformVersion: Try[String] = {
    osT.flatMap(os => Try(os.version().asInstanceOf[String]))
  }
}