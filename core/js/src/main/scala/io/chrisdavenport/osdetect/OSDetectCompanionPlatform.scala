package io.chrisdavenport.osdetect

import cats.syntax.all._
import cats.effect._
import scala.util.Try
import scala.scalajs.js



private[osdetect] trait OSDetectCompanionPlatform {
  private[this] val os = js.Dynamic.global.require("os")

  def getRawOS[F[_]: Sync]: F[String] = {
    Sync[F].defer(platformOS.liftTo[F])
  }

  private[this] def platformOS: Try[String] = {
    Try(os.platform().asInstanceOf[String])
  }

  def getRawArch[F[_]: Sync]: F[String] = {
    Sync[F].defer(platformArch.liftTo[F])
  }

  private[this] def platformArch: Try[String] = {
    Try(os.arch().asInstanceOf[String])
  }

  def getRawVersion[F[_]: Sync]: F[String] = {
    Sync[F].defer(platformVersion.liftTo[F])
  }

  private[this] def platformVersion: Try[String] = {
    Try(os.version().asInstanceOf[String])
  }
}