package com.elyeproj.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.view_custom_component.view.*

class CustomComponent @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0,
        defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_custom_component, this, true)
        orientation = VERTICAL

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.custom_component_attributes, 0, 0)
            val title = resources.getText(typedArray
                    .getResourceId(R.styleable.custom_component_attributes_custom_component_title, R.string.component_one))

            my_title.text = title
            my_edit.hint = "${resources.getString(R.string.hint_text)} $title"

            typedArray.recycle()
        }
    }

}