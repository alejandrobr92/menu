package alejandro.br.menu.Adapters

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso


class PromotionsAdapter(activity: Activity, promotions: MutableList<String>): BaseAdapter() {

    var promotions = promotions
    private val activity= activity

    override fun getCount(): Int {
        return promotions.size
    }

    override fun getItem(position: Int): Any {
        return promotions[position]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var promImage = ImageView(activity)
        Picasso.get().load(promotions[position]).into(promImage)
        promImage.scaleType= ImageView.ScaleType.CENTER_CROP

        // Get screen size
        val metrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(metrics)

        val height = metrics.densityDpi
        val width = metrics.widthPixels

        promImage.layoutParams = AbsListView.LayoutParams((width-50)/2, (width-50)/2)
        return promImage
    }

}