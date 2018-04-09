package app.diesel.discretescrollviewindicator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.diesel.discrete_scrollview_indicator.DiscreteScrollViewIndicator
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var discreteScrollView: DiscreteScrollView
    lateinit var discreteScrollViewIndicator : DiscreteScrollViewIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        discreteScrollView = findViewById(R.id.discreteScrollView)

        discreteScrollView.setItemTransformer(ScaleTransformer.Builder().setMaxScale(1f).setMinScale(0.8f).build() )

        discreteScrollViewIndicator = findViewById(R.id.indicator)
        val adapter = CardAdapter(this)
        discreteScrollView.adapter = adapter
        discreteScrollViewIndicator.setDiscreteScrolView(discreteScrollView)
    }
}
