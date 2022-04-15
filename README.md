# Scala QOI Image Viewer

*Archived:* This project has been ported to [`minart-image`](https://github.com/JD557/minart), where it will continue to receive updates.

A toy implementation of the [QOI Image format](https://qoiformat.org/) in pure Scala, cross-compiling for JVM and Scala Native.

Example images from [QOIView](https://github.com/floooh/qoiview).

Sample Usage:

`sbt "rootJVM/run images/baboon.qoi"`

or

`sbt "rootNative/run images/baboon.qoi"`
