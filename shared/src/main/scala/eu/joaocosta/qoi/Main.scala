package eu.joaocosta.qoi

import eu.joaocosta.minart.graphics._
import eu.joaocosta.minart.graphics.pure._
import eu.joaocosta.minart.runtime._
import eu.joaocosta.minart.runtime.pure._

object Main {
  def main(args: Array[String]): Unit = {
    val image =
      Resource(args.head).withInputStream(is => Qoi.loadImage(is).left.map(msg => new Exception(msg)).toTry).flatten.get
    val canvasSettings = Canvas.Settings(width = image.width, height = image.height, scale = 1)
    PureRenderLoop.singleFrame(CanvasIO.blit(image)(0, 0).andThen(CanvasIO.redraw))(canvasSettings)
  }
}
