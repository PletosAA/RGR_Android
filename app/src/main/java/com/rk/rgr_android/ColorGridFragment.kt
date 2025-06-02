package com.rk.rgr_android

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ColorGridFragment : Fragment(R.layout.fragment_grid), GridAdapter.OnItemClickListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycler = view.findViewById<RecyclerView>(R.id.recyclerGrid)
        recycler.layoutManager = GridLayoutManager(context, 4)
        recycler.adapter = GridAdapter(generateItems(), this)
    }

    private fun generateItems(): List<GridItem> = List(20) {
        val value = (1..99).random()
        val color = Color.rgb((0..255).random(), (0..255).random(), (0..255).random())
        GridItem(value, color)
    }

    override fun onItemClick(item: GridItem) {
        ColorValueDialog.newInstance(item.value).show(childFragmentManager, "color")
    }
}
