package io.chrisdavenport.osdetect

sealed trait OSType
object OSType {
  case object Linux extends OSType
  case object OSX extends OSType
  case object Windows extends OSType
  case object Solaris extends OSType
  case class Unknown(name: String) extends OSType



  /* JS
    'aix'
    'darwin'
    'freebsd'
    'linux'
    'openbsd'
    'sunos'
    'win32'
    'android'
  */

  def fromString(name: String): OSType =  {
    name.toLowerCase match {
      // Linux, Unix, Aix
      case linux if linux.contains("nux") || linux.contains("nix") || linux.contains("aix") => Linux
      case mac if mac.contains("mac") || mac.contains("darwin")  => OSX
      case windows if windows.contains("win") => Windows
      case solaris if solaris.contains("sunos") => Solaris
      case _ => Unknown(name)
    }
  }
}