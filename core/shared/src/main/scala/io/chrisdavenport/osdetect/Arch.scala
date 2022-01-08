package io.chrisdavenport.osdetect

sealed trait Arch
object Arch {
  // JS
  // 'arm', 'arm64', 'ia32', 'mips', 'mipsel', 'ppc', 'ppc64', 's390', 's390x', 'x32', and 'x64'.

  // JVM - Please help me find more of these
  // ia64, amd64, x86, unknown, arm, aarch64, 

  case object Arm extends Arch
  case object Arm64 extends Arch
  case object IA32 extends Arch
  case object MIPS extends Arch
  case object MIPSEL extends Arch
  case object PPC extends Arch
  case object PPC64 extends Arch
  case object S390 extends Arch
  case object S390X extends Arch

  case object AMD64 extends Arch // I picked one this is x64 on js
  case object X86 extends Arch // I picked on this is x32 on js
  case class Unknown(value: String) extends Arch

  def fromString(arch: String): Arch = arch.toLowerCase match {
    case "arm" => Arm
    case "arm64" | "aarch64" => Arm64
    case "ia32" => IA32
    case "mips" => MIPS
    case "mipsel" => MIPSEL
    case "ppc" => PPC
    case "ppc64" => PPC64
    case "s390" => S390
    case "s390x" => S390X
    case "x32" | "x86" => X86
    case "x64" | "amd64" => AMD64
    case _ => Unknown(arch)
  }

}