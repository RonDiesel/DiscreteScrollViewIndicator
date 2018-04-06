package app.diesel.discrete_scrollview_indicator;

import android.content.Context;
import android.support.annotation.DrawableRes
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.AdapterDataObserver
import android.util.AttributeSet;
import android.view.View
import android.widget.LinearLayout;
import com.yarolegovich.discretescrollview.DiscreteScrollView
import java.util.*
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat


class DiscreteScrollViewIndicator : LinearLayout {
    private lateinit var discreteScrollView: DiscreteScrollView
    private var indicatorSelected: Drawable;
    private var currentPosition = 0
    private val views: ArrayList<View> = ArrayList()
    var indicatorsSize = resources.getDimension(R.dimen.indicator_default_size).toInt()
    var indicatorsMargin = resources.getDimension(R.dimen.indicator_default_margin).toInt()


    init {
        indicatorSelected = ContextCompat.getDrawable(context, R.drawable.indicator_default)!!
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, @Nullable attrs: AttributeSet) : super(context, attrs) {



        val a = context.obtainStyledAttributes(attrs, R.styleable.DiscreteScrollViewIndicator)
        val count = a.indexCount
        for (i in 0 until count) {
            val attr = a.getIndex(i)
            when (attr) {

                R.styleable.DiscreteScrollViewIndicator_indicator_drawable -> indicatorSelected = a.getDrawable(attr)

                R.styleable.DiscreteScrollViewIndicator_indicator_size -> indicatorsSize = a.getDimension(attr, indicatorsSize.toFloat()).toInt()

                R.styleable.DiscreteScrollViewIndicator_indicator_margin -> indicatorsMargin = a.getDimension(attr, indicatorsMargin.toFloat()).toInt()

            }
        }
        a.recycle()

    }

    constructor(context: Context, @Nullable attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    fun setDiscreteScrolView(discreteScrollView: DiscreteScrollView) {
        this.discreteScrollView = discreteScrollView
        discreteScrollView.addOnItemChangedListener { viewHolder, adapterPosition ->
            changePosition(adapterPosition - currentPosition)
            currentPosition = adapterPosition
        }

        discreteScrollView.adapter.registerAdapterDataObserver(object : AdapterDataObserver() {
            override fun onChanged() {
                super.onChanged()
                createIndicators()
            }
        })
        createIndicators()
    }

    private fun changePosition(change: Int) {
        if (change == 0) return
        views.get(currentPosition).animate().setDuration(0).alpha(0.5f)
        views.get(currentPosition + change).animate().setDuration(0).alpha(1f)
    }


    fun setIndicators(@DrawableRes indicatorSelected: Int) {
        this.indicatorSelected = ContextCompat.getDrawable(context, indicatorSelected)!!
    }

    private fun createIndicators() {
        removeAllViews()
        views.clear()
        for (i in 0..discreteScrollView.adapter.itemCount - 1) {
            createIndicator(i)
        }

    }

    private fun createIndicator(pos: Int) {
        val view = View(context)
        val params = LayoutParams(indicatorsSize, indicatorsSize)
        params.setMargins(indicatorsMargin, indicatorsMargin, indicatorsMargin, indicatorsMargin)
        view.layoutParams = params

        view.setBackground(indicatorSelected)
        if (currentPosition == pos) view.alpha = 1f
        else view.alpha = 0.5f
        addView(view)
        views.add(view)
    }


}

