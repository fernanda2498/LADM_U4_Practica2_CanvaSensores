package tecnm.mx.tepic.ladm_u4_practica2_canvassensores

import android.graphics.*
import android.view.View

class Lienzo (p:MainActivity):View(p){
    var cx = 100f
    var cy = 40f
    var fondo = true
    //imagenes
    val sol : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.dom)
    val nube : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.nubes)
    val luna : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.luna)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var paint = Paint()

        //fondo
        if (fondo){
            //DIA
            canvas.drawColor(Color.BLUE)
            canvas.drawBitmap(sol, 50f, 50f, paint)
            canvas.drawBitmap(nube,cx,cy,paint)
            canvas.drawBitmap(nube,cx+400, cy+100, paint)
            canvas.drawBitmap(nube,cx+800, cy, paint)

        }else{
            //NOCHE
            canvas.drawColor(Color.BLACK)
            canvas.drawBitmap(luna, 300f, 700f, paint)

        }

    }

}