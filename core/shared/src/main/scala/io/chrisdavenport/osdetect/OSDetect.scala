package io.chrisdavenport.osdetect

import cats.syntax.all._
import cats.effect._

trait OSDetect[F[_]]{


  def detect: F[OperatingSystem]

  def osType: F[OSType]
  def arch: F[Arch]

  def rawName: F[String]
  def rawVersion: F[String]
  def rawArch: F[String]
}


object OSDetect extends OSDetectCompanionPlatform {

  def impl[F[_]: Sync]: OSDetect[F] = new OSDetect[F] {

    def detect: F[OperatingSystem] = (rawName, rawVersion, rawArch).mapN(OperatingSystem.fromStrings)

    def rawName: F[String] = getRawOS[F]
    def osType: F[OSType] = rawName.map(OSType.fromString)

    def rawVersion: F[String] = getRawVersion[F]

    def rawArch: F[String] = getRawArch[F]
    def arch: F[Arch] = rawArch.map(Arch.fromString)
  }
}
