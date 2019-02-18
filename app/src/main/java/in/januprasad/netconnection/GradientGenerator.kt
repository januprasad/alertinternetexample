package `in`.januprasad.netconnection


import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * Created by januprasad on 18,February,2019
 */


object GradientGenerator {
    fun make(radius: Float, @ColorRes startColor: Int, @ColorRes endColor: Int): Drawable {
        val gd = GradientDrawable(GradientDrawable.Orientation.TL_BR,
                intArrayOf(ContextCompat.getColor(App.instance.applicationContext, startColor),
                        ContextCompat.getColor(App.instance.baseContext, endColor)))
        gd.cornerRadius = radius
        return gd
    }

    fun random(): Drawable {
        val colorList = listOf(
                R.color.Amber_600, R.color.Amber_700, R.color.Amber_800,
                R.color.Amber_900, R.color.Amber_A400, R.color.Amber_A700,

                R.color.Orange_600, R.color.Orange_700, R.color.Orange_800,
                R.color.Orange_900, R.color.Orange_A400, R.color.Orange_A700,

                R.color.DeepOrange_700)

        val gd = GradientDrawable(GradientDrawable.Orientation.TL_BR,
                intArrayOf(ContextCompat.getColor(App.instance.applicationContext, colorList.random()),
                        ContextCompat.getColor(App.instance.baseContext, colorList.random())))
        gd.cornerRadius = 0F
        return gd
    }

    val errorGradient: Drawable
        get() {
            val gd = GradientDrawable(GradientDrawable.Orientation.TL_BR,
                    intArrayOf(ContextCompat.getColor(App.instance.applicationContext, R.color.Red_400),
                            ContextCompat.getColor(App.instance.baseContext, R.color.Red_A700)))
            gd.cornerRadius = 0F
            return gd
        }


    val appThemeGradient: Drawable
        get() {
            val gd = GradientDrawable(GradientDrawable.Orientation.TL_BR,
                    intArrayOf(ContextCompat.getColor(App.instance.applicationContext, R.color.Yellow_700),
                            ContextCompat.getColor(App.instance.baseContext, R.color.Amber_900)))
            gd.cornerRadius = 0F
            return gd
        }

    val successGradient: Drawable
        get() {
            val gd = GradientDrawable(GradientDrawable.Orientation.TL_BR,
                    intArrayOf(ContextCompat.getColor(App.instance.applicationContext, R.color.Green_A400),
                            ContextCompat.getColor(App.instance.baseContext, R.color.Teal_A700)))
            gd.cornerRadius = 0F
            return gd
        }
}