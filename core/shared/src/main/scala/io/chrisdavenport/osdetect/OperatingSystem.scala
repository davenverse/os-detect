package io.chrisdavenport.osdetect

case class OperatingSystem(osType: OSType, version: String, arch: Arch)

object OperatingSystem {

  def fromStrings(name: String, version: String, archS: String): OperatingSystem = {
    val ostype = OSType.fromString(name)
    val arch = Arch.fromString(archS)
    OperatingSystem(ostype, version, arch)
  }


}