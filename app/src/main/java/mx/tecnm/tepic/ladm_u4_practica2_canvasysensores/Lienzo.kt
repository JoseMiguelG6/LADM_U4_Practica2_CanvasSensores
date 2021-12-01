package mx.tecnm.tepic.ladm_u4_practica2_canvasysensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo (p:MainActivity): View(p) {
    var carro = BitmapFactory.decodeResource(this.resources, R.drawable.carro)

    var posX = 300f
    var fondo = 0

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        c.drawColor(fondo)

        //Nube Izquierda
        p.color = Color.WHITE
        c.drawCircle(400f, 275f, 100f, p)
        c.drawCircle(600f, 250f, 100f, p)
        c.drawCircle(500f, 300f, 100f, p)
        c.drawCircle(410f, 200f, 100f, p)
        c.drawCircle(590f, 200f, 100f, p)
        c.drawCircle(500f, 150f, 100f, p)

        //Nube Derecha
        p.color = Color.WHITE
        c.drawCircle(700f, 375f, 100f, p)
        c.drawCircle(900f, 350f, 100f, p)
        c.drawCircle(800f, 400f, 100f, p)
        c.drawCircle(710f, 300f, 100f, p)
        c.drawCircle(890f, 300f, 100f, p)
        c.drawCircle(800f, 250f, 100f, p)

        //Calle
        p.color = Color.GRAY
        c.drawRect(10f,1300f,1060f,1050f,p)
        p.style = Paint.Style.FILL_AND_STROKE
        p.strokeWidth = 20f
        p.color = Color.YELLOW
        c.drawRect(50f,1180f,1020f,1182f,p)
        p.style = Paint.Style.FILL_AND_STROKE
        p.strokeWidth = 20f

        //carro
        c.drawBitmap(carro, posX, 900f, p)
    }
}